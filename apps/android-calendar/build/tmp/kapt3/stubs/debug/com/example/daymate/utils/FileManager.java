package com.example.daymate.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ+\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\fJ\u0006\u0010\u0013\u001a\u00020\u0006J\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0015\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0018\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/example/daymate/utils/FileManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "deleteExportFile", "", "file", "Ljava/io/File;", "exportCalendar", "Landroid/net/Uri;", "events", "", "Lcom/example/daymate/data/Event;", "fileName", "", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateFileName", "getExportFiles", "hasStoragePermission", "importCalendar", "uri", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importCalendarFromFile", "filePath", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class FileManager {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String AUTHORITY = "com.example.daymate.fileprovider";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String FILE_NAME_PREFIX = "daymate_calendar";
    @org.jetbrains.annotations.NotNull
    public static final com.example.daymate.utils.FileManager.Companion Companion = null;
    
    public FileManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    /**
     * 导出日历到文件
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object exportCalendar(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.daymate.data.Event> events, @org.jetbrains.annotations.Nullable
    java.lang.String fileName, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super android.net.Uri> $completion) {
        return null;
    }
    
    /**
     * 从URI导入日历
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object importCalendar(@org.jetbrains.annotations.NotNull
    android.net.Uri uri, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.daymate.data.Event>> $completion) {
        return null;
    }
    
    /**
     * 从文件路径导入日历
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object importCalendarFromFile(@org.jetbrains.annotations.NotNull
    java.lang.String filePath, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.daymate.data.Event>> $completion) {
        return null;
    }
    
    /**
     * 生成默认文件名
     */
    private final java.lang.String generateFileName() {
        return null;
    }
    
    /**
     * 获取导出目录的文件列表
     */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.io.File> getExportFiles() {
        return null;
    }
    
    /**
     * 删除导出文件
     */
    public final boolean deleteExportFile(@org.jetbrains.annotations.NotNull
    java.io.File file) {
        return false;
    }
    
    /**
     * 检查存储权限
     */
    public final boolean hasStoragePermission() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/daymate/utils/FileManager$Companion;", "", "()V", "AUTHORITY", "", "FILE_NAME_PREFIX", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}