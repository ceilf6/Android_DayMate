package com.example.daymate.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daymate.data.Event
import com.example.daymate.repository.EventRepository
import com.example.daymate.service.ReminderManager
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class CalendarViewModel(
    private val repository: EventRepository,
    private val context: Context
) : ViewModel() {
    
    private val reminderManager = ReminderManager(context)
    
    // 公开repository，以便其他地方可以访问
    val eventRepository: EventRepository = repository
    
    private val _selectedDate = MutableStateFlow(LocalDateTime.now())
    val selectedDate: StateFlow<LocalDateTime> = _selectedDate.asStateFlow()
    
    private val _viewMode = MutableStateFlow(CalendarViewMode.MONTH)
    val viewMode: StateFlow<CalendarViewMode> = _viewMode.asStateFlow()
    
    private val _events = MutableStateFlow<List<Event>>(emptyList())
    val events: StateFlow<List<Event>> = _events.asStateFlow()
    
    private val _selectedEvent = MutableStateFlow<Event?>(null)
    val selectedEvent: StateFlow<Event?> = _selectedEvent.asStateFlow()
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    // 用于取消之前的加载任务，避免重复加载
    private var loadEventsJob: Job? = null
    
    init {
        loadEvents()
    }
    
    fun setSelectedDate(date: LocalDateTime) {
        _selectedDate.value = date
        // 不立即加载，因为会在视图切换时统一加载
    }
    
    fun setViewMode(mode: CalendarViewMode) {
        _viewMode.value = mode
        loadEventsForCurrentView()
    }
    
    private fun loadEvents() {
        // 取消之前的加载任务
        loadEventsJob?.cancel()
        loadEventsJob = viewModelScope.launch {
            repository.getAllEvents().collect { eventList ->
                _events.value = eventList
            }
        }
    }
    
    private fun loadEventsForCurrentView() {
        // 取消之前的加载任务，避免重复加载
        loadEventsJob?.cancel()
        loadEventsJob = viewModelScope.launch {
            val startDate = when (_viewMode.value) {
                CalendarViewMode.MONTH -> _selectedDate.value.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0)
                CalendarViewMode.WEEK -> {
                    val dayOfWeek = _selectedDate.value.dayOfWeek.value
                    _selectedDate.value.minusDays((dayOfWeek - 1).toLong()).withHour(0).withMinute(0).withSecond(0)
                }
                CalendarViewMode.DAY -> _selectedDate.value.withHour(0).withMinute(0).withSecond(0)
            }
            
            val endDate = when (_viewMode.value) {
                CalendarViewMode.MONTH -> startDate.plusMonths(1).minusDays(1).withHour(23).withMinute(59).withSecond(59)
                CalendarViewMode.WEEK -> startDate.plusDays(6).withHour(23).withMinute(59).withSecond(59)
                CalendarViewMode.DAY -> startDate.withHour(23).withMinute(59).withSecond(59)
            }
            
            repository.getEventsByDateRange(startDate, endDate).collect { eventList ->
                _events.value = eventList
            }
        }
    }
    
    fun selectEvent(event: Event) {
        _selectedEvent.value = event
    }
    
    fun clearSelectedEvent() {
        _selectedEvent.value = null
    }
    
    fun addEvent(event: Event) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val eventId = repository.insertEvent(event)
                val eventWithId = event.copy(id = eventId)
                reminderManager.scheduleReminder(eventWithId)
                loadEventsForCurrentView()
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun updateEvent(event: Event) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                repository.updateEvent(event)
                reminderManager.scheduleReminder(event)
                loadEventsForCurrentView()
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun deleteEvent(event: Event) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                repository.deleteEvent(event)
                reminderManager.cancelReminder(event.id)
                loadEventsForCurrentView()
                if (_selectedEvent.value?.id == event.id) {
                    clearSelectedEvent()
                }
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun searchEvents(query: String) {
        viewModelScope.launch {
            repository.searchEvents(query).collect { eventList ->
                _events.value = eventList
            }
        }
    }
}

enum class CalendarViewMode {
    MONTH, WEEK, DAY
}
