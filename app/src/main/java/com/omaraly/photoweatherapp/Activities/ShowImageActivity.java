package com.omaraly.photoweatherapp.Activities;

import android.os.Bundle;

import com.omaraly.photoweatherapp.R;
import com.omaraly.photoweatherapp.Utilities.GlobalVariables;
import com.omaraly.photoweatherapp.Utilities.Utilities;
import com.omaraly.photoweatherapp.databinding.ActivityShowImageBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class ShowImageActivity extends AppCompatActivity {
    ActivityShowImageBinding binding;
    String imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        binding = DataBindingUtil.setContentView (this, R.layout.activity_show_image);


        Bundle bundle = getIntent ().getBundleExtra ("data");
        imagePath = bundle.getString (GlobalVariables.IMAGE_PATH);
        Utilities.downLoadImageLocal (binding.image, imagePath);
        onClick ();

    }

    void onClick() {

        binding.back.setOnClickListener (view -> finish ());
        binding.share.setOnClickListener (view -> Utilities.shareImage (this, imagePath));
    }


}