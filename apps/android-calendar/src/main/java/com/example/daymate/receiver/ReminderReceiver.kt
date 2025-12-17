package com.example.daymate.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.daymate.data.CalendarDatabase
import com.example.daymate.service.ReminderNotificationService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ReminderReceiver : BroadcastReceiver() {

    companion object {
        private const val TAG = "ReminderReceiver"

        const val ACTION_REMINDER = "com.example.daymate.ACTION_REMINDER"
        const val EXTRA_EVENT_ID = "event_id"
        const val EXTRA_REMINDER_MINUTES = "reminder_minutes"
    }

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != ACTION_REMINDER) return

        val eventId = intent.getLongExtra(EXTRA_EVENT_ID, -1)
        val reminderMinutes = intent.getIntExtra(EXTRA_REMINDER_MINUTES, 0)

        Log.d(TAG, "Received reminder broadcast, eventId=$eventId, reminderMinutes=$reminderMinutes")

        if (eventId <= 0L || reminderMinutes <= 0) return

        val pendingResult = goAsync()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val database = CalendarDatabase.getDatabase(context)
                val event = database.eventDao().getEventById(eventId)

                if (event == null) {
                    Log.w(TAG, "Event not found for eventId=$eventId")
                    return@launch
                }

                val notificationService = ReminderNotificationService(context)
                notificationService.showReminderNotification(event, reminderMinutes)
            } catch (e: Exception) {
                Log.e(TAG, "Error handling reminder broadcast", e)
            } finally {
                pendingResult.finish()
            }
        }
    }
}
