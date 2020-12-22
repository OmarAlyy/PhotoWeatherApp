package com.omaraly.photoweatherapp.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.omaraly.photoweatherapp.R;
import com.omaraly.photoweatherapp.SharedPreferences.ConfigurationFile;
import com.omaraly.photoweatherapp.Utilities.IntentClass;
import com.omaraly.photoweatherapp.databinding.ActivitySplashBinding;


public class SplashActivity extends AppCompatActivity {

    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        ActivitySplashBinding activitySplashBinding = DataBindingUtil.setContentView (this, R.layout.activity_splash);
        activity = this;


        ConfigurationFile.setCurrentLanguage (activity, "en");
        new Handler ().postDelayed (new Runnable () {
            @Override
            public void run() {

                IntentClass.goToActivityAndClear (activity, MainActivity.class, null);

            }
        }, 3000);


    }


}