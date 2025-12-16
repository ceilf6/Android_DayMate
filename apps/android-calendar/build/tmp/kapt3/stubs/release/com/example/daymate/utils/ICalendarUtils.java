package com.example.daymate.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0014\u0010\t\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0012\u001a\u00020\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u001e\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001aH\u0002J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/example/daymate/utils/ICalendarUtils;", "", "()V", "dateTimeFormatter", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "escapeText", "", "text", "exportToICalendar", "events", "", "Lcom/example/daymate/data/Event;", "formatDate", "dateTime", "Ljava/time/LocalDateTime;", "formatDateTime", "importFromICalendar", "content", "parseDate", "Ljava/time/LocalDate;", "dateString", "parseDateTime", "dateTimeString", "parseEventFromMap", "eventData", "", "parseEventProperty", "", "line", "", "unescapeText", "app_release"})
public final class ICalendarUtils {
    private static final java.time.format.DateTimeFormatter dateTimeFormatter = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.daymate.utils.ICalendarUtils INSTANCE = null;
    
    private ICalendarUtils() {
        super();
    }
    
    /**
     * 将事件列表导出为iCalendar格式
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String exportToICalendar(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.daymate.data.Event> events) {
        return null;
    }
    
    /**
     * 从iCalendar格式导入事件
     */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.daymate.data.Event> importFromICalendar(@org.jetbrains.annotations.NotNull
    java.lang.String content) {
        return null;
    }
    
    private final void parseEventProperty(java.lang.String line, java.util.Map<java.lang.String, java.lang.String> eventData) {
    }
    
    private final com.example.daymate.data.Event parseEventFromMap(java.util.Map<java.lang.String, java.lang.String> eventData) {
        return null;
    }
    
    private final java.lang.String formatDateTime(java.time.LocalDateTime dateTime) {
        return null;
    }
    
    private final java.lang.String formatDate(java.time.LocalDateTime dateTime) {
        return null;
    }
    
    private final java.time.LocalDateTime parseDateTime(java.lang.String dateTimeString) {
        return null;
    }
    
    private final java.time.LocalDate parseDate(java.lang.String dateString) {
        return null;
    }
    
    private final java.lang.String escapeText(java.lang.String text) {
        return null;
    }
    
    private final java.lang.String unescapeText(java.lang.String text) {
        return null;
    }
}