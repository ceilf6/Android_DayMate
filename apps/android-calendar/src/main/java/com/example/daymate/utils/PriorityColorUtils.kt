package com.example.daymate.utils

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.daymate.R

/**
 * 事件优先级颜色工具类
 * 提供统一的优先级颜色映射
 */
object PriorityColorUtils {
    
    /**
     * 根据优先级获取颜色资源
     * @param context 上下文
     * @param priority 优先级 (0=未设置, 1-3=高, 4-6=中, 7-9=低)
     * @return Triple<背景色, 边框色, 是否深色主题>
     */
    fun getPriorityColors(context: Context, priority: Int): Triple<Int, Int, Boolean> {
        return when (priority) {
            in 1..3 -> Triple(
                ContextCompat.getColor(context, R.color.priority_high),
                ContextCompat.getColor(context, R.color.priority_high_dark),
                true
            )
            in 4..6 -> Triple(
                ContextCompat.getColor(context, R.color.priority_medium),
                ContextCompat.getColor(context, R.color.priority_medium_dark),
                true
            )
            in 7..9 -> Triple(
                ContextCompat.getColor(context, R.color.priority_low_light),
                ContextCompat.getColor(context, R.color.priority_low_dark),
                false
            )
            else -> Triple(
                ContextCompat.getColor(context, R.color.priority_default_light),
                ContextCompat.getColor(context, R.color.priority_default_dark),
                false
            )
        }
    }
    
    /**
     * 根据优先级获取优先级指示符
     * @param priority 优先级
     * @return 优先级指示符字符串
     */
    fun getPriorityIndicator(priority: Int): String {
        return when (priority) {
            in 1..3 -> "!!!"
            in 4..6 -> "!!"
            in 7..9 -> "!"
            else -> ""
        }
    }
    
    /**
     * 根据优先级获取颜色资源ID
     * @param priority 优先级
     * @return 颜色资源ID
     */
    fun getPriorityColorRes(priority: Int): Int {
        return when (priority) {
            in 1..3 -> R.color.priority_high
            in 4..6 -> R.color.priority_medium
            in 7..9 -> R.color.priority_low
            else -> R.color.priority_default
        }
    }
    
    /**
     * 根据优先级获取优先级文本
     * @param priority 优先级
     * @return 优先级文本
     */
    fun getPriorityText(priority: Int): String {
        return when (priority) {
            in 1..3 -> "高"
            in 4..6 -> "中"
            in 7..9 -> "低"
            else -> "未设置"
        }
    }
}
