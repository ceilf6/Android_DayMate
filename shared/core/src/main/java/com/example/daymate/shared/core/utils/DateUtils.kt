package com.example.daymate.shared.core.utils

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalAdjusters

/**
 * 日期工具类
 * 提供跨平台的日期计算和格式化功能
 */
object DateUtils {
    
    /**
     * 获取某月的所有日期（包括前后填充的日期）
     * 用于月视图显示
     */
    fun getDatesForMonthView(year: Int, month: Int): List<LocalDate> {
        val yearMonth = YearMonth.of(year, month)
        val firstDay = yearMonth.atDay(1)
        val lastDay = yearMonth.atEndOfMonth()
        
        // 获取第一天是周几
        val firstDayOfWeek = firstDay.dayOfWeek.value % 7 // 0=Sunday
        
        // 计算需要显示的第一天（可能是上个月的日期）
        val startDate = firstDay.minusDays(firstDayOfWeek.toLong())
        
        // 生成6周的日期（42天）
        return (0 until 42).map { startDate.plusDays(it.toLong()) }
    }
    
    /**
     * 获取某周的日期
     */
    fun getDatesForWeekView(date: LocalDate): List<LocalDate> {
        val startOfWeek = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY))
        return (0 until 7).map { startOfWeek.plusDays(it.toLong()) }
    }
    
    /**
     * 判断是否是今天
     */
    fun isToday(date: LocalDate): Boolean {
        return date == LocalDate.now()
    }
    
    /**
     * 判断是否在同一周
     */
    fun isSameWeek(date1: LocalDate, date2: LocalDate): Boolean {
        val week1 = date1.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
        val week2 = date2.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
        return week1 == week2
    }
    
    /**
     * 格式化日期
     */
    fun formatDate(date: LocalDate, pattern: String = "yyyy-MM-dd"): String {
        return date.format(DateTimeFormatter.ofPattern(pattern))
    }
    
    /**
     * 格式化时间
     */
    fun formatDateTime(dateTime: LocalDateTime, pattern: String = "yyyy-MM-dd HH:mm"): String {
        return dateTime.format(DateTimeFormatter.ofPattern(pattern))
    }
    
    /**
     * 计算两个日期之间的天数
     */
    fun daysBetween(start: LocalDate, end: LocalDate): Long {
        return ChronoUnit.DAYS.between(start, end)
    }
}
