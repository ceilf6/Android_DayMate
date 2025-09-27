package com.example.daymate.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.daymate.data.CalendarDatabase
import com.example.daymate.data.Event
import com.example.daymate.service.ReminderNotificationService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime

class ReminderWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {
    
    private val database = CalendarDatabase.getDatabase(context)
    private val notificationService = ReminderNotificationService(context)
    
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val eventId = inputData.getLong("event_id", -1)
            val reminderMinutes = inputData.getInt("reminder_minutes", 0)
            
            if (eventId == -1L || reminderMinutes <= 0) {
                return@withContext Result.failure()
            }
            
            val event = database.eventDao().getEventById(eventId)
            if (event != null) {
                notificationService.showReminderNotification(event, reminderMinutes)
                Result.success()
            } else {
                Result.failure()
            }
        } catch (e: Exception) {
            Result.failure()
        }
    }
}
