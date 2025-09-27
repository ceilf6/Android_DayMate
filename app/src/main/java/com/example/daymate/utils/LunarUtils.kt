package com.example.daymate.utils

import java.time.LocalDate

object LunarUtils {
    
    /**
     * 农历月份名称
     */
    private val lunarMonths = arrayOf(
        "正", "二", "三", "四", "五", "六",
        "七", "八", "九", "十", "冬", "腊"
    )
    
    /**
     * 农历日期名称
     */
    private val lunarDays = arrayOf(
        "初一", "初二", "初三", "初四", "初五", "初六", "初七", "初八", "初九", "初十",
        "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九", "二十",
        "廿一", "廿二", "廿三", "廿四", "廿五", "廿六", "廿七", "廿八", "廿九", "三十"
    )
    
    /**
     * 获取农历日期字符串（简化版本）
     * 这是一个简化的实现，实际项目中应该使用专业的农历转换库
     */
    fun getLunarDateString(solarDate: LocalDate): String {
        // 这里是一个简化的实现，实际应该使用专业的农历算法
        // 为了演示目的，我们生成一个模拟的农历日期
        val month = solarDate.monthValue
        val day = solarDate.dayOfMonth
        
        // 简化的农历转换（仅用于演示）
        val lunarMonth = ((month - 1) % 12)
        val lunarDay = ((day - 1) % 30)
        
        return "${lunarMonths[lunarMonth]}月${lunarDays[lunarDay]}"
    }
    
    /**
     * 判断是否为农历节日
     */
    fun isLunarHoliday(solarDate: LocalDate): String? {
        // 这里可以添加农历节日的判断逻辑
        // 例如：春节、元宵节、端午节、中秋节等
        return when {
            solarDate.monthValue == 1 && solarDate.dayOfMonth in 1..15 -> "春节期间"
            solarDate.monthValue == 2 && solarDate.dayOfMonth == 15 -> "元宵节"
            solarDate.monthValue == 5 && solarDate.dayOfMonth == 5 -> "端午节"
            solarDate.monthValue == 8 && solarDate.dayOfMonth == 15 -> "中秋节"
            else -> null
        }
    }
    
    /**
     * 获取农历年份
     */
    fun getLunarYear(solarDate: LocalDate): String {
        // 简化的农历年份计算
        val year = solarDate.year
        val animalYears = arrayOf("鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪")
        val animal = animalYears[(year - 1900) % 12]
        return "${year}年(${animal}年)"
    }
}
