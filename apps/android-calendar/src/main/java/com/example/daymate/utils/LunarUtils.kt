package com.example.daymate.utils

import java.time.LocalDate
import java.time.temporal.ChronoUnit
import kotlin.math.floor

/**
 * 农历工具类 - 完整实现
 * 支持1900年到2100年的公历与农历互转
 */
object LunarUtils {
    
    /**
     * 农历数据表（1900-2100年）
     * 每个整数包含的信息：
     * - 第1-12位：表示农历每月的大小（1为30天，0为29天）
     * - 第13-16位：表示闰月的月份（0表示无闰月）
     * - 第17-20位：表示闰月的天数（1为30天，0为29天）
     */
    private val LUNAR_INFO = intArrayOf(
        0x04bd8, 0x04ae0, 0x0a570, 0x054d5, 0x0d260, 0x0d950, 0x16554, 0x056a0, 0x09ad0, 0x055d2, // 1900-1909
        0x04ae0, 0x0a5b6, 0x0a4d0, 0x0d250, 0x1d255, 0x0b540, 0x0d6a0, 0x0ada2, 0x095b0, 0x14977, // 1910-1919
        0x04970, 0x0a4b0, 0x0b4b5, 0x06a50, 0x06d40, 0x1ab54, 0x02b60, 0x09570, 0x052f2, 0x04970, // 1920-1929
        0x06566, 0x0d4a0, 0x0ea50, 0x06e95, 0x05ad0, 0x02b60, 0x186e3, 0x092e0, 0x1c8d7, 0x0c950, // 1930-1939
        0x0d4a0, 0x1d8a6, 0x0b550, 0x056a0, 0x1a5b4, 0x025d0, 0x092d0, 0x0d2b2, 0x0a950, 0x0b557, // 1940-1949
        0x06ca0, 0x0b550, 0x15355, 0x04da0, 0x0a5b0, 0x14573, 0x052b0, 0x0a9a8, 0x0e950, 0x06aa0, // 1950-1959
        0x0aea6, 0x0ab50, 0x04b60, 0x0aae4, 0x0a570, 0x05260, 0x0f263, 0x0d950, 0x05b57, 0x056a0, // 1960-1969
        0x096d0, 0x04dd5, 0x04ad0, 0x0a4d0, 0x0d4d4, 0x0d250, 0x0d558, 0x0b540, 0x0b6a0, 0x195a6, // 1970-1979
        0x095b0, 0x049b0, 0x0a974, 0x0a4b0, 0x0b27a, 0x06a50, 0x06d40, 0x0af46, 0x0ab60, 0x09570, // 1980-1989
        0x04af5, 0x04970, 0x064b0, 0x074a3, 0x0ea50, 0x06b58, 0x055c0, 0x0ab60, 0x096d5, 0x092e0, // 1990-1999
        0x0c960, 0x0d954, 0x0d4a0, 0x0da50, 0x07552, 0x056a0, 0x0abb7, 0x025d0, 0x092d0, 0x0cab5, // 2000-2009
        0x0a950, 0x0b4a0, 0x0baa4, 0x0ad50, 0x055d9, 0x04ba0, 0x0a5b0, 0x15176, 0x052b0, 0x0a930, // 2010-2019
        0x07954, 0x06aa0, 0x0ad50, 0x05b52, 0x04b60, 0x0a6e6, 0x0a4e0, 0x0d260, 0x0ea65, 0x0d530, // 2020-2029
        0x05aa0, 0x076a3, 0x096d0, 0x04afb, 0x04ad0, 0x0a4d0, 0x1d0b6, 0x0d250, 0x0d520, 0x0dd45, // 2030-2039
        0x0b5a0, 0x056d0, 0x055b2, 0x049b0, 0x0a577, 0x0a4b0, 0x0aa50, 0x1b255, 0x06d20, 0x0ada0, // 2040-2049
        0x14b63, 0x09370, 0x049f8, 0x04970, 0x064b0, 0x168a6, 0x0ea50, 0x06b20, 0x1a6c4, 0x0aae0, // 2050-2059
        0x0a2e0, 0x0d2e3, 0x0c960, 0x0d557, 0x0d4a0, 0x0da50, 0x05d55, 0x056a0, 0x0a6d0, 0x055d4, // 2060-2069
        0x052d0, 0x0a9b8, 0x0a950, 0x0b4a0, 0x0b6a6, 0x0ad50, 0x055a0, 0x0aba4, 0x0a5b0, 0x052b0, // 2070-2079
        0x0b273, 0x06930, 0x07337, 0x06aa0, 0x0ad50, 0x14b55, 0x04b60, 0x0a570, 0x054e4, 0x0d160, // 2080-2089
        0x0e968, 0x0d520, 0x0daa0, 0x16aa6, 0x056d0, 0x04ae0, 0x0a9d4, 0x0a2d0, 0x0d150, 0x0f252, // 2090-2099
        0x0d520  // 2100
    )
    
