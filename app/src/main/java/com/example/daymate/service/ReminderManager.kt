package com.example.daymate.service

import android.content.Context
import androidx.work.*
import com.example.daymate.data.Event
import com.example.daymate.work.ReminderWorker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

class ReminderManager(private val context: Context) {
    
    private val workManager = WorkManager.getInstance(context)
    private val notificationService = ReminderNotificationService(context)
    
    fun scheduleReminder(event: Event) {
        // 取消现有的提醒
        cancelReminder(event.id)
        
        // 如果没有设置提醒，直接返回
        val reminderMinutes = event.reminderMinutes ?: return
        
        val reminderTime = event.startTime.minusMinutes(reminderMinutes.toLong())
        val now = LocalDateTime.now()
        
        // 如果提醒时间已经过了，不设置提醒
        if (reminderTime.isBefore(now)) {
            return
        }
        
        val delay = Duration.between(now, reminderTime).toMinutes()
        
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
            .setRequiresBatteryNotLow(true)
            .build()
        
        val reminderWork = OneTimeWorkRequestBuilder<ReminderWorker>()
            .setInputData(
                Data.Builder()
                    .putLong("event_id", event.id)
                    .putInt("reminder_minutes", reminderMinutes)
                    .build()
            )
            .setConstraints(constraints)
            .setInitialDelay(delay, TimeUnit.MINUTES)
            .addTag("reminder_${event.id}")
            .build()
        
        workManager.enqueue(reminderWork)
    }
    
    fun cancelReminder(eventId: Long) {
        workManager.cancelAllWorkByTag("reminder_$eventId")
        notificationService.cancelReminderNotification(eventId)
    }
    
    fun cancelAllReminders() {
        workManager.cancelAllWorkByTag("reminder")
        notificationService.cancelAllReminderNotifications()
    }
    
    fun rescheduleReminders() {
        // 取消所有现有提醒
        cancelAllReminders()
        
        // 重新安排所有有提醒的事件
        CoroutineScope(Dispatchers.IO).launch {
            val events = getEventsWithReminders()
            events.forEach { event ->
                scheduleReminder(event)
            }
        }
    }
    
    private suspend fun getEventsWithReminders(): List<Event> {
        return try {
            val database = com.example.daymate.data.CalendarDatabase.getDatabase(context)
            var result = emptyList<Event>()
            database.eventDao().getAllEvents().collect { events ->
                result = events.filter { it.reminderMinutes != null && it.startTime.isAfter(LocalDateTime.now()) }
            }
            result
        } catch (e: Exception) {
            emptyList()
        }
    }
}
