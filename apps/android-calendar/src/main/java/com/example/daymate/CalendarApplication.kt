package com.example.daymate

import android.app.Application
import com.example.daymate.data.CalendarDatabase
import com.example.daymate.service.ReminderManager

class CalendarApplication : Application() {
    
    val database by lazy { CalendarDatabase.getDatabase(this) }
    val reminderManager by lazy { ReminderManager(this) }
    
    override fun onCreate() {
        super.onCreate()
        
        // 应用启动时重新安排所有提醒
        reminderManager.rescheduleReminders()
    }
}