    /**
     * 节气数据（从小寒开始，每年24个节气）
     * 每个值代表该节气距离当年1月1日的分钟数
     */
    private val SOLAR_TERM_INFO = intArrayOf(
        0, 21208, 42467, 63836, 85337, 107014, 128867, 150921,
        173149, 195551, 218072, 240693, 263343, 285989, 308563, 331033,
        353350, 375494, 397447, 419210, 440795, 462224, 483532, 504758
    )
    
    /**
     * 天干
     */
    private val TIAN_GAN = arrayOf("甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸")
    
    /**
     * 地支
     */
    private val DI_ZHI = arrayOf("子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥")
    
    /**
     * 生肖
     */
    private val SHENG_XIAO = arrayOf("鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪")
    
    /**
     * 农历月份名称
     */
    private val LUNAR_MONTHS = arrayOf(
        "正", "二", "三", "四", "五", "六", "七", "八", "九", "十", "冬", "腊"
    )
    
    /**
     * 农历日期名称
     */
    private val LUNAR_DAYS = arrayOf(
        "初一", "初二", "初三", "初四", "初五", "初六", "初七", "初八", "初九", "初十",
        "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九", "二十",
        "廿一", "廿二", "廿三", "廿四", "廿五", "廿六", "廿七", "廿八", "廿九", "三十"
    )
    
    /**
     * 24节气名称
     */
    private val SOLAR_TERMS = arrayOf(
        "小寒", "大寒", "立春", "雨水", "惊蛰", "春分",
        "清明", "谷雨", "立夏", "小满", "芒种", "夏至",
        "小暑", "大暑", "立秋", "处暑", "白露", "秋分",
        "寒露", "霜降", "立冬", "小雪", "大雪", "冬至"
    )
    
    /**
     * 农历节日（农历月份-日期 -> 节日名称）
     */
    private val LUNAR_HOLIDAYS = mapOf(
        "1-1" to "春节",
        "1-15" to "元宵",
        "2-2" to "龙抬头",
        "5-5" to "端午",
        "7-7" to "七夕",
        "7-15" to "中元",
        "8-15" to "中秋",
        "9-9" to "重阳",
        "12-8" to "腊八",
        "12-23" to "小年",
        "12-30" to "除夕"
    )
    
    /**
     * 公历节日（月-日 -> 节日名称）
     */
    private val SOLAR_HOLIDAYS = mapOf(
        "1-1" to "元旦",
        "2-14" to "情人节",
        "3-8" to "妇女节",
        "3-12" to "植树节",
        "4-1" to "愚人节",
        "5-1" to "劳动节",
        "5-4" to "青年节",
        "6-1" to "儿童节",
        "7-1" to "建党节",
        "8-1" to "建军节",
        "9-10" to "教师节",
        "10-1" to "国庆节",
        "12-25" to "圣诞节"
    )
    
    /**
     * 农历日期数据类
     */
    data class LunarDate(
        val year: Int,          // 农历年份
        val month: Int,         // 农历月份（1-12）
        val day: Int,           // 农历日期（1-30）
        val isLeapMonth: Boolean, // 是否是闰月
        val yearGanZhi: String, // 天干地支年
        val yearShengXiao: String, // 生肖
        val monthStr: String,   // 月份中文
        val dayStr: String,     // 日期中文
        val solarTerm: String?  // 节气（如果当天是节气）
    ) {
        /**
         * 获取完整的农历日期字符串
         */
        fun toFullString(): String {
            val leap = if (isLeapMonth) "闰" else ""
            return "${yearGanZhi}年${yearShengXiao}年 ${leap}${monthStr}月${dayStr}"
        }
        
        /**
         * 获取简短的农历日期字符串（用于日历显示）
         */
        fun toShortString(): String {
            // 优先显示节气
            solarTerm?.let { return it }
            // 初一显示月份
            if (day == 1) {
                val leap = if (isLeapMonth) "闰" else ""
                return "${leap}${monthStr}月"
            }
            return dayStr
        }
    }
    
    /**
     * 获取农历某年的总天数
     */
    private fun getLunarYearDays(year: Int): Int {
        var sum = 348 // 12个月，每月29天 = 348天
        var i = 0x8000
        val info = LUNAR_INFO[year - 1900]
        while (i > 0x8) {
            if ((info and i) != 0) sum += 1
            i = i shr 1
        }
        return sum + getLeapMonthDays(year)
    }
    
