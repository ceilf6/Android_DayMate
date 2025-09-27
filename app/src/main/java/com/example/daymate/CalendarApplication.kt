package com.example.daymate

import android.app.Application
import com.example.daymate.data.CalendarDatabase

class CalendarApplication : Application() {
    
    val database by lazy { CalendarDatabase.getDatabase(this) }
    
    override fun onCreate() {
        super.onCreate()
    }
}
