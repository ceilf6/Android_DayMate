package com.example.daymate.utils

import com.example.daymate.data.Event
import com.example.daymate.data.EventStatus
import com.example.daymate.data.Transparency
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

object ICalendarUtils {
    
    private val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss")
    
    /**
     * 将事件列表导出为iCalendar格式
     */
    fun exportToICalendar(events: List<Event>): String {
        val calendar = StringBuilder()
        
        // iCalendar文件头
        calendar.appendLine("BEGIN:VCALENDAR")
        calendar.appendLine("VERSION:2.0")
        calendar.appendLine("PRODID:-//DayMate//DayMate Calendar//EN")
        calendar.appendLine("CALSCALE:GREGORIAN")
        calendar.appendLine("METHOD:PUBLISH")
        
        // 添加每个事件
        events.forEach { event ->
            calendar.appendLine("BEGIN:VEVENT")
            calendar.appendLine("UID:${event.id}@daymate.local")
            calendar.appendLine("DTSTAMP:${formatDateTime(LocalDateTime.now())}")
            calendar.appendLine("DTSTART:${formatDateTime(event.startTime)}")
            calendar.appendLine("DTEND:${formatDateTime(event.endTime)}")
            
            if (event.allDay) {
                calendar.appendLine("DTSTART;VALUE=DATE:${formatDate(event.startTime)}")
                calendar.appendLine("DTEND;VALUE=DATE:${formatDate(event.endTime.plusDays(1))}")
            }
            
            calendar.appendLine("SUMMARY:${escapeText(event.title)}")
            
            event.description?.let {
                calendar.appendLine("DESCRIPTION:${escapeText(it)}")
            }
            
            event.location?.let {
                calendar.appendLine("LOCATION:${escapeText(it)}")
            }
            
            event.category?.let {
                calendar.appendLine("CATEGORIES:${escapeText(it)}")
            }
            
            // 状态
            val status = when (event.status) {
                EventStatus.CONFIRMED -> "CONFIRMED"
                EventStatus.TENTATIVE -> "TENTATIVE"
                EventStatus.CANCELLED -> "CANCELLED"
            }
            calendar.appendLine("STATUS:$status")
            
            // 优先级
            if (event.priority > 0) {
                val priority = when (event.priority) {
                    1 -> "1" // 高
                    5 -> "5" // 中
                    9 -> "9" // 低
                    else -> "0"
                }
                calendar.appendLine("PRIORITY:$priority")
            }
            
            // 透明度
            val transparency = when (event.transparency) {
                Transparency.OPAQUE -> "OPAQUE"
                Transparency.TRANSPARENT -> "TRANSPARENT"
            }
            calendar.appendLine("TRANSP:$transparency")
            
            // 提醒
            event.reminderMinutes?.let { minutes ->
                calendar.appendLine("BEGIN:VALARM")
                calendar.appendLine("ACTION:DISPLAY")
                calendar.appendLine("DESCRIPTION:${escapeText(event.title)}")
                calendar.appendLine("TRIGGER:-PT${minutes}M")
                calendar.appendLine("END:VALARM")
            }
            
            // 重复规则
            event.recurrenceRule?.let {
                calendar.appendLine("RRULE:$it")
            }
            
            calendar.appendLine("END:VEVENT")
        }
        
        calendar.appendLine("END:VCALENDAR")
        
        return calendar.toString()
    }
    
    /**
     * 从iCalendar格式导入事件
     */
    fun importFromICalendar(content: String): List<Event> {
        val events = mutableListOf<Event>()
        val lines = content.split("\n").map { it.trim() }
        
        var currentEvent: MutableMap<String, String>? = null
        var inEvent = false
        
        for (line in lines) {
            when {
                line == "BEGIN:VEVENT" -> {
                    inEvent = true
                    currentEvent = mutableMapOf()
                }
                line == "END:VEVENT" -> {
                    inEvent = false
                    currentEvent?.let { eventData ->
                        val event = parseEventFromMap(eventData)
                        if (event != null) {
                            events.add(event)
                        }
                    }
                    currentEvent = null
                }
                inEvent && currentEvent != null -> {
                    parseEventProperty(line, currentEvent)
                }
            }
        }
        
        return events
    }
    
