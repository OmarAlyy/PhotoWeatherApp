package com.omaraly.photoweatherapp.DataBase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.omaraly.photoweatherapp.Models.Post;

@Database(entities = {Post.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {

            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "posts-db").fallbackToDestructiveMigration()
                    .build();
        }
        return instance;

    }

    public abstract PostDao postDao();

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private PostDao adsDao;

        private PopulateDbAsyncTask(AppDatabase db) {
            adsDao = db.postDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }
    }

}
