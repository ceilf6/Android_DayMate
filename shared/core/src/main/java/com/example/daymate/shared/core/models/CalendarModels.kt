package com.example.daymate.shared.core.models

import java.time.LocalDate
import java.time.LocalDateTime

/**
 * 日历事件数据模型
 * 用于跨平台共享的核心数据结构
 */
data class CalendarEvent(
    val id: String,
    val title: String,
    val description: String? = null,
    val startDateTime: LocalDateTime,
    val endDateTime: LocalDateTime,
    val isAllDay: Boolean = false,
    val location: String? = null,
    val recurrenceRule: String? = null,
    val reminders: List<ReminderConfig> = emptyList(),
    val color: String? = null,
    val calendarId: String? = null,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)

/**
 * 提醒配置
 */
data class ReminderConfig(
    val minutesBefore: Int,
    val type: ReminderType = ReminderType.NOTIFICATION
)

enum class ReminderType {
    NOTIFICATION,
    EMAIL,
    SMS
}

/**
 * 农历日期信息
 */
data class LunarDate(
    val year: Int,
    val month: Int,
    val day: Int,
    val isLeapMonth: Boolean = false,
    val chineseYearName: String,
    val chineseMonthName: String,
    val chineseDayName: String,
    val solarTerm: String? = null,
    val festival: String? = null
)

/**
 * 日历视图类型
 */
enum class CalendarViewType {
    MONTH,
    WEEK,
    DAY,
    AGENDA
}
