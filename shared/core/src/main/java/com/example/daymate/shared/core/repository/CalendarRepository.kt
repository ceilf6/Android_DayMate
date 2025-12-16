package com.example.daymate.shared.core.repository

import com.example.daymate.shared.core.models.CalendarEvent
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

/**
 * 日历事件仓库接口
 * 定义跨平台的数据访问接口
 */
interface CalendarRepository {
    
    /**
     * 获取某一天的所有事件
     */
    suspend fun getEventsForDay(date: LocalDate): List<CalendarEvent>
    
    /**
     * 获取某个时间范围内的事件
     */
    suspend fun getEventsInRange(startDate: LocalDate, endDate: LocalDate): List<CalendarEvent>
    
    /**
     * 观察某一天的事件变化
     */
    fun observeEventsForDay(date: LocalDate): Flow<List<CalendarEvent>>
    
    /**
     * 创建新事件
     */
    suspend fun createEvent(event: CalendarEvent): Result<CalendarEvent>
    
    /**
     * 更新事件
     */
    suspend fun updateEvent(event: CalendarEvent): Result<CalendarEvent>
    
    /**
     * 删除事件
     */
    suspend fun deleteEvent(eventId: String): Result<Unit>
    
    /**
     * 根据ID获取事件
     */
    suspend fun getEventById(eventId: String): CalendarEvent?
    
    /**
     * 搜索事件
     */
    suspend fun searchEvents(query: String): List<CalendarEvent>
}