    /**
     * 获取农历某年闰月的天数
     */
    private fun getLeapMonthDays(year: Int): Int {
        if (getLeapMonth(year) == 0) return 0
        return if ((LUNAR_INFO[year - 1900] and 0x10000) != 0) 30 else 29
    }
    
    /**
     * 获取农历某年的闰月月份（0表示无闰月）
     */
    private fun getLeapMonth(year: Int): Int {
        return LUNAR_INFO[year - 1900] and 0xf
    }
    
    /**
     * 获取农历某年某月的天数
     */
    private fun getLunarMonthDays(year: Int, month: Int): Int {
        val info = LUNAR_INFO[year - 1900]
        return if ((info and (0x10000 shr month)) != 0) 30 else 29
    }
    
    /**
     * 公历转农历
     */
    fun solarToLunar(solarDate: LocalDate): LunarDate {
        val year = solarDate.year
        val month = solarDate.monthValue
        val day = solarDate.dayOfMonth
        
        // 验证范围
        if (year < 1900 || year > 2100) {
            return createDefaultLunarDate(solarDate)
        }
        
        // 计算距离1900年1月31日（农历1900年正月初一）的天数
        val baseDate = LocalDate.of(1900, 1, 31)
        var offset = ChronoUnit.DAYS.between(baseDate, solarDate).toInt()
        
        if (offset < 0) {
            return createDefaultLunarDate(solarDate)
        }
        
        // 计算农历年份
        var lunarYear = 1900
        var daysInYear: Int
        while (lunarYear < 2101) {
            daysInYear = getLunarYearDays(lunarYear)
            if (offset < daysInYear) break
            offset -= daysInYear
            lunarYear++
        }
        
        // 计算农历月份
        val leapMonth = getLeapMonth(lunarYear)
        var isLeapMonth = false
        var lunarMonth = 1
        var daysInMonth: Int
        
        while (lunarMonth <= 12) {
            // 判断是否是闰月
            if (leapMonth > 0 && lunarMonth == leapMonth + 1 && !isLeapMonth) {
                isLeapMonth = true
                lunarMonth--
                daysInMonth = getLeapMonthDays(lunarYear)
            } else {
                daysInMonth = getLunarMonthDays(lunarYear, lunarMonth)
            }
            
            if (offset < daysInMonth) break
            
            offset -= daysInMonth
            
            if (isLeapMonth) {
                isLeapMonth = false
            }
            lunarMonth++
        }
        
        // 农历日期
        val lunarDay = offset + 1
        
        // 计算天干地支年
        val ganZhiYear = getGanZhiYear(lunarYear)
        
        // 计算生肖
        val shengXiao = SHENG_XIAO[(lunarYear - 4) % 12]
        
        // 月份中文
        val monthStr = LUNAR_MONTHS[(lunarMonth - 1) % 12]
        
        // 日期中文
        val dayStr = LUNAR_DAYS[(lunarDay - 1) % 30]
        
        // 节气
        val solarTerm = getSolarTerm(solarDate)
        
        return LunarDate(
            year = lunarYear,
            month = lunarMonth,
            day = lunarDay,
            isLeapMonth = isLeapMonth,
            yearGanZhi = ganZhiYear,
            yearShengXiao = shengXiao,
            monthStr = monthStr,
            dayStr = dayStr,
            solarTerm = solarTerm
        )
    }
    
    /**
     * 创建默认的农历日期（用于超出范围的情况）
     */
    private fun createDefaultLunarDate(solarDate: LocalDate): LunarDate {
        return LunarDate(
            year = solarDate.year,
            month = solarDate.monthValue,
            day = solarDate.dayOfMonth,
            isLeapMonth = false,
            yearGanZhi = "未知",
            yearShengXiao = "未知",
            monthStr = LUNAR_MONTHS[(solarDate.monthValue - 1) % 12],
            dayStr = LUNAR_DAYS[(solarDate.dayOfMonth - 1) % 30],
            solarTerm = null
        )
    }
    
    /**
     * 计算天干地支年
     */
    private fun getGanZhiYear(year: Int): String {
        val gan = TIAN_GAN[(year - 4) % 10]
        val zhi = DI_ZHI[(year - 4) % 12]
        return "$gan$zhi"
    }
    
