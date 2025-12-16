package com.example.daymate.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/example/daymate/utils/PermissionManager;", "", "()V", "Companion", "app_debug"})
public final class PermissionManager {
    public static final int NOTIFICATION_PERMISSION_REQUEST_CODE = 1001;
    @org.jetbrains.annotations.NotNull
    public static final com.example.daymate.utils.PermissionManager.Companion Companion = null;
    
    public PermissionManager() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/daymate/utils/PermissionManager$Companion;", "", "()V", "NOTIFICATION_PERMISSION_REQUEST_CODE", "", "checkNotificationPermissionResult", "", "requestCode", "grantResults", "", "hasNotificationPermission", "context", "Landroid/content/Context;", "requestNotificationPermission", "", "activity", "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "shouldShowNotificationPermissionRationale", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * 检查是否有通知权限
         */
        public final boolean hasNotificationPermission(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return false;
        }
        
        /**
         * 请求通知权限 - 在Activity中使用
         */
        public final void requestNotificationPermission(@org.jetbrains.annotations.NotNull
        android.app.Activity activity) {
        }
        
        /**
         * 请求通知权限 - 在Fragment中使用
         */
        public final void requestNotificationPermission(@org.jetbrains.annotations.NotNull
        androidx.fragment.app.Fragment fragment) {
        }
        
        /**
         * 检查权限请求结果
         */
        public final boolean checkNotificationPermissionResult(int requestCode, @org.jetbrains.annotations.NotNull
        int[] grantResults) {
            return false;
        }
        
        /**
         * 是否应该显示权限请求理由
         */
        public final boolean shouldShowNotificationPermissionRationale(@org.jetbrains.annotations.NotNull
        android.app.Activity activity) {
            return false;
        }
        
        /**
         * 是否应该显示权限请求理由 - Fragment版本
         */
        public final boolean shouldShowNotificationPermissionRationale(@org.jetbrains.annotations.NotNull
        androidx.fragment.app.Fragment fragment) {
            return false;
        }
    }
}