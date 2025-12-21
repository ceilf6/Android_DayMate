package com.example.daymate.utils;

/**
 * 农历工具类 - 完整实现
 * 支持1900年到2100年的公历与农历互转
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001-B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010!\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001bH\u0002J\u000e\u0010#\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010$\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u000e\u0010&\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\'\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010(\u001a\u0004\u0018\u00010\u00052\u0006\u0010)\u001a\u00020\u0015J\u0018\u0010*\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001bH\u0002J\u000e\u0010,\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006."}, d2 = {"Lcom/example/daymate/utils/LunarUtils;", "", "()V", "DI_ZHI", "", "", "[Ljava/lang/String;", "LUNAR_DAYS", "LUNAR_HOLIDAYS", "", "LUNAR_INFO", "", "LUNAR_MONTHS", "SHENG_XIAO", "SOLAR_HOLIDAYS", "SOLAR_TERMS", "SOLAR_TERM_INFO", "TIAN_GAN", "createDefaultLunarDate", "Lcom/example/daymate/utils/LunarUtils$LunarDate;", "solarDate", "Ljava/time/LocalDate;", "getAllHolidays", "", "getFullLunarDateString", "getGanZhi", "year", "", "getGanZhiYear", "getLeapMonth", "getLeapMonthDays", "getLunarDateString", "getLunarHoliday", "getLunarMonthDays", "month", "getLunarMonthInfo", "getLunarYear", "getLunarYearDays", "getShengXiao", "getSolarHoliday", "getSolarTerm", "date", "getSolarTermDay", "termIndex", "solarToLunar", "LunarDate", "android-calendar_debug"})
public final class LunarUtils {
    
    /**
     * 农历数据表（1900-2100年）
     * 每个整数包含的信息：
     * - 第1-12位：表示农历每月的大小（1为30天，0为29天）
     * - 第13-16位：表示闰月的月份（0表示无闰月）
     * - 第17-20位：表示闰月的天数（1为30天，0为29天）
     */
    @org.jetbrains.annotations.NotNull
    private static final int[] LUNAR_INFO = {19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, 21970, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 28309, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42416, 83315, 21168, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46752, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 21952, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 86390, 21168, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19195, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448, 84835, 37744, 18936, 18800, 25776, 92326, 59984, 27424, 108228, 43744, 41696, 53987, 51552, 54615, 54432, 55888, 23893, 22176, 42704, 21972, 21200, 43448, 43344, 46240, 46758, 44368, 21920, 43940, 42416, 21168, 45683, 26928, 29495, 27296, 44368, 84821, 19296, 42352, 21732, 53600, 59752, 54560, 55968, 92838, 22224, 19168, 43476, 41680, 53584, 62034, 54560};
    
    /**
     * 节气数据（从小寒开始，每年24个节气）
     * 每个值代表该节气距离当年1月1日的分钟数
     */
    @org.jetbrains.annotations.NotNull
    private static final int[] SOLAR_TERM_INFO = {0, 21208, 42467, 63836, 85337, 107014, 128867, 150921, 173149, 195551, 218072, 240693, 263343, 285989, 308563, 331033, 353350, 375494, 397447, 419210, 440795, 462224, 483532, 504758};
    
    /**
     * 天干
     */
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String[] TIAN_GAN = {"\u7532", "\u4e59", "\u4e19", "\u4e01", "\u620a", "\u5df1", "\u5e9a", "\u8f9b", "\u58ec", "\u7678"};
    
    /**
     * 地支
     */
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String[] DI_ZHI = {"\u5b50", "\u4e11", "\u5bc5", "\u536f", "\u8fb0", "\u5df3", "\u5348", "\u672a", "\u7533", "\u9149", "\u620c", "\u4ea5"};
    
    /**
     * 生肖
     */
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String[] SHENG_XIAO = {"\u9f20", "\u725b", "\u864e", "\u5154", "\u9f99", "\u86c7", "\u9a6c", "\u7f8a", "\u7334", "\u9e21", "\u72d7", "\u732a"};
    
    /**
     * 农历月份名称
     */
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String[] LUNAR_MONTHS = {"\u6b63", "\u4e8c", "\u4e09", "\u56db", "\u4e94", "\u516d", "\u4e03", "\u516b", "\u4e5d", "\u5341", "\u51ac", "\u814a"};
    
    /**
     * 农历日期名称
     */
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String[] LUNAR_DAYS = {"\u521d\u4e00", "\u521d\u4e8c", "\u521d\u4e09", "\u521d\u56db", "\u521d\u4e94", "\u521d\u516d", "\u521d\u4e03", "\u521d\u516b", "\u521d\u4e5d", "\u521d\u5341", "\u5341\u4e00", "\u5341\u4e8c", "\u5341\u4e09", "\u5341\u56db", "\u5341\u4e94", "\u5341\u516d", "\u5341\u4e03", "\u5341\u516b", "\u5341\u4e5d", "\u4e8c\u5341", "\u5eff\u4e00", "\u5eff\u4e8c", "\u5eff\u4e09", "\u5eff\u56db", "\u5eff\u4e94", "\u5eff\u516d", "\u5eff\u4e03", "\u5eff\u516b", "\u5eff\u4e5d", "\u4e09\u5341"};
    
    /**
     * 24节气名称
     */
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String[] SOLAR_TERMS = {"\u5c0f\u5bd2", "\u5927\u5bd2", "\u7acb\u6625", "\u96e8\u6c34", "\u60ca\u86f0", "\u6625\u5206", "\u6e05\u660e", "\u8c37\u96e8", "\u7acb\u590f", "\u5c0f\u6ee1", "\u8292\u79cd", "\u590f\u81f3", "\u5c0f\u6691", "\u5927\u6691", "\u7acb\u79cb", "\u5904\u6691", "\u767d\u9732", "\u79cb\u5206", "\u5bd2\u9732", "\u971c\u964d", "\u7acb\u51ac", "\u5c0f\u96ea", "\u5927\u96ea", "\u51ac\u81f3"};
    
    /**
     * 农历节日（农历月份-日期 -> 节日名称）
     */
    @org.jetbrains.annotations.NotNull
    private static final java.util.Map<java.lang.String, java.lang.String> LUNAR_HOLIDAYS = null;
    
    /**
     * 公历节日（月-日 -> 节日名称）
     */
    @org.jetbrains.annotations.NotNull
    private static final java.util.Map<java.lang.String, java.lang.String> SOLAR_HOLIDAYS = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.daymate.utils.LunarUtils INSTANCE = null;
    
    private LunarUtils() {
        super();
    }
    
    /**
     * 获取农历某年的总天数
     */
    private final int getLunarYearDays(int year) {
        return 0;
    }
    
    /**
     * 获取农历某年闰月的天数
     */
    private final int getLeapMonthDays(int year) {
        return 0;
    }
    
    /**
     * 获取农历某年的闰月月份（0表示无闰月）
     */
    private final int getLeapMonth(int year) {
        return 0;
    }
    
    /**
     * 获取农历某年某月的天数
     */
    private final int getLunarMonthDays(int year, int month) {
        return 0;
    }
    
    /**
     * 公历转农历
     */
    @org.jetbrains.annotations.NotNull
    public final com.example.daymate.utils.LunarUtils.LunarDate solarToLunar(@org.jetbrains.annotations.NotNull
    java.time.LocalDate solarDate) {
        return null;
    }
    
    /**
     * 创建默认的农历日期（用于超出范围的情况）
     */
    private final com.example.daymate.utils.LunarUtils.LunarDate createDefaultLunarDate(java.time.LocalDate solarDate) {
        return null;
    }
    
    /**
     * 计算天干地支年
     */
    private final java.lang.String getGanZhiYear(int year) {
        return null;
    }
    
    /**
     * 获取节气
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSolarTerm(@org.jetbrains.annotations.NotNull
    java.time.LocalDate date) {
        return null;
    }
    
    /**
     * 获取某年某个节气的日期
     */
    private final int getSolarTermDay(int year, int termIndex) {
        return 0;
    }
    
    /**
     * 获取农历日期字符串（简化版本，用于日历显示）
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLunarDateString(@org.jetbrains.annotations.NotNull
    java.time.LocalDate solarDate) {
        return null;
    }
    
    /**
     * 获取完整的农历日期字符串
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFullLunarDateString(@org.jetbrains.annotations.NotNull
    java.time.LocalDate solarDate) {
        return null;
    }
    
    /**
     * 判断是否为农历节日，返回节日名称
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLunarHoliday(@org.jetbrains.annotations.NotNull
    java.time.LocalDate solarDate) {
        return null;
    }
    
    /**
     * 判断是否为公历节日，返回节日名称
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSolarHoliday(@org.jetbrains.annotations.NotNull
    java.time.LocalDate solarDate) {
        return null;
    }
    
    /**
     * 获取所有节日（包括农历节日、公历节日和节气）
     */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getAllHolidays(@org.jetbrains.annotations.NotNull
    java.time.LocalDate solarDate) {
        return null;
    }
    
    /**
     * 获取农历年份信息
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLunarYear(@org.jetbrains.annotations.NotNull
    java.time.LocalDate solarDate) {
        return null;
    }
    
    /**
     * 获取农历月份信息
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLunarMonthInfo(@org.jetbrains.annotations.NotNull
    java.time.LocalDate solarDate) {
        return null;
    }
    
    /**
     * 获取生肖
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getShengXiao(int year) {
        return null;
    }
    
    /**
     * 获取天干地支
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getGanZhi(int year) {
        return null;
    }
    
    /**
     * 农历日期数据类
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\tH\u00c6\u0003J\t\u0010 \u001a\u00020\tH\u00c6\u0003J\t\u0010!\u001a\u00020\tH\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tH\u00c6\u0003Je\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\tH\u00c6\u0001J\u0013\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020\u0003H\u00d6\u0001J\u0006\u0010\'\u001a\u00020\tJ\u0006\u0010(\u001a\u00020\tJ\t\u0010)\u001a\u00020\tH\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012\u00a8\u0006*"}, d2 = {"Lcom/example/daymate/utils/LunarUtils$LunarDate;", "", "year", "", "month", "day", "isLeapMonth", "", "yearGanZhi", "", "yearShengXiao", "monthStr", "dayStr", "solarTerm", "(IIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDay", "()I", "getDayStr", "()Ljava/lang/String;", "()Z", "getMonth", "getMonthStr", "getSolarTerm", "getYear", "getYearGanZhi", "getYearShengXiao", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toFullString", "toShortString", "toString", "android-calendar_debug"})
    public static final class LunarDate {
        private final int year = 0;
        private final int month = 0;
        private final int day = 0;
        private final boolean isLeapMonth = false;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String yearGanZhi = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String yearShengXiao = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String monthStr = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String dayStr = null;
        @org.jetbrains.annotations.Nullable
        private final java.lang.String solarTerm = null;
        
        public LunarDate(int year, int month, int day, boolean isLeapMonth, @org.jetbrains.annotations.NotNull
        java.lang.String yearGanZhi, @org.jetbrains.annotations.NotNull
        java.lang.String yearShengXiao, @org.jetbrains.annotations.NotNull
        java.lang.String monthStr, @org.jetbrains.annotations.NotNull
        java.lang.String dayStr, @org.jetbrains.annotations.Nullable
        java.lang.String solarTerm) {
            super();
        }
        
        public final int getYear() {
            return 0;
        }
        
        public final int getMonth() {
            return 0;
        }
        
        public final int getDay() {
            return 0;
        }
        
        public final boolean isLeapMonth() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getYearGanZhi() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getYearShengXiao() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getMonthStr() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getDayStr() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getSolarTerm() {
            return null;
        }
        
        /**
         * 获取完整的农历日期字符串
         */
        @org.jetbrains.annotations.NotNull
        public final java.lang.String toFullString() {
            return null;
        }
        
        /**
         * 获取简短的农历日期字符串（用于日历显示）
         */
        @org.jetbrains.annotations.NotNull
        public final java.lang.String toShortString() {
            return null;
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final int component3() {
            return 0;
        }
        
        public final boolean component4() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component7() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component8() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component9() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.daymate.utils.LunarUtils.LunarDate copy(int year, int month, int day, boolean isLeapMonth, @org.jetbrains.annotations.NotNull
        java.lang.String yearGanZhi, @org.jetbrains.annotations.NotNull
        java.lang.String yearShengXiao, @org.jetbrains.annotations.NotNull
        java.lang.String monthStr, @org.jetbrains.annotations.NotNull
        java.lang.String dayStr, @org.jetbrains.annotations.Nullable
        java.lang.String solarTerm) {
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
}