package com.example.daymate.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

@Dao
interface EventDao {
    
    @Query("SELECT * FROM events ORDER BY startTime ASC")
    fun getAllEvents(): Flow<List<Event>>
    
    @Query("SELECT * FROM events WHERE id = :id")
    suspend fun getEventById(id: Long): Event?
    
    @Query("SELECT * FROM events WHERE startTime >= :startDate AND startTime <= :endDate ORDER BY startTime ASC")
    fun getEventsByDateRange(startDate: LocalDateTime, endDate: LocalDateTime): Flow<List<Event>>
    
    @Query("SELECT * FROM events WHERE DATE(startTime) = DATE(:date) ORDER BY startTime ASC")
    fun getEventsByDate(date: LocalDateTime): Flow<List<Event>>
    
    @Query("SELECT * FROM events WHERE title LIKE :searchQuery OR description LIKE :searchQuery OR location LIKE :searchQuery")
    fun searchEvents(searchQuery: String): Flow<List<Event>>
    
    @Query("SELECT * FROM events WHERE category = :category ORDER BY startTime ASC")
    fun getEventsByCategory(category: String): Flow<List<Event>>
    
    @Query("SELECT * FROM events WHERE isLunarEvent = 1 ORDER BY startTime ASC")
    fun getLunarEvents(): Flow<List<Event>>
    
    @Query("SELECT DISTINCT category FROM events WHERE category IS NOT NULL ORDER BY category ASC")
    fun getAllCategories(): Flow<List<String>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvent(event: Event): Long
    
    @Update
    suspend fun updateEvent(event: Event)
    
    @Delete
    suspend fun deleteEvent(event: Event)
    
    @Query("DELETE FROM events WHERE id = :id")
    suspend fun deleteEventById(id: Long)
    
    @Query("DELETE FROM events WHERE recurrenceId = :recurrenceId")
    suspend fun deleteRecurringEvents(recurrenceId: Long)
    
    @Query("SELECT * FROM events WHERE reminderMinutes IS NOT NULL AND startTime > :currentTime ORDER BY startTime ASC")
    suspend fun getEventsWithReminders(currentTime: LocalDateTime): List<Event>
}
