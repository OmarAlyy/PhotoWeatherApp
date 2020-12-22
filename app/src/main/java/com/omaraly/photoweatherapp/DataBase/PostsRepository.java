package com.omaraly.photoweatherapp.DataBase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.omaraly.photoweatherapp.Models.Post;

import java.util.List;

public class PostsRepository {
    private PostDao postDao;
    private LiveData<List<Post>> postsListLiveData;

    public PostsRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        postDao = database.postDao();
        postsListLiveData = postDao.getAllAds();
    }


    public LiveData<List<Post>> getPostsListLiveData() {
        return postsListLiveData;
    }

    public void insert(Post adInfo) {

        AsyncTask.execute(() -> postDao.insert(adInfo));

    }


    public void delete(Post adInfo) {
        try {
            if (adInfo != null) {
                AsyncTask.execute(() -> postDao.delete(adInfo));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
