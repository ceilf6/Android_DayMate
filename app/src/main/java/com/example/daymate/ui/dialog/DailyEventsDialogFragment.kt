package com.example.daymate.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daymate.data.CalendarDatabase
import com.example.daymate.data.Event
import com.example.daymate.databinding.DialogDailyEventsBinding
import com.example.daymate.repository.EventRepository
import com.example.daymate.ui.adapter.DailyEventsAdapter
import com.example.daymate.ui.event.AddEditEventDialogFragment
import com.example.daymate.ui.event.EventDetailsDialogFragment
import com.example.daymate.viewmodel.CalendarViewModel
import com.example.daymate.viewmodel.CalendarViewModelFactory
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DailyEventsDialogFragment : DialogFragment() {

    private var _binding: DialogDailyEventsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CalendarViewModel by viewModels {
        val database = CalendarDatabase.getDatabase(requireContext())
        val repository = EventRepository(database.eventDao())
        CalendarViewModelFactory(repository, requireContext())
    }

    private lateinit var selectedDate: LocalDate
    private var eventsAdapter: DailyEventsAdapter? = null

    companion object {
        private const val ARG_SELECTED_DATE = "selected_date"

        fun newInstance(selectedDate: LocalDate): DailyEventsDialogFragment {
            val fragment = DailyEventsDialogFragment()
            val args = Bundle()
            // 将LocalDate转换为字符串来避免序列化问题
            args.putString(ARG_SELECTED_DATE, selectedDate.toString())
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val dateString = it.getString(ARG_SELECTED_DATE)
            selectedDate = LocalDate.parse(dateString)
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setCanceledOnTouchOutside(true)
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogDailyEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
        setupClickListeners()
        loadDailyEvents()
    }

    private fun setupViews() {
        // 设置标题
        val dateFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日")
        binding.tvDateTitle.text = "${selectedDate.format(dateFormatter)}的事件"

        // 设置RecyclerView
        binding.recyclerViewEvents.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setupClickListeners() {
        // 关闭按钮
        binding.btnClose.setOnClickListener {
            dismiss()
        }

        // 添加事件按钮
        binding.btnAddEvent.setOnClickListener {
            val addEventDialog = AddEditEventDialogFragment.newInstance(
                null, 
                selectedDate.atTime(9, 0)
            )
            addEventDialog.show(parentFragmentManager, "AddEventDialog")
            dismiss()
        }
    }

    private fun loadDailyEvents() {
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                // 获取当天的事件
                val startDateTime = selectedDate.atStartOfDay()
                val endDateTime = selectedDate.atTime(23, 59, 59)
                
                viewModel.eventRepository.getEventsByDateRange(startDateTime, endDateTime)
                    .collect { events ->
                        updateEventsList(events)
                    }
            } catch (e: Exception) {
                e.printStackTrace()
                showEmptyState()
            }
        }
    }

    private fun updateEventsList(events: List<Event>) {
        if (events.isEmpty()) {
            showEmptyState()
        } else {
            showEventsList(events)
        }
    }

    private fun showEmptyState() {
        binding.recyclerViewEvents.visibility = View.GONE
        binding.layoutEmptyState.visibility = View.VISIBLE
    }

    private fun showEventsList(events: List<Event>) {
        binding.layoutEmptyState.visibility = View.GONE
        binding.recyclerViewEvents.visibility = View.VISIBLE

        // 按时间排序事件
        val sortedEvents = events.sortedWith(compareBy<Event> { it.allDay }
            .thenBy { it.startTime })

        eventsAdapter = DailyEventsAdapter(sortedEvents) { event ->
            // 点击事件，显示详情
            val detailsDialog = EventDetailsDialogFragment.newInstance(event)
            detailsDialog.show(parentFragmentManager, "EventDetailsDialog")
            dismiss()
        }

        binding.recyclerViewEvents.adapter = eventsAdapter
    }

    override fun onStart() {
        super.onStart()
        // 设置对话框宽度
        dialog?.window?.setLayout(
            (resources.displayMetrics.widthPixels * 0.9).toInt(),
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
