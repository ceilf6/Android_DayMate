package com.example.daymate.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eH\'J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\u000eH\'J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\u000e2\u0006\u0010\u0014\u001a\u00020\u0010H\'J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\'J$\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\u000e2\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\'J\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\u001c\u001a\u00020\u0017H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\u000eH\'J\u0019\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\u000e2\u0006\u0010!\u001a\u00020\u0010H\'J\u0019\u0010\"\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/example/daymate/data/EventDao;", "", "deleteEvent", "", "event", "Lcom/example/daymate/data/Event;", "(Lcom/example/daymate/data/Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteEventById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecurringEvents", "recurrenceId", "getAllCategories", "Lkotlinx/coroutines/flow/Flow;", "", "", "getAllEvents", "getEventById", "getEventsByCategory", "category", "getEventsByDate", "date", "Ljava/time/LocalDateTime;", "getEventsByDateRange", "startDate", "endDate", "getEventsWithReminders", "currentTime", "(Ljava/time/LocalDateTime;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLunarEvents", "insertEvent", "searchEvents", "searchQuery", "updateEvent", "app_release"})
@androidx.room.Dao
public abstract interface EventDao {
    
    @androidx.room.Query(value = "SELECT * FROM events ORDER BY startTime ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.daymate.data.Event>> getAllEvents();
    
    @androidx.room.Query(value = "SELECT * FROM events WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getEventById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.daymate.data.Event> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM events WHERE startTime >= :startDate AND startTime <= :endDate ORDER BY startTime ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.daymate.data.Event>> getEventsByDateRange(@org.jetbrains.annotations.NotNull
    java.time.LocalDateTime startDate, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime endDate);
    
    @androidx.room.Query(value = "SELECT * FROM events WHERE DATE(startTime) = DATE(:date) ORDER BY startTime ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.daymate.data.Event>> getEventsByDate(@org.jetbrains.annotations.NotNull
    java.time.LocalDateTime date);
    
    @androidx.room.Query(value = "SELECT * FROM events WHERE title LIKE :searchQuery OR description LIKE :searchQuery OR location LIKE :searchQuery")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.daymate.data.Event>> searchEvents(@org.jetbrains.annotations.NotNull
    java.lang.String searchQuery);
    
    @androidx.room.Query(value = "SELECT * FROM events WHERE category = :category ORDER BY startTime ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.daymate.data.Event>> getEventsByCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category);
    
    @androidx.room.Query(value = "SELECT * FROM events WHERE isLunarEvent = 1 ORDER BY startTime ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.daymate.data.Event>> getLunarEvents();
    
    @androidx.room.Query(value = "SELECT DISTINCT category FROM events WHERE category IS NOT NULL ORDER BY category ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<java.lang.String>> getAllCategories();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertEvent(@org.jetbrains.annotations.NotNull
    com.example.daymate.data.Event event, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateEvent(@org.jetbrains.annotations.NotNull
    com.example.daymate.data.Event event, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteEvent(@org.jetbrains.annotations.NotNull
    com.example.daymate.data.Event event, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM events WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteEventById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM events WHERE recurrenceId = :recurrenceId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteRecurringEvents(long recurrenceId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM events WHERE reminderMinutes IS NOT NULL AND startTime > :currentTime ORDER BY startTime ASC")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getEventsWithReminders(@org.jetbrains.annotations.NotNull
    java.time.LocalDateTime currentTime, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.daymate.data.Event>> $completion);
}