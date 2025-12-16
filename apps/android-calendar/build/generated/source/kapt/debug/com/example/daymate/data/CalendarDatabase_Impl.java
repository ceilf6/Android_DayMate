package com.example.daymate.data;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CalendarDatabase_Impl extends CalendarDatabase {
  private volatile EventDao _eventDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `events` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT NOT NULL, `description` TEXT, `location` TEXT, `startTime` TEXT NOT NULL, `endTime` TEXT NOT NULL, `allDay` INTEGER NOT NULL, `recurrenceRule` TEXT, `recurrenceId` INTEGER, `reminderMinutes` INTEGER, `category` TEXT, `priority` INTEGER NOT NULL, `status` TEXT NOT NULL, `transparency` TEXT NOT NULL, `createdAt` TEXT NOT NULL, `updatedAt` TEXT NOT NULL, `calendarId` TEXT, `externalId` TEXT, `lunarDate` TEXT, `isLunarEvent` INTEGER NOT NULL)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_events_startTime` ON `events` (`startTime`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_events_endTime` ON `events` (`endTime`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_events_category` ON `events` (`category`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_events_reminderMinutes` ON `events` (`reminderMinutes`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '380bad934c645a718739af1b20181954')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `events`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsEvents = new HashMap<String, TableInfo.Column>(20);
        _columnsEvents.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("location", new TableInfo.Column("location", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("startTime", new TableInfo.Column("startTime", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("endTime", new TableInfo.Column("endTime", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("allDay", new TableInfo.Column("allDay", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("recurrenceRule", new TableInfo.Column("recurrenceRule", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("recurrenceId", new TableInfo.Column("recurrenceId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("reminderMinutes", new TableInfo.Column("reminderMinutes", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("category", new TableInfo.Column("category", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("priority", new TableInfo.Column("priority", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("transparency", new TableInfo.Column("transparency", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("createdAt", new TableInfo.Column("createdAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("updatedAt", new TableInfo.Column("updatedAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("calendarId", new TableInfo.Column("calendarId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("externalId", new TableInfo.Column("externalId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("lunarDate", new TableInfo.Column("lunarDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("isLunarEvent", new TableInfo.Column("isLunarEvent", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEvents = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEvents = new HashSet<TableInfo.Index>(4);
        _indicesEvents.add(new TableInfo.Index("index_events_startTime", false, Arrays.asList("startTime"), Arrays.asList("ASC")));
        _indicesEvents.add(new TableInfo.Index("index_events_endTime", false, Arrays.asList("endTime"), Arrays.asList("ASC")));
        _indicesEvents.add(new TableInfo.Index("index_events_category", false, Arrays.asList("category"), Arrays.asList("ASC")));
        _indicesEvents.add(new TableInfo.Index("index_events_reminderMinutes", false, Arrays.asList("reminderMinutes"), Arrays.asList("ASC")));
        final TableInfo _infoEvents = new TableInfo("events", _columnsEvents, _foreignKeysEvents, _indicesEvents);
        final TableInfo _existingEvents = TableInfo.read(db, "events");
        if (!_infoEvents.equals(_existingEvents)) {
          return new RoomOpenHelper.ValidationResult(false, "events(com.example.daymate.data.Event).\n"
                  + " Expected:\n" + _infoEvents + "\n"
                  + " Found:\n" + _existingEvents);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "380bad934c645a718739af1b20181954", "43edd858e54a1120cb4099da83329aaf");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "events");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `events`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(EventDao.class, EventDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public EventDao eventDao() {
    if (_eventDao != null) {
      return _eventDao;
    } else {
      synchronized(this) {
        if(_eventDao == null) {
          _eventDao = new EventDao_Impl(this);
        }
        return _eventDao;
      }
    }
  }
}
