package com.example.daymate.shared.core.utils;

/**
 * 日期工具类
 * 提供跨平台的日期计算和格式化功能
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\tJ\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000b\u001a\u00020\tJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\n\u001a\u00020\u0006J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u0006\u00a8\u0006\u001a"}, d2 = {"Lcom/example/daymate/shared/core/utils/DateUtils;", "", "()V", "daysBetween", "", "start", "Ljava/time/LocalDate;", "end", "formatDate", "", "date", "pattern", "formatDateTime", "dateTime", "Ljava/time/LocalDateTime;", "getDatesForMonthView", "", "year", "", "month", "getDatesForWeekView", "isSameWeek", "", "date1", "date2", "isToday", "core_release"})
public final class DateUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.example.daymate.shared.core.utils.DateUtils INSTANCE = null;
    
    private DateUtils() {
        super();
    }
    
    /**
     * 获取某月的所有日期（包括前后填充的日期）
     * 用于月视图显示
     */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.time.LocalDate> getDatesForMonthView(int year, int month) {
        return null;
    }
    
    /**
     * 获取某周的日期
     */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.time.LocalDate> getDatesForWeekView(@org.jetbrains.annotations.NotNull
    java.time.LocalDate date) {
        return null;
    }
    
    /**
     * 判断是否是今天
     */
    public final boolean isToday(@org.jetbrains.annotations.NotNull
    java.time.LocalDate date) {
        return false;
    }
    
    /**
     * 判断是否在同一周
     */
    public final boolean isSameWeek(@org.jetbrains.annotations.NotNull
    java.time.LocalDate date1, @org.jetbrains.annotations.NotNull
    java.time.LocalDate date2) {
        return false;
    }
    
    /**
     * 格式化日期
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String formatDate(@org.jetbrains.annotations.NotNull
    java.time.LocalDate date, @org.jetbrains.annotations.NotNull
    java.lang.String pattern) {
        return null;
    }
    
    /**
     * 格式化时间
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String formatDateTime(@org.jetbrains.annotations.NotNull
    java.time.LocalDateTime dateTime, @org.jetbrains.annotations.NotNull
    java.lang.String pattern) {
        return null;
    }
    
    /**
     * 计算两个日期之间的天数
     */
    public final long daysBetween(@org.jetbrains.annotations.NotNull
    java.time.LocalDate start, @org.jetbrains.annotations.NotNull
    java.time.LocalDate end) {
        return 0L;
    }
}