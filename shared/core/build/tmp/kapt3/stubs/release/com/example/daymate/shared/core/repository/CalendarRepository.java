package com.example.daymate.shared.core.repository;

/**
 * 日历事件仓库接口
 * 定义跨平台的数据访问接口
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\n\u001a\u00020\u000bH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bH\u00a6@\u00f8\u0001\u0002\u00a2\u0006\u0002\u0010\rJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u00a6@\u00f8\u0001\u0002\u00a2\u0006\u0002\u0010\u0013J\'\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u00a6@\u00f8\u0001\u0002\u00a2\u0006\u0002\u0010\u0017J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00100\u00192\u0006\u0010\u0011\u001a\u00020\u0012H&J\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u001b\u001a\u00020\u000bH\u00a6@\u00f8\u0001\u0002\u00a2\u0006\u0002\u0010\rJ*\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u001d\u0010\u0007\u0082\u0002\u000f\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/example/daymate/shared/core/repository/CalendarRepository;", "", "createEvent", "Lkotlin/Result;", "Lcom/example/daymate/shared/core/models/CalendarEvent;", "event", "createEvent-gIAlu-s", "(Lcom/example/daymate/shared/core/models/CalendarEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteEvent", "", "eventId", "", "deleteEvent-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEventById", "getEventsForDay", "", "date", "Ljava/time/LocalDate;", "(Ljava/time/LocalDate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEventsInRange", "startDate", "endDate", "(Ljava/time/LocalDate;Ljava/time/LocalDate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeEventsForDay", "Lkotlinx/coroutines/flow/Flow;", "searchEvents", "query", "updateEvent", "updateEvent-gIAlu-s", "core_release"})
public abstract interface CalendarRepository {
    
    /**
     * 获取某一天的所有事件
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getEventsForDay(@org.jetbrains.annotations.NotNull
    java.time.LocalDate date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.daymate.shared.core.models.CalendarEvent>> $completion);
    
    /**
     * 获取某个时间范围内的事件
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getEventsInRange(@org.jetbrains.annotations.NotNull
    java.time.LocalDate startDate, @org.jetbrains.annotations.NotNull
    java.time.LocalDate endDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.daymate.shared.core.models.CalendarEvent>> $completion);
    
    /**
     * 观察某一天的事件变化
     */
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.daymate.shared.core.models.CalendarEvent>> observeEventsForDay(@org.jetbrains.annotations.NotNull
    java.time.LocalDate date);
    
    /**
     * 根据ID获取事件
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getEventById(@org.jetbrains.annotations.NotNull
    java.lang.String eventId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.daymate.shared.core.models.CalendarEvent> $completion);
    
    /**
     * 搜索事件
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object searchEvents(@org.jetbrains.annotations.NotNull
    java.lang.String query, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.daymate.shared.core.models.CalendarEvent>> $completion);
}