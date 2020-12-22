package com.omaraly.photoweatherapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.TextHttpResponseHandler;
import com.omaraly.photoweatherapp.API.APIModel;
import com.omaraly.photoweatherapp.Activities.ShowCardActivity;
import com.omaraly.photoweatherapp.DataBase.PostsRepository;
import com.omaraly.photoweatherapp.Models.Post;
import com.omaraly.photoweatherapp.Models.WeatherDataModel;
import com.omaraly.photoweatherapp.Utilities.Camera;
import com.omaraly.photoweatherapp.Utilities.Dialogs;
import com.omaraly.photoweatherapp.Utilities.GPSTracker;
import com.omaraly.photoweatherapp.Utilities.Utilities;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import cz.msebera.android.httpclient.Header;

public class ShowCardViewModel extends AndroidViewModel {

    public PostsRepository postsRepository;
    public ShowCardActivity activity;

    public ObservableField<String> temp = new ObservableField<>("");
    public ObservableField<String> text = new ObservableField<>("");
    public ObservableField<String> main = new ObservableField<>("");
    public ObservableField<String> country = new ObservableField<>("");
    public ObservableField<String> time = new ObservableField<>("");
    public ObservableField<String> lat = new ObservableField<>("");
    public ObservableField<String> lon = new ObservableField<>("");
    public ObservableBoolean isLoading = new ObservableBoolean(true);

    public ShowCardViewModel(@NonNull Application application) {
        super(application);
        postsRepository = new PostsRepository(application);

    }


    public void onTexttChanged(CharSequence s, int start, int before, int count) {
        text.set(s.toString());

    }


    public void getData() {

        GPSTracker gpsTracker = new GPSTracker(activity);

        APIModel.getMethod("?lat=" + gpsTracker.getLatitude() + "&lon=" + gpsTracker.getLongitude() + "&appid=" + APIModel.APP_ID + "&units=metric", new TextHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

                Dialogs.showSnackbarRefresh(activity.binding.card, activity.getString(R.string.no_network), new APIModel.RefreshListener() {
                    @Override
                    public void onRefresh() {
                        getData();
                    }
                });


            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Type dataType = new TypeToken<WeatherDataModel>() {
                }.getType();
                WeatherDataModel data = new Gson().fromJson(responseString, dataType);
                temp.set(data.main.temp + "");
                main.set(data.weather.get(0).main);
                String icon = APIModel.URL_IMAGE + data.weather.get(0).icon + "@2x.png";
                Utilities.downLoadImage(activity.binding.iconStatus, icon);
                String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
                time.set(currentTime);
                country.set(data.sys.country + " , " + data.name);
                isLoading.set(false);
            }

            @Override
            public void onFinish() {
                super.onFinish();

            }
        });

    }


    public void back() {
        activity.finish();
    }

    public void save() {

        Long tsLong = System.currentTimeMillis() / 1000;
        String itme_stamp = tsLong.toString();
        try {
            String imagePath = Camera.saveImage(activity, Camera.getBitmapFromView(activity.binding.card), itme_stamp);

            Post post = new Post();
            post.setPath(imagePath);
            postsRepository.insert(post);
            activity.finish();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
