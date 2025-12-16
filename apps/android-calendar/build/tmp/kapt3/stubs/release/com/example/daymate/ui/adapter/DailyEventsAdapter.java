package com.example.daymate.ui.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\b2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/daymate/ui/adapter/DailyEventsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/daymate/ui/adapter/DailyEventsAdapter$EventViewHolder;", "events", "", "Lcom/example/daymate/data/Event;", "onEventClick", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "timeFormatter", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "EventViewHolder", "app_release"})
public final class DailyEventsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.daymate.ui.adapter.DailyEventsAdapter.EventViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.daymate.data.Event> events = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.example.daymate.data.Event, kotlin.Unit> onEventClick = null;
    private final java.time.format.DateTimeFormatter timeFormatter = null;
    
    public DailyEventsAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.daymate.data.Event> events, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.daymate.data.Event, kotlin.Unit> onEventClick) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.daymate.ui.adapter.DailyEventsAdapter.EventViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.daymate.ui.adapter.DailyEventsAdapter.EventViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/daymate/ui/adapter/DailyEventsAdapter$EventViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/daymate/databinding/ItemDailyEventBinding;", "(Lcom/example/daymate/ui/adapter/DailyEventsAdapter;Lcom/example/daymate/databinding/ItemDailyEventBinding;)V", "bind", "", "event", "Lcom/example/daymate/data/Event;", "app_release"})
    public final class EventViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.example.daymate.databinding.ItemDailyEventBinding binding = null;
        
        public EventViewHolder(@org.jetbrains.annotations.NotNull
        com.example.daymate.databinding.ItemDailyEventBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.example.daymate.data.Event event) {
        }
    }
}