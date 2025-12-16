package com.example.daymate.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/example/daymate/utils/LunarUtils;", "", "()V", "lunarDays", "", "", "[Ljava/lang/String;", "lunarMonths", "getLunarDateString", "solarDate", "Ljava/time/LocalDate;", "getLunarYear", "isLunarHoliday", "app_debug"})
public final class LunarUtils {
    
    /**
     * 农历月份名称
     */
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String[] lunarMonths = {"\u6b63", "\u4e8c", "\u4e09", "\u56db", "\u4e94", "\u516d", "\u4e03", "\u516b", "\u4e5d", "\u5341", "\u51ac", "\u814a"};
    
    /**
     * 农历日期名称
     */
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String[] lunarDays = {"\u521d\u4e00", "\u521d\u4e8c", "\u521d\u4e09", "\u521d\u56db", "\u521d\u4e94", "\u521d\u516d", "\u521d\u4e03", "\u521d\u516b", "\u521d\u4e5d", "\u521d\u5341", "\u5341\u4e00", "\u5341\u4e8c", "\u5341\u4e09", "\u5341\u56db", "\u5341\u4e94", "\u5341\u516d", "\u5341\u4e03", "\u5341\u516b", "\u5341\u4e5d", "\u4e8c\u5341", "\u5eff\u4e00", "\u5eff\u4e8c", "\u5eff\u4e09", "\u5eff\u56db", "\u5eff\u4e94", "\u5eff\u516d", "\u5eff\u4e03", "\u5eff\u516b", "\u5eff\u4e5d", "\u4e09\u5341"};
    @org.jetbrains.annotations.NotNull
    public static final com.example.daymate.utils.LunarUtils INSTANCE = null;
    
    private LunarUtils() {
        super();
    }
    
    /**
     * 获取农历日期字符串（简化版本）
     * 这是一个简化的实现，实际项目中应该使用专业的农历转换库
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLunarDateString(@org.jetbrains.annotations.NotNull
    java.time.LocalDate solarDate) {
        return null;
    }
    
    /**
     * 判断是否为农历节日
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String isLunarHoliday(@org.jetbrains.annotations.NotNull
    java.time.LocalDate solarDate) {
        return null;
    }
    
    /**
     * 获取农历年份
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLunarYear(@org.jetbrains.annotations.NotNull
    java.time.LocalDate solarDate) {
        return null;
    }
}