package com.example.daymate.service;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\bH\u0002J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/daymate/service/ReminderNotificationService;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "notificationManager", "Landroid/app/NotificationManager;", "cancelAllReminderNotifications", "", "cancelReminderNotification", "eventId", "", "createNotificationChannel", "showReminderNotification", "event", "Lcom/example/daymate/data/Event;", "reminderMinutes", "", "Companion", "android-calendar_debug"})
public final class ReminderNotificationService {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CHANNEL_ID = "calendar_reminders";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CHANNEL_NAME = "\u65e5\u5386\u63d0\u9192";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CHANNEL_DESCRIPTION = "\u65e5\u5386\u4e8b\u4ef6\u63d0\u9192\u901a\u77e5";
    private static final int NOTIFICATION_ID_PREFIX = 1000;
    @org.jetbrains.annotations.NotNull
    private final android.app.NotificationManager notificationManager = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.daymate.service.ReminderNotificationService.Companion Companion = null;
    
    public ReminderNotificationService(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    private final void createNotificationChannel() {
    }
    
    public final void showReminderNotification(@org.jetbrains.annotations.NotNull
    com.example.daymate.data.Event event, int reminderMinutes) {
    }
    
    public final void cancelReminderNotification(long eventId) {
    }
    
    public final void cancelAllReminderNotifications() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/daymate/service/ReminderNotificationService$Companion;", "", "()V", "CHANNEL_DESCRIPTION", "", "CHANNEL_ID", "CHANNEL_NAME", "NOTIFICATION_ID_PREFIX", "", "android-calendar_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}