package com.example.daymate.ui.dialog;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\u001a\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J\u0016\u0010&\u001a\u00020\u00132\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002J\u0016\u0010*\u001a\u00020\u00132\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006,"}, d2 = {"Lcom/example/daymate/ui/dialog/DailyEventsDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "_binding", "Lcom/example/daymate/databinding/DialogDailyEventsBinding;", "binding", "getBinding", "()Lcom/example/daymate/databinding/DialogDailyEventsBinding;", "eventsAdapter", "Lcom/example/daymate/ui/adapter/DailyEventsAdapter;", "selectedDate", "Ljava/time/LocalDate;", "viewModel", "Lcom/example/daymate/viewmodel/CalendarViewModel;", "getViewModel", "()Lcom/example/daymate/viewmodel/CalendarViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "loadDailyEvents", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onStart", "onViewCreated", "view", "setupClickListeners", "setupViews", "showEmptyState", "showEventsList", "events", "", "Lcom/example/daymate/data/Event;", "updateEventsList", "Companion", "android-calendar_debug"})
public final class DailyEventsDialogFragment extends androidx.fragment.app.DialogFragment {
    @org.jetbrains.annotations.Nullable
    private com.example.daymate.databinding.DialogDailyEventsBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    private java.time.LocalDate selectedDate;
    @org.jetbrains.annotations.Nullable
    private com.example.daymate.ui.adapter.DailyEventsAdapter eventsAdapter;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ARG_SELECTED_DATE = "selected_date";
    @org.jetbrains.annotations.NotNull
    public static final com.example.daymate.ui.dialog.DailyEventsDialogFragment.Companion Companion = null;
    
    public DailyEventsDialogFragment() {
        super();
    }
    
    private final com.example.daymate.databinding.DialogDailyEventsBinding getBinding() {
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
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
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
    
    private final void setupClickListeners() {
    }
    
    private final void loadDailyEvents() {
    }
    
    private final void updateEventsList(java.util.List<com.example.daymate.data.Event> events) {
    }
    
    private final void showEmptyState() {
    }
    
    private final void showEventsList(java.util.List<com.example.daymate.data.Event> events) {
    }
    
    @java.lang.Override
    public void onStart() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/daymate/ui/dialog/DailyEventsDialogFragment$Companion;", "", "()V", "ARG_SELECTED_DATE", "", "newInstance", "Lcom/example/daymate/ui/dialog/DailyEventsDialogFragment;", "selectedDate", "Ljava/time/LocalDate;", "android-calendar_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.daymate.ui.dialog.DailyEventsDialogFragment newInstance(@org.jetbrains.annotations.NotNull
        java.time.LocalDate selectedDate) {
            return null;
        }
    }
}