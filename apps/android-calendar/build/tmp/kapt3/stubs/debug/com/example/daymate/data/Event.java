package com.example.daymate.data;

/**
 * 日历事件实体类
 * 基于RFC5545标准的iCalendar格式设计
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u00d9\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\f\u00a2\u0006\u0002\u0010\u001dJ\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u00103J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010?\u001a\u00020\u0010H\u00c6\u0003J\t\u0010@\u001a\u00020\u0014H\u00c6\u0003J\t\u0010A\u001a\u00020\u0016H\u00c6\u0003J\t\u0010B\u001a\u00020\tH\u00c6\u0003J\t\u0010C\u001a\u00020\tH\u00c6\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010G\u001a\u00020\u0005H\u00c6\u0003J\t\u0010H\u001a\u00020\fH\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010K\u001a\u00020\tH\u00c6\u0003J\t\u0010L\u001a\u00020\tH\u00c6\u0003J\t\u0010M\u001a\u00020\fH\u00c6\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010/J\u00e8\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001c\u001a\u00020\fH\u00c6\u0001\u00a2\u0006\u0002\u0010QJ\u0013\u0010R\u001a\u00020\f2\b\u0010S\u001a\u0004\u0018\u00010TH\u00d6\u0003J\t\u0010U\u001a\u00020\u0010H\u00d6\u0001J\t\u0010V\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u0017\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010!R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u001c\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0011\u0010\u0012\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\n\n\u0002\u00104\u001a\u0004\b2\u00103R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010!R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\u0018\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010$\u00a8\u0006W"}, d2 = {"Lcom/example/daymate/data/Event;", "Ljava/io/Serializable;", "id", "", "title", "", "description", "location", "startTime", "Ljava/time/LocalDateTime;", "endTime", "allDay", "", "recurrenceRule", "recurrenceId", "reminderMinutes", "", "category", "priority", "status", "Lcom/example/daymate/data/EventStatus;", "transparency", "Lcom/example/daymate/data/Transparency;", "createdAt", "updatedAt", "calendarId", "externalId", "lunarDate", "isLunarEvent", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/time/LocalDateTime;Ljava/time/LocalDateTime;ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;ILcom/example/daymate/data/EventStatus;Lcom/example/daymate/data/Transparency;Ljava/time/LocalDateTime;Ljava/time/LocalDateTime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAllDay", "()Z", "getCalendarId", "()Ljava/lang/String;", "getCategory", "getCreatedAt", "()Ljava/time/LocalDateTime;", "getDescription", "getEndTime", "getExternalId", "getId", "()J", "getLocation", "getLunarDate", "getPriority", "()I", "getRecurrenceId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRecurrenceRule", "getReminderMinutes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStartTime", "getStatus", "()Lcom/example/daymate/data/EventStatus;", "getTitle", "getTransparency", "()Lcom/example/daymate/data/Transparency;", "getUpdatedAt", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/time/LocalDateTime;Ljava/time/LocalDateTime;ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;ILcom/example/daymate/data/EventStatus;Lcom/example/daymate/data/Transparency;Ljava/time/LocalDateTime;Ljava/time/LocalDateTime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/example/daymate/data/Event;", "equals", "other", "", "hashCode", "toString", "android-calendar_debug"})
@androidx.room.Entity(tableName = "events", indices = {@androidx.room.Index(value = {"startTime"}), @androidx.room.Index(value = {"endTime"}), @androidx.room.Index(value = {"category"}), @androidx.room.Index(value = {"reminderMinutes"})})
public final class Event implements java.io.Serializable {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String title = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String description = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String location = null;
    @org.jetbrains.annotations.NotNull
    private final java.time.LocalDateTime startTime = null;
    @org.jetbrains.annotations.NotNull
    private final java.time.LocalDateTime endTime = null;
    private final boolean allDay = false;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String recurrenceRule = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Long recurrenceId = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Integer reminderMinutes = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String category = null;
    private final int priority = 0;
    @org.jetbrains.annotations.NotNull
    private final com.example.daymate.data.EventStatus status = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.daymate.data.Transparency transparency = null;
    @org.jetbrains.annotations.NotNull
    private final java.time.LocalDateTime createdAt = null;
    @org.jetbrains.annotations.NotNull
    private final java.time.LocalDateTime updatedAt = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String calendarId = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String externalId = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String lunarDate = null;
    private final boolean isLunarEvent = false;
    
    public Event(long id, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.Nullable
    java.lang.String description, @org.jetbrains.annotations.Nullable
    java.lang.String location, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime startTime, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime endTime, boolean allDay, @org.jetbrains.annotations.Nullable
    java.lang.String recurrenceRule, @org.jetbrains.annotations.Nullable
    java.lang.Long recurrenceId, @org.jetbrains.annotations.Nullable
    java.lang.Integer reminderMinutes, @org.jetbrains.annotations.Nullable
    java.lang.String category, int priority, @org.jetbrains.annotations.NotNull
    com.example.daymate.data.EventStatus status, @org.jetbrains.annotations.NotNull
    com.example.daymate.data.Transparency transparency, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime createdAt, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime updatedAt, @org.jetbrains.annotations.Nullable
    java.lang.String calendarId, @org.jetbrains.annotations.Nullable
    java.lang.String externalId, @org.jetbrains.annotations.Nullable
    java.lang.String lunarDate, boolean isLunarEvent) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLocation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDateTime getStartTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDateTime getEndTime() {
        return null;
    }
    
    public final boolean getAllDay() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getRecurrenceRule() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getRecurrenceId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getReminderMinutes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCategory() {
        return null;
    }
    
    public final int getPriority() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.daymate.data.EventStatus getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.daymate.data.Transparency getTransparency() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDateTime getCreatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDateTime getUpdatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCalendarId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getExternalId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLunarDate() {
        return null;
    }
    
    public final boolean isLunarEvent() {
        return false;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component11() {
        return null;
    }
    
    public final int component12() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.daymate.data.EventStatus component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.daymate.data.Transparency component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDateTime component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDateTime component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    public final boolean component20() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDateTime component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDateTime component6() {
        return null;
    }
    
    public final boolean component7() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.daymate.data.Event copy(long id, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.Nullable
    java.lang.String description, @org.jetbrains.annotations.Nullable
    java.lang.String location, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime startTime, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime endTime, boolean allDay, @org.jetbrains.annotations.Nullable
    java.lang.String recurrenceRule, @org.jetbrains.annotations.Nullable
    java.lang.Long recurrenceId, @org.jetbrains.annotations.Nullable
    java.lang.Integer reminderMinutes, @org.jetbrains.annotations.Nullable
    java.lang.String category, int priority, @org.jetbrains.annotations.NotNull
    com.example.daymate.data.EventStatus status, @org.jetbrains.annotations.NotNull
    com.example.daymate.data.Transparency transparency, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime createdAt, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime updatedAt, @org.jetbrains.annotations.Nullable
    java.lang.String calendarId, @org.jetbrains.annotations.Nullable
    java.lang.String externalId, @org.jetbrains.annotations.Nullable
    java.lang.String lunarDate, boolean isLunarEvent) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}