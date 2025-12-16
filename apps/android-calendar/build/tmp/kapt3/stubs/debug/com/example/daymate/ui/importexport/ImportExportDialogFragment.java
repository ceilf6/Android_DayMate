package com.example.daymate.ui.importexport;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0016H\u0016J\u001a\u0010\'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010)\u001a\u00020\u0016H\u0002J\b\u0010*\u001a\u00020\u0016H\u0002J\b\u0010+\u001a\u00020\u0016H\u0002J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006."}, d2 = {"Lcom/example/daymate/ui/importexport/ImportExportDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "_binding", "Lcom/example/daymate/databinding/DialogImportExportBinding;", "binding", "getBinding", "()Lcom/example/daymate/databinding/DialogImportExportBinding;", "exportLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "fileManager", "Lcom/example/daymate/utils/FileManager;", "importLauncher", "viewModel", "Lcom/example/daymate/viewmodel/CalendarViewModel;", "getViewModel", "()Lcom/example/daymate/viewmodel/CalendarViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "exportCalendar", "", "uri", "Landroid/net/Uri;", "getCurrentEvents", "", "Lcom/example/daymate/data/Event;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importCalendar", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "openFilePicker", "setupClickListeners", "setupViews", "shareFile", "Companion", "android-calendar_debug"})
public final class ImportExportDialogFragment extends androidx.fragment.app.DialogFragment {
    @org.jetbrains.annotations.Nullable
    private com.example.daymate.databinding.DialogImportExportBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.daymate.utils.FileManager fileManager = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> importLauncher = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> exportLauncher = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.daymate.ui.importexport.ImportExportDialogFragment.Companion Companion = null;
    
    public ImportExportDialogFragment() {
        super();
    }
    
    private final com.example.daymate.databinding.DialogImportExportBinding getBinding() {
        return null;
    }
    
    private final com.example.daymate.viewmodel.CalendarViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupViews() {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void openFilePicker() {
    }
    
    private final void exportCalendar() {
    }
    
    private final void exportCalendar(android.net.Uri uri) {
    }
    
    private final void importCalendar(android.net.Uri uri) {
    }
    
    private final java.lang.Object getCurrentEvents(kotlin.coroutines.Continuation<? super java.util.List<com.example.daymate.data.Event>> $completion) {
        return null;
    }
    
    private final void shareFile(android.net.Uri uri) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/daymate/ui/importexport/ImportExportDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/example/daymate/ui/importexport/ImportExportDialogFragment;", "android-calendar_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.daymate.ui.importexport.ImportExportDialogFragment newInstance() {
            return null;
        }
    }
}