package com.example.daymate.repository

import com.example.daymate.data.Event
import com.example.daymate.data.EventDao
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

class EventRepository(
    private val eventDao: EventDao
) {
    
    fun getAllEvents(): Flow<List<Event>> = eventDao.getAllEvents()
    
    suspend fun getEventById(id: Long): Event? = eventDao.getEventById(id)
    
    fun getEventsByDateRange(startDate: LocalDateTime, endDate: LocalDateTime): Flow<List<Event>> =
        eventDao.getEventsByDateRange(startDate, endDate)
    
    fun getEventsByDate(date: LocalDateTime): Flow<List<Event>> =
        eventDao.getEventsByDate(date)
    
    fun searchEvents(query: String): Flow<List<Event>> =
        eventDao.searchEvents("%$query%")
    
    fun getEventsByCategory(category: String): Flow<List<Event>> =
        eventDao.getEventsByCategory(category)
    
    fun getLunarEvents(): Flow<List<Event>> = eventDao.getLunarEvents()
    
    fun getAllCategories(): Flow<List<String>> = eventDao.getAllCategories()
    
    suspend fun insertEvent(event: Event): Long = eventDao.insertEvent(event)
    
    suspend fun updateEvent(event: Event) = eventDao.updateEvent(event)
    
    suspend fun deleteEvent(event: Event) = eventDao.deleteEvent(event)
    
    suspend fun deleteEventById(id: Long) = eventDao.deleteEventById(id)
    
    suspend fun deleteRecurringEvents(recurrenceId: Long) = eventDao.deleteRecurringEvents(recurrenceId)
}
