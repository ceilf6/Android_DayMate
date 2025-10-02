package com.example.daymate.ui.calendar

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import com.example.daymate.R
import com.example.daymate.data.Event
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class MonthView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    
    private var yearMonth: YearMonth = YearMonth.now()
    private var selectedDate: LocalDate? = null
    private var events: List<Event> = emptyList()
    
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val cellRect = Rect()
    private val gestureDetector = GestureDetector(context, MonthViewGestureListener())
    
    private val dayTextSize = 48f
    private val eventTextSize = 32f
    private val padding = 16f
    
    private var cellWidth = 0f
    private var cellHeight = 0f
    
    var onDateSelected: ((LocalDate) -> Unit)? = null
    var onEventClicked: ((Event) -> Unit)? = null
    var onMonthChanged: ((YearMonth) -> Unit)? = null
    
    init {
        paint.textAlign = Paint.Align.CENTER
    }
    
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        cellWidth = (width - 2 * padding) / 7
        cellHeight = (height - 2 * padding) / 6
    }
    
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        
        drawWeekHeaders(canvas)
        drawCalendarGrid(canvas)
        drawEvents(canvas)
    }
    
    private fun drawWeekHeaders(canvas: Canvas) {
        paint.textSize = dayTextSize
        paint.color = ContextCompat.getColor(context, R.color.primary_text)
        
        val weekDays = arrayOf("日", "一", "二", "三", "四", "五", "六")
        
        for (i in weekDays.indices) {
            val x = padding + i * cellWidth + cellWidth / 2
            val y = padding + cellHeight / 2 + paint.textSize / 3
            
            canvas.drawText(weekDays[i], x, y, paint)
        }
    }
    
    private fun drawCalendarGrid(canvas: Canvas) {
        val firstDayOfMonth = yearMonth.atDay(1)
        val firstDayOfWeek = firstDayOfMonth.dayOfWeek.value % 7 // 转换为周日至周六
        val daysInMonth = yearMonth.lengthOfMonth()
        
        paint.textSize = dayTextSize
        
        var day = 1
        var row = 1
        
        // 绘制上个月的日期（灰色）
        val prevMonth = yearMonth.minusMonths(1)
        val daysInPrevMonth = prevMonth.lengthOfMonth()
        var prevDay = daysInPrevMonth - firstDayOfWeek + 1
        
        paint.color = ContextCompat.getColor(context, R.color.secondary_text)
        for (col in 0 until firstDayOfWeek) {
            drawDayCell(canvas, row, col, prevDay, false)
            prevDay++
        }
        
        // 绘制当月日期
        paint.color = ContextCompat.getColor(context, R.color.primary_text)
        for (dayOfMonth in 1..daysInMonth) {
            val col = (firstDayOfWeek + dayOfMonth - 1) % 7
            val currentRow = (firstDayOfWeek + dayOfMonth - 1) / 7 + 1
            
            val date = yearMonth.atDay(dayOfMonth)
            val isSelected = selectedDate == date
            val isToday = date == LocalDate.now()
            
            drawDayCell(canvas, currentRow, col, dayOfMonth, isSelected, isToday)
        }
        
        // 绘制下个月的日期（灰色）
        paint.color = ContextCompat.getColor(context, R.color.secondary_text)
        var nextDay = 1
        val totalCells = 42 // 6行 x 7列
        val usedCells = firstDayOfWeek + daysInMonth
        
        for (cell in usedCells until totalCells) {
            val row = cell / 7 + 1
            val col = cell % 7
            drawDayCell(canvas, row, col, nextDay, false)
            nextDay++
        }
    }
    
    private fun drawDayCell(
        canvas: Canvas,
        row: Int,
        col: Int,
        day: Int,
        isSelected: Boolean = false,
        isToday: Boolean = false
    ) {
        val x = padding + col * cellWidth
        val y = padding + row * cellHeight
        
        cellRect.set(
            x.toInt(),
            y.toInt(),
            (x + cellWidth).toInt(),
            (y + cellHeight).toInt()
        )
        
        // 绘制选中背景
        if (isSelected) {
            paint.color = ContextCompat.getColor(context, R.color.primary)
            canvas.drawCircle(
                cellRect.centerX().toFloat(),
                cellRect.centerY().toFloat(),
                cellWidth / 3,
                paint
            )
        }
        
        // 绘制今日背景
        if (isToday && !isSelected) {
            paint.color = ContextCompat.getColor(context, R.color.accent)
            canvas.drawCircle(
                cellRect.centerX().toFloat(),
                cellRect.centerY().toFloat(),
                cellWidth / 4,
                paint
            )
        }
        
        // 绘制日期文字
        paint.textSize = dayTextSize
        paint.color = if (isSelected || isToday) {
            ContextCompat.getColor(context, android.R.color.white)
        } else {
            ContextCompat.getColor(context, R.color.primary_text)
        }
        
        canvas.drawText(
            day.toString(),
            cellRect.centerX().toFloat(),
            cellRect.centerY().toFloat() + paint.textSize / 3,
            paint
        )
    }
    
    private fun drawEvents(canvas: Canvas) {
        if (events.isEmpty()) return
        
        paint.textSize = eventTextSize
        
        val eventsByDate = events.groupBy { event ->
            event.startTime.toLocalDate()
        }
        
        val firstDayOfMonth = yearMonth.atDay(1)
        val firstDayOfWeek = firstDayOfMonth.dayOfWeek.value % 7
        val daysInMonth = yearMonth.lengthOfMonth()
        
        eventsByDate.forEach { (date, dayEvents) ->
            if (YearMonth.from(date) == yearMonth) {
                val dayOfMonth = date.dayOfMonth
                val col = (firstDayOfWeek + dayOfMonth - 1) % 7
                val row = (firstDayOfWeek + dayOfMonth - 1) / 7 + 1
                
                val x = padding + col * cellWidth
                val y = padding + row * cellHeight
                
                // 绘制事件指示点
                val eventX = x + cellWidth - 20f
                val eventY = y + 10f
                
                paint.color = ContextCompat.getColor(context, R.color.accent)
                canvas.drawCircle(eventX, eventY, 8f, paint)
                
                // 如果有多个事件，绘制数字
                if (dayEvents.size > 1) {
                    paint.color = ContextCompat.getColor(context, android.R.color.white)
                    paint.textSize = 24f
                    canvas.drawText(
                        dayEvents.size.toString(),
                        eventX,
                        eventY + paint.textSize / 3,
                        paint
                    )
                }
            }
        }
    }
    
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }
    
    private inner class MonthViewGestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onSingleTapUp(e: MotionEvent): Boolean {
            val col = ((e.x - padding) / cellWidth).toInt()
            val row = ((e.y - padding) / cellHeight).toInt()
            
            if (col in 0..6 && row in 0..6) {
                handleCellClick(col, row)
                return true
            }
            return false
        }
    }
    
    private fun handleCellClick(col: Int, row: Int) {
        val firstDayOfMonth = yearMonth.atDay(1)
        val firstDayOfWeek = firstDayOfMonth.dayOfWeek.value % 7
        val daysInMonth = yearMonth.lengthOfMonth()
        
        val cellIndex = row * 7 + col
        
        when {
            cellIndex < firstDayOfWeek -> {
                // 上个月的日期
                val prevMonth = yearMonth.minusMonths(1)
                val daysInPrevMonth = prevMonth.lengthOfMonth()
                val day = daysInPrevMonth - firstDayOfWeek + 1 + cellIndex
                val date = prevMonth.atDay(day)
                selectedDate = date
                onDateSelected?.invoke(date)
                yearMonth = prevMonth
                invalidate()
            }
            cellIndex < firstDayOfWeek + daysInMonth -> {
                // 当月的日期
                val day = cellIndex - firstDayOfWeek + 1
                val date = yearMonth.atDay(day)
                selectedDate = date
                onDateSelected?.invoke(date)
                invalidate()
            }
            else -> {
                // 下个月的日期
                val nextMonth = yearMonth.plusMonths(1)
                val day = cellIndex - firstDayOfWeek - daysInMonth + 1
                val date = nextMonth.atDay(day)
                selectedDate = date
                onDateSelected?.invoke(date)
                yearMonth = nextMonth
                invalidate()
            }
        }
    }
    
    fun setYearMonth(yearMonth: YearMonth) {
        this.yearMonth = yearMonth
        invalidate()
    }
    
    fun setYearMonthProgrammatically(yearMonth: YearMonth) {
        this.yearMonth = yearMonth
        invalidate()
    }
    
    fun setSelectedDate(date: LocalDate?) {
        this.selectedDate = date
        invalidate()
    }
    
    fun setEvents(events: List<Event>) {
        this.events = events
        invalidate()
    }
    
    fun getCurrentYearMonth(): YearMonth = yearMonth
    
    fun previousMonth() {
        yearMonth = yearMonth.minusMonths(1)
        onMonthChanged?.invoke(yearMonth)
        invalidate()
    }
    
    fun nextMonth() {
        yearMonth = yearMonth.plusMonths(1)
        onMonthChanged?.invoke(yearMonth)
        invalidate()
    }
}
