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
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DayView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    
    private var selectedDate: LocalDate = LocalDate.now()
    private var events: List<Event> = emptyList()
    
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val cellRect = Rect()
    private val gestureDetector = GestureDetector(context, DayViewGestureListener())
    
    private val timeTextSize = 36f
    private val eventTextSize = 32f
    private val padding = 16f
    private val timeColumnWidth = 120f
    
    private var cellWidth = 0f
    private var cellHeight = 0f
    private var hourHeight = 0f
    private val hourCount = 24
    private val headerHeight = 80f
    
    var onTimeSlotClicked: ((LocalDateTime) -> Unit)? = null
    var onEventClicked: ((Event) -> Unit)? = null
    var onDayChanged: ((LocalDate) -> Unit)? = null
    
    init {
        paint.textAlign = Paint.Align.CENTER
    }
    
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        cellWidth = width - timeColumnWidth - padding * 2
        cellHeight = height - headerHeight
        hourHeight = cellHeight / hourCount
    }
    
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        
        drawHeader(canvas)
        drawTimeGrid(canvas)
        drawEvents(canvas)
        drawTimeLabels(canvas)
    }
    
    private fun drawHeader(canvas: Canvas) {
        paint.textSize = 48f
        paint.color = ContextCompat.getColor(context, R.color.primary_text)
        
        val formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 EEEE")
        val dateText = selectedDate.format(formatter)
        
        canvas.drawText(
            dateText,
            width / 2f,
            headerHeight / 2f + paint.textSize / 3,
            paint
        )
    }
    
    private fun drawTimeGrid(canvas: Canvas) {
        paint.color = ContextCompat.getColor(context, R.color.divider)
        paint.strokeWidth = 1f
        
        val startX = timeColumnWidth + padding
        
        // 绘制垂直线
        canvas.drawLine(
            startX,
            headerHeight,
            startX,
            height.toFloat(),
            paint
        )
        
        // 绘制水平线
        for (i in 0..hourCount) {
            val y = headerHeight + i * hourHeight
            canvas.drawLine(
                timeColumnWidth,
                y,
                width.toFloat(),
                y,
                paint
            )
            
            // 绘制小时分隔线（更粗）
            if (i % 4 == 0) {
                paint.strokeWidth = 2f
                canvas.drawLine(
                    timeColumnWidth,
                    y,
                    width.toFloat(),
                    y,
                    paint
                )
                paint.strokeWidth = 1f
            }
        }
    }
    
    private fun drawTimeLabels(canvas: Canvas) {
        paint.textSize = timeTextSize
        paint.color = ContextCompat.getColor(context, R.color.secondary_text)
        paint.textAlign = Paint.Align.RIGHT
        
        for (hour in 0 until hourCount) {
            val y = headerHeight + hour * hourHeight + hourHeight / 2
            val timeText = String.format("%02d:00", hour)
            
            canvas.drawText(
                timeText,
                timeColumnWidth - 10f,
                y + paint.textSize / 3,
                paint
            )
        }
        
        paint.textAlign = Paint.Align.CENTER
    }
    
    private fun drawEvents(canvas: Canvas) {
        if (events.isEmpty()) return
        
        val startX = timeColumnWidth + padding
        
        events.forEach { event ->
            drawEvent(canvas, event, startX)
        }
    }
    
    private fun drawEvent(canvas: Canvas, event: Event, startX: Float) {
        val startHour = event.startTime.hour + event.startTime.minute / 60.0
        val endHour = event.endTime.hour + event.endTime.minute / 60.0
        
        val eventY = headerHeight + startHour * hourHeight
        val eventHeight = (endHour - startHour) * hourHeight
        
        cellRect.set(
            (startX + 2).toInt(),
            eventY.toInt(),
            (startX + cellWidth - 2).toInt(),
            (eventY + eventHeight).toInt()
        )
        
        // 绘制事件背景
        paint.color = ContextCompat.getColor(context, R.color.primary)
        canvas.drawRect(cellRect, paint)
        
        // 绘制事件边框
        paint.color = ContextCompat.getColor(context, R.color.primary_dark)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 2f
        canvas.drawRect(cellRect, paint)
        paint.style = Paint.Style.FILL
        
        // 绘制事件文字
        paint.color = ContextCompat.getColor(context, android.R.color.white)
        paint.textSize = eventTextSize
        
        val timeText = "${String.format("%02d:%02d", event.startTime.hour, event.startTime.minute)} - " +
                      "${String.format("%02d:%02d", event.endTime.hour, event.endTime.minute)}"
        
        val title = if (event.title.length > 20) {
            event.title.substring(0, 20) + "..."
        } else {
            event.title
        }
        
        // 绘制时间
        canvas.drawText(
            timeText,
            cellRect.centerX().toFloat(),
            cellRect.top + 40f,
            paint
        )
        
        // 绘制标题
        canvas.drawText(
            title,
            cellRect.centerX().toFloat(),
            cellRect.centerY().toFloat(),
            paint
        )
        
        // 绘制位置（如果有）
        if (!event.location.isNullOrEmpty()) {
            paint.textSize = 28f
            val location = if (event.location.length > 15) {
                event.location.substring(0, 15) + "..."
            } else {
                event.location
            }
            
            canvas.drawText(
                location,
                cellRect.centerX().toFloat(),
                cellRect.bottom - 20f,
                paint
            )
        }
    }
    
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }
    
    private inner class DayViewGestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onSingleTapUp(e: MotionEvent): Boolean {
            val startX = timeColumnWidth + padding
            
            if (e.x >= startX && e.y >= headerHeight) {
                val hour = ((e.y - headerHeight) / hourHeight).toInt()
                val minute = (((e.y - headerHeight) % hourHeight) / hourHeight * 60).toInt()
                val dateTime = selectedDate.atTime(hour, minute)
                onTimeSlotClicked?.invoke(dateTime)
                return true
            }
            return false
        }
        
        override fun onLongPress(e: MotionEvent) {
            val startX = timeColumnWidth + padding
            
            if (e.x >= startX && e.y >= headerHeight) {
                // 查找点击的事件
                events.forEach { event ->
                    val startHour = event.startTime.hour + event.startTime.minute / 60.0
                    val endHour = event.endTime.hour + event.endTime.minute / 60.0
                    val eventY = headerHeight + startHour * hourHeight
                    val eventHeight = (endHour - startHour) * hourHeight
                    
                    if (e.x >= startX && e.x <= startX + cellWidth &&
                        e.y >= eventY && e.y <= eventY + eventHeight) {
                        onEventClicked?.invoke(event)
                        return
                    }
                }
            }
        }
    }
    
    fun setSelectedDate(date: LocalDate) {
        selectedDate = date
        invalidate()
    }
    
    fun setSelectedDateProgrammatically(date: LocalDate) {
        selectedDate = date
        invalidate()
    }
    
    fun setEvents(events: List<Event>) {
        this.events = events
        invalidate()
    }
    
    fun getCurrentDate(): LocalDate = selectedDate
    
    fun previousDay() {
        selectedDate = selectedDate.minusDays(1)
        onDayChanged?.invoke(selectedDate)
        invalidate()
    }
    
    fun nextDay() {
        selectedDate = selectedDate.plusDays(1)
        onDayChanged?.invoke(selectedDate)
        invalidate()
    }
}
