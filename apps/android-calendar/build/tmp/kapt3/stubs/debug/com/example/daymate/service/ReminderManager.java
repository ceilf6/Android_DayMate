package com.example.daymate.service;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eJ\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0012J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/example/daymate/service/ReminderManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "alarmManager", "Landroid/app/AlarmManager;", "notificationService", "Lcom/example/daymate/service/ReminderNotificationService;", "workManager", "Landroidx/work/WorkManager;", "buildReminderPendingIntent", "Landroid/app/PendingIntent;", "eventId", "", "reminderMinutes", "", "cancelAllReminders", "", "cancelReminder", "getEventsWithReminders", "", "Lcom/example/daymate/data/Event;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rescheduleReminders", "scheduleExactAlarm", "", "reminderTime", "Ljava/time/LocalDateTime;", "scheduleReminder", "event", "Companion", "android-calendar_debug"})
public final class ReminderManager {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = "ReminderManager";
    @org.jetbrains.annotations.NotNull
    private final androidx.work.WorkManager workManager = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.daymate.service.ReminderNotificationService notificationService = null;
    @org.jetbrains.annotations.NotNull
    private final android.app.AlarmManager alarmManager = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.daymate.service.ReminderManager.Companion Companion = null;
    
    public ReminderManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    public final void scheduleReminder(@org.jetbrains.annotations.NotNull
    com.example.daymate.data.Event event) {
    }
    
    private final boolean scheduleExactAlarm(long eventId, int reminderMinutes, java.time.LocalDateTime reminderTime) {
        return false;
    }
    
    private final android.app.PendingIntent buildReminderPendingIntent(long eventId, int reminderMinutes) {
        return null;
    }
    
    public final void cancelReminder(long eventId) {
    }
    
    public final void cancelAllReminders() {
    }
    
    public final void rescheduleReminders() {
    }
    
    private final java.lang.Object getEventsWithReminders(kotlin.coroutines.Continuation<? super java.util.List<com.example.daymate.data.Event>> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/daymate/service/ReminderManager$Companion;", "", "()V", "TAG", "", "android-calendar_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}