package com.example.daymate.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\nJ\u0006\u0010(\u001a\u00020&J\u000e\u0010)\u001a\u00020&2\u0006\u0010\'\u001a\u00020\nJ\b\u0010*\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020&H\u0002J\u000e\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020&2\u0006\u0010\'\u001a\u00020\nJ\u000e\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u000eJ\u000e\u00102\u001a\u00020&2\u0006\u00103\u001a\u00020\u0012J\u000e\u00104\u001a\u00020&2\u0006\u0010\'\u001a\u00020\nR\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0019\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019\u00a8\u00065"}, d2 = {"Lcom/example/daymate/viewmodel/CalendarViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/daymate/repository/EventRepository;", "context", "Landroid/content/Context;", "(Lcom/example/daymate/repository/EventRepository;Landroid/content/Context;)V", "_events", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/daymate/data/Event;", "_isLoading", "", "_selectedDate", "Ljava/time/LocalDateTime;", "kotlin.jvm.PlatformType", "_selectedEvent", "_viewMode", "Lcom/example/daymate/viewmodel/CalendarViewMode;", "eventRepository", "getEventRepository", "()Lcom/example/daymate/repository/EventRepository;", "events", "Lkotlinx/coroutines/flow/StateFlow;", "getEvents", "()Lkotlinx/coroutines/flow/StateFlow;", "isLoading", "loadEventsJob", "Lkotlinx/coroutines/Job;", "reminderManager", "Lcom/example/daymate/service/ReminderManager;", "selectedDate", "getSelectedDate", "selectedEvent", "getSelectedEvent", "viewMode", "getViewMode", "addEvent", "", "event", "clearSelectedEvent", "deleteEvent", "loadEvents", "loadEventsForCurrentView", "searchEvents", "query", "", "selectEvent", "setSelectedDate", "date", "setViewMode", "mode", "updateEvent", "app_release"})
public final class CalendarViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.daymate.repository.EventRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.daymate.service.ReminderManager reminderManager = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.daymate.repository.EventRepository eventRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.time.LocalDateTime> _selectedDate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.time.LocalDateTime> selectedDate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.daymate.viewmodel.CalendarViewMode> _viewMode = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.daymate.viewmodel.CalendarViewMode> viewMode = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.daymate.data.Event>> _events = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.daymate.data.Event>> events = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.daymate.data.Event> _selectedEvent = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.daymate.data.Event> selectedEvent = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job loadEventsJob;
    
    public CalendarViewModel(@org.jetbrains.annotations.NotNull
    com.example.daymate.repository.EventRepository repository, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.daymate.repository.EventRepository getEventRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.time.LocalDateTime> getSelectedDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.daymate.viewmodel.CalendarViewMode> getViewMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.daymate.data.Event>> getEvents() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.daymate.data.Event> getSelectedEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    public final void setSelectedDate(@org.jetbrains.annotations.NotNull
    java.time.LocalDateTime date) {
    }
    
    public final void setViewMode(@org.jetbrains.annotations.NotNull
    com.example.daymate.viewmodel.CalendarViewMode mode) {
    }
    
    private final void loadEvents() {
    }
    
    private final void loadEventsForCurrentView() {
    }
    
    public final void selectEvent(@org.jetbrains.annotations.NotNull
    com.example.daymate.data.Event event) {
    }
    
    public final void clearSelectedEvent() {
    }
    
    public final void addEvent(@org.jetbrains.annotations.NotNull
    com.example.daymate.data.Event event) {
    }
    
    public final void updateEvent(@org.jetbrains.annotations.NotNull
    com.example.daymate.data.Event event) {
    }
    
    public final void deleteEvent(@org.jetbrains.annotations.NotNull
    com.example.daymate.data.Event event) {
    }
    
    public final void searchEvents(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
}