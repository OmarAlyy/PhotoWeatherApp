package com.omaraly.photoweatherapp;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.omaraly.photoweatherapp.Activities.MainActivity;
import com.omaraly.photoweatherapp.Activities.ShowCardActivity;
import com.omaraly.photoweatherapp.DataBase.PostsRepository;
import com.omaraly.photoweatherapp.Models.Post;
import com.omaraly.photoweatherapp.Utilities.Dialogs;
import com.omaraly.photoweatherapp.Utilities.GPSTracker;
import com.omaraly.photoweatherapp.Utilities.GlobalVariables;
import com.omaraly.photoweatherapp.Utilities.IntentClass;

import java.util.List;

import static com.omaraly.photoweatherapp.Utilities.GlobalVariables.REQUEST_PERMISSIONS_REQUEST_CODE;

public class MainViewModel extends AndroidViewModel {

    public PostsRepository postsRepository;
    public double lat = 0;
    public double lon = 0;
    public boolean isGetPermissions = false;
    public boolean gpsOpen = false;
    public MainActivity activity;
    Application application;
    private LiveData<List<Post>> allPosts;

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        postsRepository = new PostsRepository(application);
        allPosts = postsRepository.getPostsListLiveData();

    }


    public void deleteOnePost(Post post) {
        postsRepository.delete(post);
    }

    public void addImageClick() {

        if (isGetPermissions && gpsOpen)
            Dialogs.showBottomSheet(activity);
        else
            Dialogs.showAlertPermission(activity);
    }

    public LiveData<List<Post>> getAllPosts() {
        return allPosts;
    }


    public void isNeedPermission() {
        boolean permissionAccessFineLocationApproved =
                ActivityCompat.checkSelfPermission(
                        activity, Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED;

        boolean cameraPermissionApproved =
                ActivityCompat.checkSelfPermission(
                        activity, Manifest.permission.CAMERA)
                        == PackageManager.PERMISSION_GRANTED;

        boolean storgePermissionApproved =
                ActivityCompat.checkSelfPermission(
                        activity, Manifest.permission.READ_EXTERNAL_STORAGE)
                        == PackageManager.PERMISSION_GRANTED;
        boolean storge2PermissionApproved =
                ActivityCompat.checkSelfPermission(
                        activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        == PackageManager.PERMISSION_GRANTED;

        isGetPermissions =
                permissionAccessFineLocationApproved && cameraPermissionApproved && storgePermissionApproved && storge2PermissionApproved;

    }


    public void openShowCardActivity(String path) {
        Bundle bundle = new Bundle();
        bundle.putString(GlobalVariables.IMAGE_PATH, path);
        bundle.putDouble(GlobalVariables.LATITUDE, lat);
        bundle.putDouble(GlobalVariables.LONGITUDE, lon);
        IntentClass.goToActivity(activity, ShowCardActivity.class, bundle);

    }


    public void requestPermissions() {

        isNeedPermission();
        // Provide an additional rationale to the user. This would happen if the user denied the
        // request previously, but didn't check the "Don't ask again" checkbox.
        if (!isGetPermissions) {
            ActivityCompat.requestPermissions(activity,
                    new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.CAMERA,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE

                    },
                    REQUEST_PERMISSIONS_REQUEST_CODE);

        } else {
            if (gpsOpen)
                Dialogs.showBottomSheet(activity);
            else
                getLoaction();

        }
    }


    public void getLoaction() {
        GPSTracker gpsTracker = new GPSTracker(activity);
        gpsOpen = gpsTracker.isGPSEnabled;
        if (!gpsOpen) {
            gpsTracker.showSettingsAlert();
        } else {

            lat = gpsTracker.getLatitude();
            lon = gpsTracker.getLongitude();
        }
    }


}
