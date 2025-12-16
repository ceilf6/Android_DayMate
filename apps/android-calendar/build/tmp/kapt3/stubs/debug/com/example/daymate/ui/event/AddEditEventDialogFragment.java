package com.example.daymate.ui.event;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\u001a\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010!\u001a\u00020\u0014H\u0002J\b\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u0014H\u0002J$\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u000b2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\'H\u0002J$\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u000b2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\'H\u0002J\b\u0010+\u001a\u00020\u0014H\u0002J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u00a8\u00060"}, d2 = {"Lcom/example/daymate/ui/event/AddEditEventDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "_binding", "Lcom/example/daymate/databinding/DialogAddEditEventBinding;", "binding", "getBinding", "()Lcom/example/daymate/databinding/DialogAddEditEventBinding;", "event", "Lcom/example/daymate/data/Event;", "selectedEndDateTime", "Ljava/time/LocalDateTime;", "selectedStartDateTime", "viewModel", "Lcom/example/daymate/viewmodel/CalendarViewModel;", "getViewModel", "()Lcom/example/daymate/viewmodel/CalendarViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "loadEventData", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "view", "saveEvent", "setupClickListeners", "setupViews", "showDatePicker", "currentDate", "onDateSelected", "Lkotlin/Function1;", "showTimePicker", "currentTime", "onTimeSelected", "updateDateTimeDisplay", "updatePriorityPreview", "priorityPosition", "", "Companion", "app_debug"})
public final class AddEditEventDialogFragment extends androidx.fragment.app.DialogFragment {
    @org.jetbrains.annotations.Nullable
    private com.example.daymate.databinding.DialogAddEditEventBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable
    private com.example.daymate.data.Event event;
    @org.jetbrains.annotations.NotNull
    private java.time.LocalDateTime selectedStartDateTime;
    @org.jetbrains.annotations.NotNull
    private java.time.LocalDateTime selectedEndDateTime;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ARG_EVENT = "event";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ARG_SELECTED_DATE_TIME = "selected_date_time";
    @org.jetbrains.annotations.NotNull
    public static final com.example.daymate.ui.event.AddEditEventDialogFragment.Companion Companion = null;
    
    public AddEditEventDialogFragment() {
        super();
    }
    
    private final com.example.daymate.databinding.DialogAddEditEventBinding getBinding() {
        return null;
    }
    
    private final com.example.daymate.viewmodel.CalendarViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
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
    
    private final void setupClickListeners() {
    }
    
    private final void loadEventData() {
    }
    
    private final void updateDateTimeDisplay() {
    }
    
    private final void showDatePicker(java.time.LocalDateTime currentDate, kotlin.jvm.functions.Function1<? super java.time.LocalDateTime, kotlin.Unit> onDateSelected) {
    }
    
    private final void showTimePicker(java.time.LocalDateTime currentTime, kotlin.jvm.functions.Function1<? super java.time.LocalDateTime, kotlin.Unit> onTimeSelected) {
    }
    
    private final void saveEvent() {
    }
    
    private final void updatePriorityPreview(int priorityPosition) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/daymate/ui/event/AddEditEventDialogFragment$Companion;", "", "()V", "ARG_EVENT", "", "ARG_SELECTED_DATE_TIME", "newInstance", "Lcom/example/daymate/ui/event/AddEditEventDialogFragment;", "event", "Lcom/example/daymate/data/Event;", "selectedDateTime", "Ljava/time/LocalDateTime;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.daymate.ui.event.AddEditEventDialogFragment newInstance(@org.jetbrains.annotations.Nullable
        com.example.daymate.data.Event event, @org.jetbrains.annotations.Nullable
        java.time.LocalDateTime selectedDateTime) {
            return null;
        }
    }
}