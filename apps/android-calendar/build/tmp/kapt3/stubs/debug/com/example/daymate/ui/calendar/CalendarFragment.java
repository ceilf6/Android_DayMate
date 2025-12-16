package com.example.daymate.ui.calendar;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 82\u00020\u0001:\u00018B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\u0014\u0010 \u001a\u00020\u00122\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010\'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u0012H\u0002J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\"H\u0002J\u0010\u0010,\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u00020%H\u0002J\u0016\u00102\u001a\u00020\u00122\f\u00103\u001a\b\u0012\u0004\u0012\u00020(04H\u0002J\u0010\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u000207H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u00069"}, d2 = {"Lcom/example/daymate/ui/calendar/CalendarFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/daymate/databinding/FragmentCalendarBinding;", "binding", "getBinding", "()Lcom/example/daymate/databinding/FragmentCalendarBinding;", "dateFormatter", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "viewModel", "Lcom/example/daymate/viewmodel/CalendarViewModel;", "getViewModel", "()Lcom/example/daymate/viewmodel/CalendarViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "observeViewModel", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupCalendarCallbacks", "setupViews", "showAddEventDialog", "selectedDateTime", "Ljava/time/LocalDateTime;", "showDailyEventsDialog", "date", "Ljava/time/LocalDate;", "showEventDetailsDialog", "event", "Lcom/example/daymate/data/Event;", "showImportExportDialog", "updateDateDisplay", "dateTime", "updateDateDisplayForDay", "updateDateDisplayForMonth", "yearMonth", "Ljava/time/YearMonth;", "updateDateDisplayForWeek", "weekStartDate", "updateEventsDisplay", "events", "", "updateViewMode", "mode", "Lcom/example/daymate/viewmodel/CalendarViewMode;", "Companion", "android-calendar_debug"})
public final class CalendarFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.example.daymate.databinding.FragmentCalendarBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    private final java.time.format.DateTimeFormatter dateFormatter = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.daymate.ui.calendar.CalendarFragment.Companion Companion = null;
    
    public CalendarFragment() {
        super();
    }
    
    private final com.example.daymate.databinding.FragmentCalendarBinding getBinding() {
        return null;
    }
    
    private final com.example.daymate.viewmodel.CalendarViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupViews() {
    }
    
    private final void setupCalendarCallbacks() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void updateViewMode(com.example.daymate.viewmodel.CalendarViewMode mode) {
    }
    
    private final void updateDateDisplay(java.time.LocalDateTime dateTime) {
    }
    
    private final void updateEventsDisplay(java.util.List<com.example.daymate.data.Event> events) {
    }
    
    private final void updateDateDisplayForMonth(java.time.YearMonth yearMonth) {
    }
    
    private final void updateDateDisplayForWeek(java.time.LocalDate weekStartDate) {
    }
    
    private final void updateDateDisplayForDay(java.time.LocalDate date) {
    }
    
    private final void showAddEventDialog(java.time.LocalDateTime selectedDateTime) {
    }
    
    private final void showEventDetailsDialog(com.example.daymate.data.Event event) {
    }
    
    private final void showDailyEventsDialog(java.time.LocalDate date) {
    }
    
    private final void showImportExportDialog() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/daymate/ui/calendar/CalendarFragment$Companion;", "", "()V", "newInstance", "Lcom/example/daymate/ui/calendar/CalendarFragment;", "android-calendar_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.daymate.ui.calendar.CalendarFragment newInstance() {
            return null;
        }
    }
}