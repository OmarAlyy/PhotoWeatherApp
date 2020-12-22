package com.omaraly.photoweatherapp.DataBase;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.omaraly.photoweatherapp.Models.Post;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PostDao_Impl implements PostDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Post> __insertionAdapterOfPost;

  private final EntityDeletionOrUpdateAdapter<Post> __deletionAdapterOfPost;

  private final EntityDeletionOrUpdateAdapter<Post> __updateAdapterOfPost;

  public PostDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPost = new EntityInsertionAdapter<Post>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Post` (`id`,`task`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Post value) {
        stmt.bindLong(1, value.getId());
        if (value.getPath() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPath());
        }
      }
    };
    this.__deletionAdapterOfPost = new EntityDeletionOrUpdateAdapter<Post>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Post` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Post value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfPost = new EntityDeletionOrUpdateAdapter<Post>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Post` SET `id` = ?,`task` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Post value) {
        stmt.bindLong(1, value.getId());
        if (value.getPath() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPath());
        }
        stmt.bindLong(3, value.getId());
      }
    };
  }

  @Override
  public void insert(final Post task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPost.insert(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Post task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPost.handle(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Post task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPost.handle(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Post> getAll() {
    final String _sql = "SELECT * FROM Post";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPath = CursorUtil.getColumnIndexOrThrow(_cursor, "task");
      final List<Post> _result = new ArrayList<Post>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Post _item;
        _item = new Post();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpPath;
        _tmpPath = _cursor.getString(_cursorIndexOfPath);
        _item.setPath(_tmpPath);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<Post>> getAllAds() {
    final String _sql = "SELECT * FROM Post";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Post"}, false, new Callable<List<Post>>() {
      @Override
      public List<Post> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPath = CursorUtil.getColumnIndexOrThrow(_cursor, "task");
          final List<Post> _result = new ArrayList<Post>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Post _item;
            _item = new Post();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpPath;
            _tmpPath = _cursor.getString(_cursorIndexOfPath);
            _item.setPath(_tmpPath);
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
}
