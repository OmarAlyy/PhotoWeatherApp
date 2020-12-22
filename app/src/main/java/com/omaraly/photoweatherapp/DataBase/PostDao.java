package com.omaraly.photoweatherapp.DataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.omaraly.photoweatherapp.Models.Post;

import java.util.List;


@Dao
public interface PostDao {

    @Query("SELECT * FROM Post")
    List<Post> getAll();

    @Insert
    void insert(Post task);

    @Delete
    void delete(Post task);

    @Update
    void update(Post task);

    @Query("SELECT * FROM Post")
    LiveData<List<Post>> getAllAds();


}