    /**
     * 获取节气
     */
    fun getSolarTerm(date: LocalDate): String? {
        val year = date.year
        val month = date.monthValue
        val day = date.dayOfMonth
        
        // 简化的节气计算
        // 每个月有两个节气，大约在每月的5-7日和19-23日
        val termIndex1 = (month - 1) * 2
        val termIndex2 = termIndex1 + 1
        
        // 计算该月两个节气的日期（简化算法）
        val term1Day = getSolarTermDay(year, termIndex1)
        val term2Day = getSolarTermDay(year, termIndex2)
        
        return when (day) {
            term1Day -> SOLAR_TERMS[termIndex1]
            term2Day -> SOLAR_TERMS[termIndex2]
            else -> null
        }
    }
    
    /**
     * 获取某年某个节气的日期
     */
    private fun getSolarTermDay(year: Int, termIndex: Int): Int {
        // 使用简化的计算方法
        // 节气日期 = 基准日期 + (年份-1900) * 调整系数
        val baseDay = when (termIndex) {
            0 -> 6    // 小寒
            1 -> 20   // 大寒
            2 -> 4    // 立春
            3 -> 19   // 雨水
            4 -> 6    // 惊蛰
            5 -> 21   // 春分
            6 -> 5    // 清明
            7 -> 20   // 谷雨
            8 -> 6    // 立夏
            9 -> 21   // 小满
            10 -> 6   // 芒种
            11 -> 21  // 夏至
            12 -> 7   // 小暑
            13 -> 23  // 大暑
            14 -> 7   // 立秋
            15 -> 23  // 处暑
            16 -> 8   // 白露
            17 -> 23  // 秋分
            18 -> 8   // 寒露
            19 -> 23  // 霜降
            20 -> 7   // 立冬
            21 -> 22  // 小雪
            22 -> 7   // 大雪
            23 -> 22  // 冬至
            else -> 1
        }
        
        // 根据年份微调
        val adjustment = ((year - 2000) * 0.2468f).toInt()
        return baseDay + adjustment % 2
    }
    
    /**
     * 获取农历日期字符串（简化版本，用于日历显示）
     */
    fun getLunarDateString(solarDate: LocalDate): String {
        val lunar = solarToLunar(solarDate)
        return lunar.toShortString()
    }
    
    /**
     * 获取完整的农历日期字符串
     */
    fun getFullLunarDateString(solarDate: LocalDate): String {
        val lunar = solarToLunar(solarDate)
        return lunar.toFullString()
    }
    
    /**
     * 判断是否为农历节日，返回节日名称
     */
    fun getLunarHoliday(solarDate: LocalDate): String? {
        val lunar = solarToLunar(solarDate)
        val key = "${lunar.month}-${lunar.day}"
        
        // 特殊处理除夕（腊月最后一天）
        if (lunar.month == 12) {
            val daysInMonth = if (lunar.isLeapMonth) {
                getLeapMonthDays(lunar.year)
            } else {
                getLunarMonthDays(lunar.year, 12)
            }
            if (lunar.day == daysInMonth) {
                return "除夕"
            }
        }
        
        return LUNAR_HOLIDAYS[key]
    }
    
    /**
     * 判断是否为公历节日，返回节日名称
     */
    fun getSolarHoliday(solarDate: LocalDate): String? {
        val key = "${solarDate.monthValue}-${solarDate.dayOfMonth}"
        return SOLAR_HOLIDAYS[key]
    }
    
    /**
     * 获取所有节日（包括农历节日、公历节日和节气）
     */
    fun getAllHolidays(solarDate: LocalDate): List<String> {
        val holidays = mutableListOf<String>()
        
        // 公历节日
        getSolarHoliday(solarDate)?.let { holidays.add(it) }
        
        // 农历节日
        getLunarHoliday(solarDate)?.let { holidays.add(it) }
        
        // 节气
        getSolarTerm(solarDate)?.let { holidays.add(it) }
        
        return holidays
    }
    
    /**
     * 获取农历年份信息
     */
    fun getLunarYear(solarDate: LocalDate): String {
        val lunar = solarToLunar(solarDate)
        return "${lunar.year}年(${lunar.yearGanZhi}${lunar.yearShengXiao}年)"
    }
    
    /**
     * 获取农历月份信息
     */
    fun getLunarMonthInfo(solarDate: LocalDate): String {
        val lunar = solarToLunar(solarDate)
        val leap = if (lunar.isLeapMonth) "闰" else ""
        return "${leap}${lunar.monthStr}月"
    }
    
    /**
     * 获取生肖
     */
    fun getShengXiao(year: Int): String {
        return SHENG_XIAO[(year - 4) % 12]
    }
    
    /**
     * 获取天干地支
     */
    fun getGanZhi(year: Int): String {
        return getGanZhiYear(year)
    }
}
