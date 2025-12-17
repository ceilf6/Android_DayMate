package com.example.daymate.service

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.work.*
import com.example.daymate.data.Event
import com.example.daymate.receiver.ReminderReceiver
import com.example.daymate.utils.PermissionManager
import com.example.daymate.work.ReminderWorker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.concurrent.TimeUnit

class ReminderManager(private val context: Context) {
    
    companion object {
        private const val TAG = "ReminderManager"
    }
    
    private val workManager = WorkManager.getInstance(context)
    private val notificationService = ReminderNotificationService(context)
    private val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    
    fun scheduleReminder(event: Event) {
        // 检查通知权限
        if (!PermissionManager.hasNotificationPermission(context)) {
            Log.w(TAG, "No notification permission, skipping reminder for event: ${event.title}")
            return
        }
        
        // 取消现有的提醒
        cancelReminder(event.id)
        
        // 如果没有设置提醒，直接返回
        val reminderMinutes = event.reminderMinutes ?: return
        
        val reminderTime = event.startTime.minusMinutes(reminderMinutes.toLong())
        val now = LocalDateTime.now()
        
        // 如果提醒时间已经过了，不设置提醒
        if (reminderTime.isBefore(now)) {
            Log.d(TAG, "Reminder time has passed for event: ${event.title}")
            return
        }

        // 优先使用 AlarmManager（精确），不可用时回退到 WorkManager
        val scheduledByAlarm = scheduleExactAlarm(eventId = event.id, reminderMinutes = reminderMinutes, reminderTime = reminderTime)
        if (scheduledByAlarm) {
            Log.d(TAG, "Scheduled exact-alarm reminder for event: ${event.title}")
            return
        }
        
        try {
            val delayMillis = Duration.between(now, reminderTime).toMillis()
            if (delayMillis <= 0) {
                Log.d(TAG, "Reminder delay is non-positive for event: ${event.title}")
                return
            }
            
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
                .setRequiresBatteryNotLow(false)  // 改为false，避免低电量时不提醒
                .build()
            
            val reminderWork = OneTimeWorkRequestBuilder<ReminderWorker>()
                .setInputData(
                    Data.Builder()
                        .putLong("event_id", event.id)
                        .putInt("reminder_minutes", reminderMinutes)
                        .build()
                )
                .setConstraints(constraints)
                .setInitialDelay(delayMillis, TimeUnit.MILLISECONDS)
                .addTag("reminder")
                .addTag("reminder_${event.id}")
                .build()
            
            workManager.enqueue(reminderWork)
            Log.d(TAG, "Scheduled reminder for event: ${event.title}, delayMillis: $delayMillis")
        } catch (e: Exception) {
            Log.e(TAG, "Error scheduling reminder for event: ${event.title}", e)
        }
    }

    private fun scheduleExactAlarm(eventId: Long, reminderMinutes: Int, reminderTime: LocalDateTime): Boolean {
        return try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                if (!alarmManager.canScheduleExactAlarms()) {
                    Log.w(TAG, "Exact alarm not allowed by system settings; falling back to WorkManager")
                    return false
                }
            }

            val triggerAtMillis = reminderTime
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli()

            val pendingIntent = buildReminderPendingIntent(eventId = eventId, reminderMinutes = reminderMinutes)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerAtMillis, pendingIntent)
            } else {
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerAtMillis, pendingIntent)
            }

            true
        } catch (e: Exception) {
            Log.e(TAG, "Error scheduling exact alarm", e)
            false
        }
    }

    private fun buildReminderPendingIntent(eventId: Long, reminderMinutes: Int): PendingIntent {
        val intent = Intent(context, ReminderReceiver::class.java).apply {
            action = ReminderReceiver.ACTION_REMINDER
            putExtra(ReminderReceiver.EXTRA_EVENT_ID, eventId)
            putExtra(ReminderReceiver.EXTRA_REMINDER_MINUTES, reminderMinutes)
        }

        val requestCode = (eventId % Int.MAX_VALUE).toInt()
        return PendingIntent.getBroadcast(
            context,
            requestCode,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }
    
    fun cancelReminder(eventId: Long) {
        try {
            // 取消 AlarmManager 的精确提醒
            val pendingIntent = buildReminderPendingIntent(eventId = eventId, reminderMinutes = 1)
            alarmManager.cancel(pendingIntent)
            pendingIntent.cancel()

            workManager.cancelAllWorkByTag("reminder_$eventId")
            notificationService.cancelReminderNotification(eventId)
            Log.d(TAG, "Cancelled reminder for event ID: $eventId")
        } catch (e: Exception) {
            Log.e(TAG, "Error cancelling reminder for event ID: $eventId", e)
        }
    }
    
    fun cancelAllReminders() {
        try {
            workManager.cancelAllWorkByTag("reminder")
            notificationService.cancelAllReminderNotifications()
            Log.d(TAG, "Cancelled all reminders")

            // 尽量取消所有未来事件的 AlarmManager 提醒
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val database = com.example.daymate.data.CalendarDatabase.getDatabase(context)
                    val events = database.eventDao().getEventsWithReminders(LocalDateTime.now())
                    events.forEach { event ->
                        val pendingIntent = buildReminderPendingIntent(eventId = event.id, reminderMinutes = 1)
                        alarmManager.cancel(pendingIntent)
                        pendingIntent.cancel()
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Error cancelling exact alarms", e)
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error cancelling all reminders", e)
        }
    }
    
    fun rescheduleReminders() {
        // 取消所有现有提醒
        cancelAllReminders()
        
        // 重新安排所有有提醒的事件
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val events = getEventsWithReminders()
                Log.d(TAG, "Rescheduling ${events.size} events with reminders")
                events.forEach { event ->
                    scheduleReminder(event)
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error rescheduling reminders", e)
            }
        }
    }
    
    private suspend fun getEventsWithReminders(): List<Event> {
        return try {
            val database = com.example.daymate.data.CalendarDatabase.getDatabase(context)
            database.eventDao().getEventsWithReminders(LocalDateTime.now())
        } catch (e: Exception) {
            Log.e(TAG, "Error getting events with reminders", e)
            emptyList()
        }
    }
}
