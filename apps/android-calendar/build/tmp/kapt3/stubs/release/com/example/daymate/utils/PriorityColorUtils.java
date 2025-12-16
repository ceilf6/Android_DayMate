package com.example.daymate.utils;

/**
 * 事件优先级颜色工具类
 * 提供统一的优先级颜色映射
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J(\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/example/daymate/utils/PriorityColorUtils;", "", "()V", "getPriorityColorRes", "", "priority", "getPriorityColors", "Lkotlin/Triple;", "", "context", "Landroid/content/Context;", "getPriorityIndicator", "", "getPriorityText", "app_release"})
public final class PriorityColorUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.example.daymate.utils.PriorityColorUtils INSTANCE = null;
    
    private PriorityColorUtils() {
        super();
    }
    
    /**
     * 根据优先级获取颜色资源
     * @param context 上下文
     * @param priority 优先级 (0=未设置, 1-3=高, 4-6=中, 7-9=低)
     * @return Triple<背景色, 边框色, 是否深色主题>
     */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Triple<java.lang.Integer, java.lang.Integer, java.lang.Boolean> getPriorityColors(@org.jetbrains.annotations.NotNull
    android.content.Context context, int priority) {
        return null;
    }
    
    /**
     * 根据优先级获取优先级指示符
     * @param priority 优先级
     * @return 优先级指示符字符串
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPriorityIndicator(int priority) {
        return null;
    }
    
    /**
     * 根据优先级获取颜色资源ID
     * @param priority 优先级
     * @return 颜色资源ID
     */
    public final int getPriorityColorRes(int priority) {
        return 0;
    }
    
    /**
     * 根据优先级获取优先级文本
     * @param priority 优先级
     * @return 优先级文本
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPriorityText(int priority) {
        return null;
    }
}