    private fun parseEventProperty(line: String, eventData: MutableMap<String, String>) {
        val colonIndex = line.indexOf(':')
        if (colonIndex == -1) return
        
        val property = line.substring(0, colonIndex)
        val value = line.substring(colonIndex + 1)
        
        when {
            property.startsWith("SUMMARY") -> eventData["SUMMARY"] = unescapeText(value)
            property.startsWith("DESCRIPTION") -> eventData["DESCRIPTION"] = unescapeText(value)
            property.startsWith("LOCATION") -> eventData["LOCATION"] = unescapeText(value)
            property.startsWith("CATEGORIES") -> eventData["CATEGORIES"] = unescapeText(value)
            property.startsWith("DTSTART") -> {
                if (property.contains("VALUE=DATE")) {
                    eventData["DTSTART_DATE"] = value
                } else {
                    eventData["DTSTART"] = value
                }
            }
            property.startsWith("DTEND") -> {
                if (property.contains("VALUE=DATE")) {
                    eventData["DTEND_DATE"] = value
                } else {
                    eventData["DTEND"] = value
                }
            }
            property.startsWith("STATUS") -> eventData["STATUS"] = value
            property.startsWith("PRIORITY") -> eventData["PRIORITY"] = value
            property.startsWith("TRANSP") -> eventData["TRANSP"] = value
            property.startsWith("RRULE") -> eventData["RRULE"] = value
        }
    }
    
    private fun parseEventFromMap(eventData: Map<String, String>): Event? {
        val title = eventData["SUMMARY"] ?: return null
        
        // 解析时间
        val startTime = when {
            eventData.containsKey("DTSTART_DATE") -> {
                parseDate(eventData["DTSTART_DATE"]!!)?.atStartOfDay()
            }
            eventData.containsKey("DTSTART") -> {
                parseDateTime(eventData["DTSTART"]!!)
            }
            else -> null
        } ?: return null
        
        val endTime = when {
            eventData.containsKey("DTEND_DATE") -> {
                parseDate(eventData["DTEND_DATE"]!!)?.atStartOfDay()
            }
            eventData.containsKey("DTEND") -> {
                parseDateTime(eventData["DTEND"]!!)
            }
            else -> startTime.plusHours(1)
        }
        
        val allDay = eventData.containsKey("DTSTART_DATE")
        
        // 解析状态
        val status = when (eventData["STATUS"]) {
            "CONFIRMED" -> EventStatus.CONFIRMED
            "TENTATIVE" -> EventStatus.TENTATIVE
            "CANCELLED" -> EventStatus.CANCELLED
            else -> EventStatus.CONFIRMED
        }
        
        // 解析优先级
        val priority = when (eventData["PRIORITY"]) {
            "1" -> 1
            "5" -> 5
            "9" -> 9
            else -> 0
        }
        
        // 解析透明度
        val transparency = when (eventData["TRANSP"]) {
            "TRANSPARENT" -> Transparency.TRANSPARENT
            else -> Transparency.OPAQUE
        }
        
        return Event(
            title = title,
            description = eventData["DESCRIPTION"],
            location = eventData["LOCATION"],
            category = eventData["CATEGORIES"],
            startTime = startTime,
            endTime = endTime ?: startTime.plusHours(1),
            allDay = allDay,
            priority = priority,
            status = status,
            transparency = transparency,
            recurrenceRule = eventData["RRULE"],
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
    }
    
    private fun formatDateTime(dateTime: LocalDateTime): String {
        return dateTime.format(dateTimeFormatter)
    }
    
    private fun formatDate(dateTime: LocalDateTime): String {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
    }
    
    private fun parseDateTime(dateTimeString: String): LocalDateTime? {
        return try {
            LocalDateTime.parse(dateTimeString, dateTimeFormatter)
        } catch (e: Exception) {
            null
        }
    }
    
    private fun parseDate(dateString: String): java.time.LocalDate? {
        return try {
            java.time.LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyyMMdd"))
        } catch (e: Exception) {
            null
        }
    }
    
    private fun escapeText(text: String): String {
        return text
            .replace("\\", "\\\\")
            .replace(";", "\\;")
            .replace(",", "\\,")
            .replace("\n", "\\n")
            .replace("\r", "")
    }
    
    private fun unescapeText(text: String): String {
        return text
            .replace("\\n", "\n")
            .replace("\\,", ",")
            .replace("\\;", ";")
            .replace("\\\\", "\\")
    }
}
