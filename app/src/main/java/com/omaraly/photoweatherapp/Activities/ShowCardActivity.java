package com.omaraly.photoweatherapp.Activities;

import android.os.Bundle;

import com.omaraly.photoweatherapp.R;
import com.omaraly.photoweatherapp.ShowCardViewModel;
import com.omaraly.photoweatherapp.Utilities.GlobalVariables;
import com.omaraly.photoweatherapp.Utilities.Utilities;
import com.omaraly.photoweatherapp.databinding.ActivityShowCardBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class ShowCardActivity extends AppCompatActivity {

    public ActivityShowCardBinding binding;
    public ShowCardViewModel viewModel;
    String imagePath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        binding = DataBindingUtil.setContentView (this, R.layout.activity_show_card);
        viewModel = ViewModelProviders.of (this).get (ShowCardViewModel.class);
        binding.setViewModel (viewModel);
        viewModel.activity = this;
        try {
            Bundle bundle = getIntent ().getBundleExtra ("data");
            imagePath = bundle.getString (GlobalVariables.IMAGE_PATH);
            viewModel.lat.set (bundle.getDouble (GlobalVariables.LATITUDE) + "");
            viewModel.lon.set (bundle.getDouble (GlobalVariables.LONGITUDE) + "");
        } catch (Exception e) {
            e.printStackTrace ();
        }


        if (!imagePath.equals (""))
            Utilities.downLoadImageLocal (binding.image, imagePath);

        viewModel.getData ();
    }


}