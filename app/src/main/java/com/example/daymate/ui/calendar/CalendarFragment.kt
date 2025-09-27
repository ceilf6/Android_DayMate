package com.example.daymate.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.daymate.R
import com.example.daymate.data.CalendarDatabase
import com.example.daymate.databinding.FragmentCalendarBinding
import com.example.daymate.repository.EventRepository
import com.example.daymate.ui.event.AddEditEventDialogFragment
import com.example.daymate.ui.event.EventDetailsDialogFragment
import com.example.daymate.ui.importexport.ImportExportDialogFragment
import com.example.daymate.viewmodel.CalendarViewModel
import com.example.daymate.viewmodel.CalendarViewModelFactory
import com.example.daymate.viewmodel.CalendarViewMode
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.YearMonth
import java.time.format.DateTimeFormatter

class CalendarFragment : Fragment() {
    
    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!
    
    private val viewModel: CalendarViewModel by viewModels {
        val database = CalendarDatabase.getDatabase(requireContext())
        val repository = EventRepository(database.eventDao())
        CalendarViewModelFactory(repository, requireContext())
    }
    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy年MM月")
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupViews()
        observeViewModel()
    }
    
    private fun setupViews() {
        // 设置视图模式切换
        binding.btnMonthView.setOnClickListener {
            viewModel.setViewMode(CalendarViewMode.MONTH)
            updateViewMode(CalendarViewMode.MONTH)
        }
        
        binding.btnWeekView.setOnClickListener {
            viewModel.setViewMode(CalendarViewMode.WEEK)
            updateViewMode(CalendarViewMode.WEEK)
        }
        
        binding.btnDayView.setOnClickListener {
            viewModel.setViewMode(CalendarViewMode.DAY)
            updateViewMode(CalendarViewMode.DAY)
        }
        
        // 设置导航按钮
        binding.btnPrevious.setOnClickListener {
            when (viewModel.viewMode.value) {
                CalendarViewMode.MONTH -> binding.monthView.previousMonth()
                CalendarViewMode.WEEK -> binding.weekView.previousWeek()
                CalendarViewMode.DAY -> binding.dayView.previousDay()
            }
        }
        
        binding.btnNext.setOnClickListener {
            when (viewModel.viewMode.value) {
                CalendarViewMode.MONTH -> binding.monthView.nextMonth()
                CalendarViewMode.WEEK -> binding.weekView.nextWeek()
                CalendarViewMode.DAY -> binding.dayView.nextDay()
            }
        }
        
        // 设置日历视图回调
        setupCalendarCallbacks()
        
        // 添加事件按钮
        binding.fabAddEvent.setOnClickListener {
            showAddEventDialog()
        }
        
        // 导入导出按钮
        binding.btnImportExport.setOnClickListener {
            showImportExportDialog()
        }
        
        // 默认显示月视图
        updateViewMode(CalendarViewMode.MONTH)
    }
    
    private fun setupCalendarCallbacks() {
        // 月视图回调
        binding.monthView.onDateSelected = { date ->
            viewModel.setSelectedDate(date.atStartOfDay())
        }
        
        // 周视图回调
        binding.weekView.onDateSelected = { date ->
            viewModel.setSelectedDate(date.atStartOfDay())
        }
        binding.weekView.onTimeSlotClicked = { dateTime ->
            viewModel.setSelectedDate(dateTime)
            // TODO: 打开添加事件对话框
            showAddEventDialog(dateTime)
        }
        
        // 日视图回调
        binding.dayView.onTimeSlotClicked = { dateTime ->
            viewModel.setSelectedDate(dateTime)
            // TODO: 打开添加事件对话框
            showAddEventDialog(dateTime)
        }
        binding.dayView.onEventClicked = { event ->
            viewModel.selectEvent(event)
            // TODO: 打开事件详情对话框
            showEventDetailsDialog(event)
        }
    }
    
    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.viewMode.collect { mode ->
                updateViewMode(mode)
            }
        }
        
        lifecycleScope.launch {
            viewModel.selectedDate.collect { dateTime ->
                updateDateDisplay(dateTime)
            }
        }
        
        lifecycleScope.launch {
            viewModel.events.collect { events ->
                updateEventsDisplay(events)
            }
        }
    }
    
    private fun updateViewMode(mode: CalendarViewMode) {
        // 隐藏所有视图
        binding.monthView.visibility = View.GONE
        binding.weekView.visibility = View.GONE
        binding.dayView.visibility = View.GONE
        
        // 显示对应视图
        when (mode) {
            CalendarViewMode.MONTH -> {
                binding.monthView.visibility = View.VISIBLE
                binding.btnMonthView.isSelected = true
                binding.btnWeekView.isSelected = false
                binding.btnDayView.isSelected = false
            }
            CalendarViewMode.WEEK -> {
                binding.weekView.visibility = View.VISIBLE
                binding.btnMonthView.isSelected = false
                binding.btnWeekView.isSelected = true
                binding.btnDayView.isSelected = false
            }
            CalendarViewMode.DAY -> {
                binding.dayView.visibility = View.VISIBLE
                binding.btnMonthView.isSelected = false
                binding.btnWeekView.isSelected = false
                binding.btnDayView.isSelected = true
            }
        }
    }
    
    private fun updateDateDisplay(dateTime: LocalDateTime) {
        val date = dateTime.toLocalDate()
        
        when (viewModel.viewMode.value) {
            CalendarViewMode.MONTH -> {
                val yearMonth = YearMonth.from(date)
                binding.monthView.setYearMonth(yearMonth)
                binding.monthView.setSelectedDate(date)
                binding.tvCurrentDate.text = yearMonth.format(dateFormatter)
            }
            CalendarViewMode.WEEK -> {
                binding.weekView.setWeekStartDate(date)
                binding.weekView.setSelectedDate(date)
                val weekStart = binding.weekView.getCurrentWeekStartDate()
                val weekEnd = weekStart.plusDays(6)
                binding.tvCurrentDate.text = "${weekStart.monthValue}/${weekStart.dayOfMonth} - ${weekEnd.monthValue}/${weekEnd.dayOfMonth}"
            }
            CalendarViewMode.DAY -> {
                binding.dayView.setSelectedDate(date)
                binding.tvCurrentDate.text = date.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 EEEE"))
            }
        }
    }
    
    private fun updateEventsDisplay(events: List<com.example.daymate.data.Event>) {
        binding.monthView.setEvents(events)
        binding.weekView.setEvents(events)
        
        // 过滤当日事件
        val selectedDate = viewModel.selectedDate.value.toLocalDate()
        val todayEvents = events.filter { event ->
            event.startTime.toLocalDate() == selectedDate
        }
        binding.dayView.setEvents(todayEvents)
    }
    
    private fun showAddEventDialog(selectedDateTime: LocalDateTime? = null) {
        val dialog = AddEditEventDialogFragment.newInstance(selectedDateTime = selectedDateTime)
        dialog.show(parentFragmentManager, "AddEventDialog")
    }
    
    private fun showEventDetailsDialog(event: com.example.daymate.data.Event) {
        val dialog = EventDetailsDialogFragment.newInstance(event)
        dialog.show(parentFragmentManager, "EventDetailsDialog")
    }
    
    private fun showImportExportDialog() {
        val dialog = ImportExportDialogFragment.newInstance()
        dialog.show(parentFragmentManager, "ImportExportDialog")
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
    companion object {
        fun newInstance(): CalendarFragment {
            return CalendarFragment()
        }
    }
}
