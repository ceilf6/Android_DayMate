package com.example.daymate.work

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.daymate.data.CalendarDatabase
import com.example.daymate.data.Event
import com.example.daymate.service.ReminderNotificationService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ReminderWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {
    
    companion object {
        private const val TAG = "ReminderWorker"
    }
    
    private val database = CalendarDatabase.getDatabase(context)
    private val notificationService = ReminderNotificationService(context)
    
    override suspend fun doWork(): Result {
        return try {
            val eventId = inputData.getLong("event_id", -1)
            val reminderMinutes = inputData.getInt("reminder_minutes", 0)
            
            Log.d(TAG, "Processing reminder for event ID: $eventId, reminderMinutes: $reminderMinutes")
            
            if (eventId == -1L) {
                Log.e(TAG, "Invalid event ID: $eventId")
                return Result.failure()
            }
            
            if (reminderMinutes <= 0) {
                Log.e(TAG, "Invalid reminder minutes: $reminderMinutes")
                return Result.failure()
            }
            
            val event = withContext(Dispatchers.IO) {
                database.eventDao().getEventById(eventId)
            }
            
            if (event != null) {
                Log.d(TAG, "Found event: ${event.title}, showing notification")
                notificationService.showReminderNotification(event, reminderMinutes)
                Result.success()
            } else {
                Log.w(TAG, "Event not found for ID: $eventId")
                Result.failure()
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error in doWork", e)
            Result.failure()
        }
    }
}
