package com.example.daymate.service

import android.content.Context
import android.util.Log
import androidx.work.*
import com.example.daymate.data.Event
import com.example.daymate.utils.PermissionManager
import com.example.daymate.work.ReminderWorker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

class ReminderManager(private val context: Context) {
    
    companion object {
        private const val TAG = "ReminderManager"
    }
    
    private val workManager = WorkManager.getInstance(context)
    private val notificationService = ReminderNotificationService(context)
    
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
    
    fun cancelReminder(eventId: Long) {
        try {
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
