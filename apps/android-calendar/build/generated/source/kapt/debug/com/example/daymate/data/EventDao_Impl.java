package com.example.daymate.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EventDao_Impl implements EventDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Event> __insertionAdapterOfEvent;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<Event> __deletionAdapterOfEvent;

  private final EntityDeletionOrUpdateAdapter<Event> __updateAdapterOfEvent;

  private final SharedSQLiteStatement __preparedStmtOfDeleteEventById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteRecurringEvents;

  public EventDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEvent = new EntityInsertionAdapter<Event>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `events` (`id`,`title`,`description`,`location`,`startTime`,`endTime`,`allDay`,`recurrenceRule`,`recurrenceId`,`reminderMinutes`,`category`,`priority`,`status`,`transparency`,`createdAt`,`updatedAt`,`calendarId`,`externalId`,`lunarDate`,`isLunarEvent`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Event entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getLocation());
        }
        final String _tmp = __converters.fromLocalDateTime(entity.getStartTime());
        if (_tmp == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, _tmp);
        }
        final String _tmp_1 = __converters.fromLocalDateTime(entity.getEndTime());
        if (_tmp_1 == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, _tmp_1);
        }
        final int _tmp_2 = entity.getAllDay() ? 1 : 0;
        statement.bindLong(7, _tmp_2);
        if (entity.getRecurrenceRule() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getRecurrenceRule());
        }
        if (entity.getRecurrenceId() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getRecurrenceId());
        }
        if (entity.getReminderMinutes() == null) {
          statement.bindNull(10);
        } else {
          statement.bindLong(10, entity.getReminderMinutes());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getCategory());
        }
        statement.bindLong(12, entity.getPriority());
        statement.bindString(13, __EventStatus_enumToString(entity.getStatus()));
        statement.bindString(14, __Transparency_enumToString(entity.getTransparency()));
        final String _tmp_3 = __converters.fromLocalDateTime(entity.getCreatedAt());
        if (_tmp_3 == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, _tmp_3);
        }
        final String _tmp_4 = __converters.fromLocalDateTime(entity.getUpdatedAt());
        if (_tmp_4 == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, _tmp_4);
        }
        if (entity.getCalendarId() == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, entity.getCalendarId());
        }
        if (entity.getExternalId() == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, entity.getExternalId());
        }
        if (entity.getLunarDate() == null) {
          statement.bindNull(19);
        } else {
          statement.bindString(19, entity.getLunarDate());
        }
        final int _tmp_5 = entity.isLunarEvent() ? 1 : 0;
        statement.bindLong(20, _tmp_5);
      }
    };
    this.__deletionAdapterOfEvent = new EntityDeletionOrUpdateAdapter<Event>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `events` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Event entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfEvent = new EntityDeletionOrUpdateAdapter<Event>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `events` SET `id` = ?,`title` = ?,`description` = ?,`location` = ?,`startTime` = ?,`endTime` = ?,`allDay` = ?,`recurrenceRule` = ?,`recurrenceId` = ?,`reminderMinutes` = ?,`category` = ?,`priority` = ?,`status` = ?,`transparency` = ?,`createdAt` = ?,`updatedAt` = ?,`calendarId` = ?,`externalId` = ?,`lunarDate` = ?,`isLunarEvent` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Event entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getLocation());
        }
        final String _tmp = __converters.fromLocalDateTime(entity.getStartTime());
        if (_tmp == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, _tmp);
        }
        final String _tmp_1 = __converters.fromLocalDateTime(entity.getEndTime());
        if (_tmp_1 == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, _tmp_1);
        }
        final int _tmp_2 = entity.getAllDay() ? 1 : 0;
        statement.bindLong(7, _tmp_2);
        if (entity.getRecurrenceRule() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getRecurrenceRule());
        }
        if (entity.getRecurrenceId() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getRecurrenceId());
        }
        if (entity.getReminderMinutes() == null) {
          statement.bindNull(10);
        } else {
          statement.bindLong(10, entity.getReminderMinutes());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getCategory());
        }
        statement.bindLong(12, entity.getPriority());
        statement.bindString(13, __EventStatus_enumToString(entity.getStatus()));
        statement.bindString(14, __Transparency_enumToString(entity.getTransparency()));
        final String _tmp_3 = __converters.fromLocalDateTime(entity.getCreatedAt());
        if (_tmp_3 == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, _tmp_3);
        }
        final String _tmp_4 = __converters.fromLocalDateTime(entity.getUpdatedAt());
        if (_tmp_4 == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, _tmp_4);
        }
        if (entity.getCalendarId() == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, entity.getCalendarId());
        }
        if (entity.getExternalId() == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, entity.getExternalId());
        }
        if (entity.getLunarDate() == null) {
          statement.bindNull(19);
        } else {
          statement.bindString(19, entity.getLunarDate());
        }
        final int _tmp_5 = entity.isLunarEvent() ? 1 : 0;
        statement.bindLong(20, _tmp_5);
        statement.bindLong(21, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteEventById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM events WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteRecurringEvents = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM events WHERE recurrenceId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertEvent(final Event event, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfEvent.insertAndReturnId(event);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteEvent(final Event event, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfEvent.handle(event);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateEvent(final Event event, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfEvent.handle(event);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteEventById(final long id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteEventById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteEventById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteRecurringEvents(final long recurrenceId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteRecurringEvents.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, recurrenceId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteRecurringEvents.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Event>> getAllEvents() {
    final String _sql = "SELECT * FROM events ORDER BY startTime ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"events"}, new Callable<List<Event>>() {
      @Override
      @NonNull
      public List<Event> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfAllDay = CursorUtil.getColumnIndexOrThrow(_cursor, "allDay");
          final int _cursorIndexOfRecurrenceRule = CursorUtil.getColumnIndexOrThrow(_cursor, "recurrenceRule");
          final int _cursorIndexOfRecurrenceId = CursorUtil.getColumnIndexOrThrow(_cursor, "recurrenceId");
          final int _cursorIndexOfReminderMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderMinutes");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfTransparency = CursorUtil.getColumnIndexOrThrow(_cursor, "transparency");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfCalendarId = CursorUtil.getColumnIndexOrThrow(_cursor, "calendarId");
          final int _cursorIndexOfExternalId = CursorUtil.getColumnIndexOrThrow(_cursor, "externalId");
          final int _cursorIndexOfLunarDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lunarDate");
          final int _cursorIndexOfIsLunarEvent = CursorUtil.getColumnIndexOrThrow(_cursor, "isLunarEvent");
          final List<Event> _result = new ArrayList<Event>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Event _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final LocalDateTime _tmpStartTime;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfStartTime);
            }
            _tmpStartTime = __converters.toLocalDateTime(_tmp);
            final LocalDateTime _tmpEndTime;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfEndTime);
            }
            _tmpEndTime = __converters.toLocalDateTime(_tmp_1);
            final boolean _tmpAllDay;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfAllDay);
            _tmpAllDay = _tmp_2 != 0;
            final String _tmpRecurrenceRule;
            if (_cursor.isNull(_cursorIndexOfRecurrenceRule)) {
              _tmpRecurrenceRule = null;
            } else {
              _tmpRecurrenceRule = _cursor.getString(_cursorIndexOfRecurrenceRule);
            }
            final Long _tmpRecurrenceId;
            if (_cursor.isNull(_cursorIndexOfRecurrenceId)) {
              _tmpRecurrenceId = null;
            } else {
              _tmpRecurrenceId = _cursor.getLong(_cursorIndexOfRecurrenceId);
            }
            final Integer _tmpReminderMinutes;
            if (_cursor.isNull(_cursorIndexOfReminderMinutes)) {
              _tmpReminderMinutes = null;
            } else {
              _tmpReminderMinutes = _cursor.getInt(_cursorIndexOfReminderMinutes);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final int _tmpPriority;
            _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
            final EventStatus _tmpStatus;
            _tmpStatus = __EventStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final Transparency _tmpTransparency;
            _tmpTransparency = __Transparency_stringToEnum(_cursor.getString(_cursorIndexOfTransparency));
            final LocalDateTime _tmpCreatedAt;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __converters.toLocalDateTime(_tmp_3);
            final LocalDateTime _tmpUpdatedAt;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __converters.toLocalDateTime(_tmp_4);
            final String _tmpCalendarId;
            if (_cursor.isNull(_cursorIndexOfCalendarId)) {
              _tmpCalendarId = null;
            } else {
              _tmpCalendarId = _cursor.getString(_cursorIndexOfCalendarId);
            }
            final String _tmpExternalId;
            if (_cursor.isNull(_cursorIndexOfExternalId)) {
              _tmpExternalId = null;
            } else {
              _tmpExternalId = _cursor.getString(_cursorIndexOfExternalId);
            }
            final String _tmpLunarDate;
            if (_cursor.isNull(_cursorIndexOfLunarDate)) {
              _tmpLunarDate = null;
            } else {
              _tmpLunarDate = _cursor.getString(_cursorIndexOfLunarDate);
            }
            final boolean _tmpIsLunarEvent;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsLunarEvent);
            _tmpIsLunarEvent = _tmp_5 != 0;
            _item = new Event(_tmpId,_tmpTitle,_tmpDescription,_tmpLocation,_tmpStartTime,_tmpEndTime,_tmpAllDay,_tmpRecurrenceRule,_tmpRecurrenceId,_tmpReminderMinutes,_tmpCategory,_tmpPriority,_tmpStatus,_tmpTransparency,_tmpCreatedAt,_tmpUpdatedAt,_tmpCalendarId,_tmpExternalId,_tmpLunarDate,_tmpIsLunarEvent);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getEventById(final long id, final Continuation<? super Event> $completion) {
    final String _sql = "SELECT * FROM events WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Event>() {
      @Override
      @Nullable
      public Event call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfAllDay = CursorUtil.getColumnIndexOrThrow(_cursor, "allDay");
          final int _cursorIndexOfRecurrenceRule = CursorUtil.getColumnIndexOrThrow(_cursor, "recurrenceRule");
          final int _cursorIndexOfRecurrenceId = CursorUtil.getColumnIndexOrThrow(_cursor, "recurrenceId");
          final int _cursorIndexOfReminderMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderMinutes");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfTransparency = CursorUtil.getColumnIndexOrThrow(_cursor, "transparency");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfCalendarId = CursorUtil.getColumnIndexOrThrow(_cursor, "calendarId");
          final int _cursorIndexOfExternalId = CursorUtil.getColumnIndexOrThrow(_cursor, "externalId");
          final int _cursorIndexOfLunarDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lunarDate");
          final int _cursorIndexOfIsLunarEvent = CursorUtil.getColumnIndexOrThrow(_cursor, "isLunarEvent");
          final Event _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final LocalDateTime _tmpStartTime;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfStartTime);
            }
            _tmpStartTime = __converters.toLocalDateTime(_tmp);
            final LocalDateTime _tmpEndTime;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfEndTime);
            }
            _tmpEndTime = __converters.toLocalDateTime(_tmp_1);
            final boolean _tmpAllDay;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfAllDay);
            _tmpAllDay = _tmp_2 != 0;
            final String _tmpRecurrenceRule;
            if (_cursor.isNull(_cursorIndexOfRecurrenceRule)) {
              _tmpRecurrenceRule = null;
            } else {
              _tmpRecurrenceRule = _cursor.getString(_cursorIndexOfRecurrenceRule);
            }
            final Long _tmpRecurrenceId;
            if (_cursor.isNull(_cursorIndexOfRecurrenceId)) {
              _tmpRecurrenceId = null;
            } else {
              _tmpRecurrenceId = _cursor.getLong(_cursorIndexOfRecurrenceId);
            }
            final Integer _tmpReminderMinutes;
            if (_cursor.isNull(_cursorIndexOfReminderMinutes)) {
              _tmpReminderMinutes = null;
            } else {
              _tmpReminderMinutes = _cursor.getInt(_cursorIndexOfReminderMinutes);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final int _tmpPriority;
            _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
            final EventStatus _tmpStatus;
            _tmpStatus = __EventStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final Transparency _tmpTransparency;
            _tmpTransparency = __Transparency_stringToEnum(_cursor.getString(_cursorIndexOfTransparency));
            final LocalDateTime _tmpCreatedAt;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __converters.toLocalDateTime(_tmp_3);
            final LocalDateTime _tmpUpdatedAt;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __converters.toLocalDateTime(_tmp_4);
            final String _tmpCalendarId;
            if (_cursor.isNull(_cursorIndexOfCalendarId)) {
              _tmpCalendarId = null;
            } else {
              _tmpCalendarId = _cursor.getString(_cursorIndexOfCalendarId);
            }
            final String _tmpExternalId;
            if (_cursor.isNull(_cursorIndexOfExternalId)) {
              _tmpExternalId = null;
            } else {
              _tmpExternalId = _cursor.getString(_cursorIndexOfExternalId);
            }
            final String _tmpLunarDate;
            if (_cursor.isNull(_cursorIndexOfLunarDate)) {
              _tmpLunarDate = null;
            } else {
              _tmpLunarDate = _cursor.getString(_cursorIndexOfLunarDate);
            }
            final boolean _tmpIsLunarEvent;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsLunarEvent);
            _tmpIsLunarEvent = _tmp_5 != 0;
            _result = new Event(_tmpId,_tmpTitle,_tmpDescription,_tmpLocation,_tmpStartTime,_tmpEndTime,_tmpAllDay,_tmpRecurrenceRule,_tmpRecurrenceId,_tmpReminderMinutes,_tmpCategory,_tmpPriority,_tmpStatus,_tmpTransparency,_tmpCreatedAt,_tmpUpdatedAt,_tmpCalendarId,_tmpExternalId,_tmpLunarDate,_tmpIsLunarEvent);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Event>> getEventsByDateRange(final LocalDateTime startDate,
      final LocalDateTime endDate) {
    final String _sql = "SELECT * FROM events WHERE startTime >= ? AND startTime <= ? ORDER BY startTime ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    final String _tmp = __converters.fromLocalDateTime(startDate);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    _argIndex = 2;
    final String _tmp_1 = __converters.fromLocalDateTime(endDate);
    if (_tmp_1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp_1);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"events"}, new Callable<List<Event>>() {
      @Override
      @NonNull
      public List<Event> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfAllDay = CursorUtil.getColumnIndexOrThrow(_cursor, "allDay");
          final int _cursorIndexOfRecurrenceRule = CursorUtil.getColumnIndexOrThrow(_cursor, "recurrenceRule");
          final int _cursorIndexOfRecurrenceId = CursorUtil.getColumnIndexOrThrow(_cursor, "recurrenceId");
          final int _cursorIndexOfReminderMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderMinutes");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfTransparency = CursorUtil.getColumnIndexOrThrow(_cursor, "transparency");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfCalendarId = CursorUtil.getColumnIndexOrThrow(_cursor, "calendarId");
          final int _cursorIndexOfExternalId = CursorUtil.getColumnIndexOrThrow(_cursor, "externalId");
          final int _cursorIndexOfLunarDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lunarDate");
          final int _cursorIndexOfIsLunarEvent = CursorUtil.getColumnIndexOrThrow(_cursor, "isLunarEvent");
          final List<Event> _result = new ArrayList<Event>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Event _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final LocalDateTime _tmpStartTime;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfStartTime);
            }
            _tmpStartTime = __converters.toLocalDateTime(_tmp_2);
            final LocalDateTime _tmpEndTime;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfEndTime);
            }
            _tmpEndTime = __converters.toLocalDateTime(_tmp_3);
            final boolean _tmpAllDay;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfAllDay);
            _tmpAllDay = _tmp_4 != 0;
            final String _tmpRecurrenceRule;
            if (_cursor.isNull(_cursorIndexOfRecurrenceRule)) {
              _tmpRecurrenceRule = null;
            } else {
              _tmpRecurrenceRule = _cursor.getString(_cursorIndexOfRecurrenceRule);
            }
            final Long _tmpRecurrenceId;
            if (_cursor.isNull(_cursorIndexOfRecurrenceId)) {
              _tmpRecurrenceId = null;
            } else {
              _tmpRecurrenceId = _cursor.getLong(_cursorIndexOfRecurrenceId);
            }
            final Integer _tmpReminderMinutes;
            if (_cursor.isNull(_cursorIndexOfReminderMinutes)) {
              _tmpReminderMinutes = null;
            } else {
              _tmpReminderMinutes = _cursor.getInt(_cursorIndexOfReminderMinutes);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final int _tmpPriority;
            _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
            final EventStatus _tmpStatus;
            _tmpStatus = __EventStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final Transparency _tmpTransparency;
            _tmpTransparency = __Transparency_stringToEnum(_cursor.getString(_cursorIndexOfTransparency));
            final LocalDateTime _tmpCreatedAt;
            final String _tmp_5;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_5 = null;
            } else {
              _tmp_5 = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __converters.toLocalDateTime(_tmp_5);
            final LocalDateTime _tmpUpdatedAt;
            final String _tmp_6;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_6 = null;
            } else {
              _tmp_6 = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __converters.toLocalDateTime(_tmp_6);
            final String _tmpCalendarId;
            if (_cursor.isNull(_cursorIndexOfCalendarId)) {
              _tmpCalendarId = null;
            } else {
              _tmpCalendarId = _cursor.getString(_cursorIndexOfCalendarId);
            }
            final String _tmpExternalId;
            if (_cursor.isNull(_cursorIndexOfExternalId)) {
              _tmpExternalId = null;
            } else {
              _tmpExternalId = _cursor.getString(_cursorIndexOfExternalId);
            }
            final String _tmpLunarDate;
            if (_cursor.isNull(_cursorIndexOfLunarDate)) {
              _tmpLunarDate = null;
            } else {
              _tmpLunarDate = _cursor.getString(_cursorIndexOfLunarDate);
            }
            final boolean _tmpIsLunarEvent;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsLunarEvent);
            _tmpIsLunarEvent = _tmp_7 != 0;
            _item = new Event(_tmpId,_tmpTitle,_tmpDescription,_tmpLocation,_tmpStartTime,_tmpEndTime,_tmpAllDay,_tmpRecurrenceRule,_tmpRecurrenceId,_tmpReminderMinutes,_tmpCategory,_tmpPriority,_tmpStatus,_tmpTransparency,_tmpCreatedAt,_tmpUpdatedAt,_tmpCalendarId,_tmpExternalId,_tmpLunarDate,_tmpIsLunarEvent);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Event>> getEventsByDate(final LocalDateTime date) {
    final String _sql = "SELECT * FROM events WHERE DATE(startTime) = DATE(?) ORDER BY startTime ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __converters.fromLocalDateTime(date);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"events"}, new Callable<List<Event>>() {
      @Override
      @NonNull
      public List<Event> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfAllDay = CursorUtil.getColumnIndexOrThrow(_cursor, "allDay");
          final int _cursorIndexOfRecurrenceRule = CursorUtil.getColumnIndexOrThrow(_cursor, "recurrenceRule");
          final int _cursorIndexOfRecurrenceId = CursorUtil.getColumnIndexOrThrow(_cursor, "recurrenceId");
          final int _cursorIndexOfReminderMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderMinutes");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfTransparency = CursorUtil.getColumnIndexOrThrow(_cursor, "transparency");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfCalendarId = CursorUtil.getColumnIndexOrThrow(_cursor, "calendarId");
          final int _cursorIndexOfExternalId = CursorUtil.getColumnIndexOrThrow(_cursor, "externalId");
          final int _cursorIndexOfLunarDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lunarDate");
          final int _cursorIndexOfIsLunarEvent = CursorUtil.getColumnIndexOrThrow(_cursor, "isLunarEvent");
          final List<Event> _result = new ArrayList<Event>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Event _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final LocalDateTime _tmpStartTime;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfStartTime);
            }
            _tmpStartTime = __converters.toLocalDateTime(_tmp_1);
            final LocalDateTime _tmpEndTime;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfEndTime);
            }
            _tmpEndTime = __converters.toLocalDateTime(_tmp_2);
            final boolean _tmpAllDay;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfAllDay);
            _tmpAllDay = _tmp_3 != 0;
            final String _tmpRecurrenceRule;
            if (_cursor.isNull(_cursorIndexOfRecurrenceRule)) {
              _tmpRecurrenceRule = null;
            } else {
              _tmpRecurrenceRule = _cursor.getString(_cursorIndexOfRecurrenceRule);
            }
            final Long _tmpRecurrenceId;
            if (_cursor.isNull(_cursorIndexOfRecurrenceId)) {
              _tmpRecurrenceId = null;
            } else {
              _tmpRecurrenceId = _cursor.getLong(_cursorIndexOfRecurrenceId);
            }
            final Integer _tmpReminderMinutes;
            if (_cursor.isNull(_cursorIndexOfReminderMinutes)) {
              _tmpReminderMinutes = null;
            } else {
              _tmpReminderMinutes = _cursor.getInt(_cursorIndexOfReminderMinutes);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final int _tmpPriority;
            _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
            final EventStatus _tmpStatus;
            _tmpStatus = __EventStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final Transparency _tmpTransparency;
            _tmpTransparency = __Transparency_stringToEnum(_cursor.getString(_cursorIndexOfTransparency));
            final LocalDateTime _tmpCreatedAt;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __converters.toLocalDateTime(_tmp_4);
            final LocalDateTime _tmpUpdatedAt;
            final String _tmp_5;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_5 = null;
            } else {
              _tmp_5 = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __converters.toLocalDateTime(_tmp_5);
            final String _tmpCalendarId;
            if (_cursor.isNull(_cursorIndexOfCalendarId)) {
              _tmpCalendarId = null;
            } else {
              _tmpCalendarId = _cursor.getString(_cursorIndexOfCalendarId);
            }
            final String _tmpExternalId;
            if (_cursor.isNull(_cursorIndexOfExternalId)) {
              _tmpExternalId = null;
            } else {
              _tmpExternalId = _cursor.getString(_cursorIndexOfExternalId);
            }
            final String _tmpLunarDate;
            if (_cursor.isNull(_cursorIndexOfLunarDate)) {
              _tmpLunarDate = null;
            } else {
              _tmpLunarDate = _cursor.getString(_cursorIndexOfLunarDate);
            }
            final boolean _tmpIsLunarEvent;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsLunarEvent);
            _tmpIsLunarEvent = _tmp_6 != 0;
            _item = new Event(_tmpId,_tmpTitle,_tmpDescription,_tmpLocation,_tmpStartTime,_tmpEndTime,_tmpAllDay,_tmpRecurrenceRule,_tmpRecurrenceId,_tmpReminderMinutes,_tmpCategory,_tmpPriority,_tmpStatus,_tmpTransparency,_tmpCreatedAt,_tmpUpdatedAt,_tmpCalendarId,_tmpExternalId,_tmpLunarDate,_tmpIsLunarEvent);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Event>> searchEvents(final String searchQuery) {
    final String _sql = "SELECT * FROM events WHERE title LIKE ? OR description LIKE ? OR location LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (searchQuery == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchQuery);
    }
    _argIndex = 2;
    if (searchQuery == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchQuery);
    }
    _argIndex = 3;
    if (searchQuery == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchQuery);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"events"}, new Callable<List<Event>>() {
      @Override
      @NonNull
      public List<Event> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfAllDay = CursorUtil.getColumnIndexOrThrow(_cursor, "allDay");
          final int _cursorIndexOfRecurrenceRule = CursorUtil.getColumnIndexOrThrow(_cursor, "recurrenceRule");
          final int _cursorIndexOfRecurrenceId = CursorUtil.getColumnIndexOrThrow(_cursor, "recurrenceId");
          final int _cursorIndexOfReminderMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderMinutes");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfTransparency = CursorUtil.getColumnIndexOrThrow(_cursor, "transparency");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfCalendarId = CursorUtil.getColumnIndexOrThrow(_cursor, "calendarId");
          final int _cursorIndexOfExternalId = CursorUtil.getColumnIndexOrThrow(_cursor, "externalId");
          final int _cursorIndexOfLunarDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lunarDate");
          final int _cursorIndexOfIsLunarEvent = CursorUtil.getColumnIndexOrThrow(_cursor, "isLunarEvent");
          final List<Event> _result = new ArrayList<Event>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Event _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final LocalDateTime _tmpStartTime;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfStartTime);
            }
            _tmpStartTime = __converters.toLocalDateTime(_tmp);
            final LocalDateTime _tmpEndTime;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfEndTime);
            }
            _tmpEndTime = __converters.toLocalDateTime(_tmp_1);
            final boolean _tmpAllDay;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfAllDay);
            _tmpAllDay = _tmp_2 != 0;
            final String _tmpRecurrenceRule;
            if (_cursor.isNull(_cursorIndexOfRecurrenceRule)) {
              _tmpRecurrenceRule = null;
            } else {
              _tmpRecurrenceRule = _cursor.getString(_cursorIndexOfRecurrenceRule);
            }
            final Long _tmpRecurrenceId;
            if (_cursor.isNull(_cursorIndexOfRecurrenceId)) {
              _tmpRecurrenceId = null;
            } else {
              _tmpRecurrenceId = _cursor.getLong(_cursorIndexOfRecurrenceId);
            }
            final Integer _tmpReminderMinutes;
            if (_cursor.isNull(_cursorIndexOfReminderMinutes)) {
              _tmpReminderMinutes = null;
            } else {
              _tmpReminderMinutes = _cursor.getInt(_cursorIndexOfReminderMinutes);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final int _tmpPriority;
            _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
            final EventStatus _tmpStatus;
            _tmpStatus = __EventStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final Transparency _tmpTransparency;
            _tmpTransparency = __Transparency_stringToEnum(_cursor.getString(_cursorIndexOfTransparency));
            final LocalDateTime _tmpCreatedAt;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __converters.toLocalDateTime(_tmp_3);
            final LocalDateTime _tmpUpdatedAt;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __converters.toLocalDateTime(_tmp_4);
            final String _tmpCalendarId;
            if (_cursor.isNull(_cursorIndexOfCalendarId)) {
              _tmpCalendarId = null;
            } else {
              _tmpCalendarId = _cursor.getString(_cursorIndexOfCalendarId);
            }
            final String _tmpExternalId;
            if (_cursor.isNull(_cursorIndexOfExternalId)) {
              _tmpExternalId = null;
            } else {
              _tmpExternalId = _cursor.getString(_cursorIndexOfExternalId);
            }
            final String _tmpLunarDate;
            if (_cursor.isNull(_cursorIndexOfLunarDate)) {
              _tmpLunarDate = null;
            } else {
              _tmpLunarDate = _cursor.getString(_cursorIndexOfLunarDate);
            }
            final boolean _tmpIsLunarEvent;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsLunarEvent);
            _tmpIsLunarEvent = _tmp_5 != 0;
            _item = new Event(_tmpId,_tmpTitle,_tmpDescription,_tmpLocation,_tmpStartTime,_tmpEndTime,_tmpAllDay,_tmpRecurrenceRule,_tmpRecurrenceId,_tmpReminderMinutes,_tmpCategory,_tmpPriority,_tmpStatus,_tmpTransparency,_tmpCreatedAt,_tmpUpdatedAt,_tmpCalendarId,_tmpExternalId,_tmpLunarDate,_tmpIsLunarEvent);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Event>> getEventsByCategory(final String category) {
    final String _sql = "SELECT * FROM events WHERE category = ? ORDER BY startTime ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"events"}, new Callable<List<Event>>() {
      @Override
      @NonNull
      public List<Event> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfAllDay = CursorUtil.getColumnIndexOrThrow(_cursor, "allDay");
          final int _cursorIndexOfRecurrenceRule = CursorUtil.getColumnIndexOrThrow(_cursor, "recurrenceRule");
          final int _cursorIndexOfRecurrenceId = CursorUtil.getColumnIndexOrThrow(_cursor, "recurrenceId");
          final int _cursorIndexOfReminderMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderMinutes");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfTransparency = CursorUtil.getColumnIndexOrThrow(_cursor, "transparency");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfCalendarId = CursorUtil.getColumnIndexOrThrow(_cursor, "calendarId");
          final int _cursorIndexOfExternalId = CursorUtil.getColumnIndexOrThrow(_cursor, "externalId");
          final int _cursorIndexOfLunarDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lunarDate");
          final int _cursorIndexOfIsLunarEvent = CursorUtil.getColumnIndexOrThrow(_cursor, "isLunarEvent");
          final List<Event> _result = new ArrayList<Event>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Event _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final LocalDateTime _tmpStartTime;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfStartTime);
            }
            _tmpStartTime = __converters.toLocalDateTime(_tmp);
            final LocalDateTime _tmpEndTime;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfEndTime);
            }
            _tmpEndTime = __converters.toLocalDateTime(_tmp_1);
            final boolean _tmpAllDay;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfAllDay);
            _tmpAllDay = _tmp_2 != 0;
            final String _tmpRecurrenceRule;
            if (_cursor.isNull(_cursorIndexOfRecurrenceRule)) {
              _tmpRecurrenceRule = null;
            } else {
              _tmpRecurrenceRule = _cursor.getString(_cursorIndexOfRecurrenceRule);
            }
            final Long _tmpRecurrenceId;
            if (_cursor.isNull(_cursorIndexOfRecurrenceId)) {
              _tmpRecurrenceId = null;
            } else {
              _tmpRecurrenceId = _cursor.getLong(_cursorIndexOfRecurrenceId);
            }
            final Integer _tmpReminderMinutes;
            if (_cursor.isNull(_cursorIndexOfReminderMinutes)) {
              _tmpReminderMinutes = null;
            } else {
              _tmpReminderMinutes = _cursor.getInt(_cursorIndexOfReminderMinutes);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final int _tmpPriority;
            _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
            final EventStatus _tmpStatus;
            _tmpStatus = __EventStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final Transparency _tmpTransparency;
            _tmpTransparency = __Transparency_stringToEnum(_cursor.getString(_cursorIndexOfTransparency));
            final LocalDateTime _tmpCreatedAt;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __converters.toLocalDateTime(_tmp_3);
            final LocalDateTime _tmpUpdatedAt;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __converters.toLocalDateTime(_tmp_4);
            final String _tmpCalendarId;
            if (_cursor.isNull(_cursorIndexOfCalendarId)) {
              _tmpCalendarId = null;
            } else {
              _tmpCalendarId = _cursor.getString(_cursorIndexOfCalendarId);
            }
            final String _tmpExternalId;
            if (_cursor.isNull(_cursorIndexOfExternalId)) {
              _tmpExternalId = null;
            } else {
              _tmpExternalId = _cursor.getString(_cursorIndexOfExternalId);
            }
            final String _tmpLunarDate;
            if (_cursor.isNull(_cursorIndexOfLunarDate)) {
              _tmpLunarDate = null;
            } else {
              _tmpLunarDate = _cursor.getString(_cursorIndexOfLunarDate);
            }
            final boolean _tmpIsLunarEvent;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsLunarEvent);
            _tmpIsLunarEvent = _tmp_5 != 0;
            _item = new Event(_tmpId,_tmpTitle,_tmpDescription,_tmpLocation,_tmpStartTime,_tmpEndTime,_tmpAllDay,_tmpRecurrenceRule,_tmpRecurrenceId,_tmpReminderMinutes,_tmpCategory,_tmpPriority,_tmpStatus,_tmpTransparency,_tmpCreatedAt,_tmpUpdatedAt,_tmpCalendarId,_tmpExternalId,_tmpLunarDate,_tmpIsLunarEvent);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Event>> getLunarEvents() {
    final String _sql = "SELECT * FROM events WHERE isLunarEvent = 1 ORDER BY startTime ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"events"}, new Callable<List<Event>>() {
      @Override
      @NonNull
      public List<Event> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfAllDay = CursorUtil.getColumnIndexOrThrow(_cursor, "allDay");
          final int _cursorIndexOfRecurrenceRule = CursorUtil.getColumnIndexOrThrow(_cursor, "recurrenceRule");
          final int _cursorIndexOfRecurrenceId = CursorUtil.getColumnIndexOrThrow(_cursor, "recurrenceId");
          final int _cursorIndexOfReminderMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderMinutes");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfTransparency = CursorUtil.getColumnIndexOrThrow(_cursor, "transparency");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfCalendarId = CursorUtil.getColumnIndexOrThrow(_cursor, "calendarId");
          final int _cursorIndexOfExternalId = CursorUtil.getColumnIndexOrThrow(_cursor, "externalId");
          final int _cursorIndexOfLunarDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lunarDate");
          final int _cursorIndexOfIsLunarEvent = CursorUtil.getColumnIndexOrThrow(_cursor, "isLunarEvent");
          final List<Event> _result = new ArrayList<Event>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Event _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final LocalDateTime _tmpStartTime;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfStartTime);
            }
            _tmpStartTime = __converters.toLocalDateTime(_tmp);
            final LocalDateTime _tmpEndTime;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfEndTime);
            }
            _tmpEndTime = __converters.toLocalDateTime(_tmp_1);
            final boolean _tmpAllDay;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfAllDay);
            _tmpAllDay = _tmp_2 != 0;
            final String _tmpRecurrenceRule;
            if (_cursor.isNull(_cursorIndexOfRecurrenceRule)) {
              _tmpRecurrenceRule = null;
            } else {
              _tmpRecurrenceRule = _cursor.getString(_cursorIndexOfRecurrenceRule);
            }
            final Long _tmpRecurrenceId;
            if (_cursor.isNull(_cursorIndexOfRecurrenceId)) {
              _tmpRecurrenceId = null;
            } else {
              _tmpRecurrenceId = _cursor.getLong(_cursorIndexOfRecurrenceId);
            }
            final Integer _tmpReminderMinutes;
            if (_cursor.isNull(_cursorIndexOfReminderMinutes)) {
              _tmpReminderMinutes = null;
            } else {
              _tmpReminderMinutes = _cursor.getInt(_cursorIndexOfReminderMinutes);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final int _tmpPriority;
            _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
            final EventStatus _tmpStatus;
            _tmpStatus = __EventStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final Transparency _tmpTransparency;
            _tmpTransparency = __Transparency_stringToEnum(_cursor.getString(_cursorIndexOfTransparency));
            final LocalDateTime _tmpCreatedAt;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __converters.toLocalDateTime(_tmp_3);
            final LocalDateTime _tmpUpdatedAt;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __converters.toLocalDateTime(_tmp_4);
            final String _tmpCalendarId;
            if (_cursor.isNull(_cursorIndexOfCalendarId)) {
              _tmpCalendarId = null;
            } else {
              _tmpCalendarId = _cursor.getString(_cursorIndexOfCalendarId);
            }
            final String _tmpExternalId;
            if (_cursor.isNull(_cursorIndexOfExternalId)) {
              _tmpExternalId = null;
            } else {
              _tmpExternalId = _cursor.getString(_cursorIndexOfExternalId);
            }
            final String _tmpLunarDate;
            if (_cursor.isNull(_cursorIndexOfLunarDate)) {
              _tmpLunarDate = null;
            } else {
              _tmpLunarDate = _cursor.getString(_cursorIndexOfLunarDate);
            }
            final boolean _tmpIsLunarEvent;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsLunarEvent);
            _tmpIsLunarEvent = _tmp_5 != 0;
            _item = new Event(_tmpId,_tmpTitle,_tmpDescription,_tmpLocation,_tmpStartTime,_tmpEndTime,_tmpAllDay,_tmpRecurrenceRule,_tmpRecurrenceId,_tmpReminderMinutes,_tmpCategory,_tmpPriority,_tmpStatus,_tmpTransparency,_tmpCreatedAt,_tmpUpdatedAt,_tmpCalendarId,_tmpExternalId,_tmpLunarDate,_tmpIsLunarEvent);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<String>> getAllCategories() {
    final String _sql = "SELECT DISTINCT category FROM events WHERE category IS NOT NULL ORDER BY category ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"events"}, new Callable<List<String>>() {
      @Override
      @NonNull
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final String _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getString(0);
            }
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getEventsWithReminders(final LocalDateTime currentTime,
      final Continuation<? super List<Event>> $completion) {
    final String _sql = "SELECT * FROM events WHERE reminderMinutes IS NOT NULL AND startTime > ? ORDER BY startTime ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __converters.fromLocalDateTime(currentTime);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Event>>() {
      @Override
      @NonNull
      public List<Event> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfAllDay = CursorUtil.getColumnIndexOrThrow(_cursor, "allDay");
          final int _cursorIndexOfRecurrenceRule = CursorUtil.getColumnIndexOrThrow(_cursor, "recurrenceRule");
          final int _cursorIndexOfRecurrenceId = CursorUtil.getColumnIndexOrThrow(_cursor, "recurrenceId");
          final int _cursorIndexOfReminderMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderMinutes");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfTransparency = CursorUtil.getColumnIndexOrThrow(_cursor, "transparency");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfCalendarId = CursorUtil.getColumnIndexOrThrow(_cursor, "calendarId");
          final int _cursorIndexOfExternalId = CursorUtil.getColumnIndexOrThrow(_cursor, "externalId");
          final int _cursorIndexOfLunarDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lunarDate");
          final int _cursorIndexOfIsLunarEvent = CursorUtil.getColumnIndexOrThrow(_cursor, "isLunarEvent");
          final List<Event> _result = new ArrayList<Event>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Event _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final LocalDateTime _tmpStartTime;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfStartTime);
            }
            _tmpStartTime = __converters.toLocalDateTime(_tmp_1);
            final LocalDateTime _tmpEndTime;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfEndTime);
            }
            _tmpEndTime = __converters.toLocalDateTime(_tmp_2);
            final boolean _tmpAllDay;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfAllDay);
            _tmpAllDay = _tmp_3 != 0;
            final String _tmpRecurrenceRule;
            if (_cursor.isNull(_cursorIndexOfRecurrenceRule)) {
              _tmpRecurrenceRule = null;
            } else {
              _tmpRecurrenceRule = _cursor.getString(_cursorIndexOfRecurrenceRule);
            }
            final Long _tmpRecurrenceId;
            if (_cursor.isNull(_cursorIndexOfRecurrenceId)) {
              _tmpRecurrenceId = null;
            } else {
              _tmpRecurrenceId = _cursor.getLong(_cursorIndexOfRecurrenceId);
            }
            final Integer _tmpReminderMinutes;
            if (_cursor.isNull(_cursorIndexOfReminderMinutes)) {
              _tmpReminderMinutes = null;
            } else {
              _tmpReminderMinutes = _cursor.getInt(_cursorIndexOfReminderMinutes);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final int _tmpPriority;
            _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
            final EventStatus _tmpStatus;
            _tmpStatus = __EventStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final Transparency _tmpTransparency;
            _tmpTransparency = __Transparency_stringToEnum(_cursor.getString(_cursorIndexOfTransparency));
            final LocalDateTime _tmpCreatedAt;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __converters.toLocalDateTime(_tmp_4);
            final LocalDateTime _tmpUpdatedAt;
            final String _tmp_5;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_5 = null;
            } else {
              _tmp_5 = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __converters.toLocalDateTime(_tmp_5);
            final String _tmpCalendarId;
            if (_cursor.isNull(_cursorIndexOfCalendarId)) {
              _tmpCalendarId = null;
            } else {
              _tmpCalendarId = _cursor.getString(_cursorIndexOfCalendarId);
            }
            final String _tmpExternalId;
            if (_cursor.isNull(_cursorIndexOfExternalId)) {
              _tmpExternalId = null;
            } else {
              _tmpExternalId = _cursor.getString(_cursorIndexOfExternalId);
            }
            final String _tmpLunarDate;
            if (_cursor.isNull(_cursorIndexOfLunarDate)) {
              _tmpLunarDate = null;
            } else {
              _tmpLunarDate = _cursor.getString(_cursorIndexOfLunarDate);
            }
            final boolean _tmpIsLunarEvent;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsLunarEvent);
            _tmpIsLunarEvent = _tmp_6 != 0;
            _item = new Event(_tmpId,_tmpTitle,_tmpDescription,_tmpLocation,_tmpStartTime,_tmpEndTime,_tmpAllDay,_tmpRecurrenceRule,_tmpRecurrenceId,_tmpReminderMinutes,_tmpCategory,_tmpPriority,_tmpStatus,_tmpTransparency,_tmpCreatedAt,_tmpUpdatedAt,_tmpCalendarId,_tmpExternalId,_tmpLunarDate,_tmpIsLunarEvent);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __EventStatus_enumToString(@NonNull final EventStatus _value) {
    switch (_value) {
      case CONFIRMED: return "CONFIRMED";
      case TENTATIVE: return "TENTATIVE";
      case CANCELLED: return "CANCELLED";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private String __Transparency_enumToString(@NonNull final Transparency _value) {
    switch (_value) {
      case OPAQUE: return "OPAQUE";
      case TRANSPARENT: return "TRANSPARENT";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private EventStatus __EventStatus_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "CONFIRMED": return EventStatus.CONFIRMED;
      case "TENTATIVE": return EventStatus.TENTATIVE;
      case "CANCELLED": return EventStatus.CANCELLED;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private Transparency __Transparency_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "OPAQUE": return Transparency.OPAQUE;
      case "TRANSPARENT": return Transparency.TRANSPARENT;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
