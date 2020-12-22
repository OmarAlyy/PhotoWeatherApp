package com.omaraly.photoweatherapp.Activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.omaraly.photoweatherapp.Adapters.PostsAdapter;
import com.omaraly.photoweatherapp.Fragments.ActionBottomDialogFragment;
import com.omaraly.photoweatherapp.MainViewModel;
import com.omaraly.photoweatherapp.R;
import com.omaraly.photoweatherapp.Utilities.Camera;
import com.omaraly.photoweatherapp.Utilities.Dialogs;
import com.omaraly.photoweatherapp.Utilities.GPSTracker;
import com.omaraly.photoweatherapp.Utilities.GlobalVariables;
import com.omaraly.photoweatherapp.databinding.ActivityMainBinding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import static com.omaraly.photoweatherapp.Utilities.Camera.CAMERA_REQUEST;
import static com.omaraly.photoweatherapp.Utilities.Camera.GALLERY_REQUEST;
import static com.omaraly.photoweatherapp.Utilities.GlobalVariables.REQUEST_PERMISSIONS_REQUEST_CODE;

public class MainActivity extends AppCompatActivity implements ActionBottomDialogFragment.ItemClickListener {


    public MainViewModel mainViewModel;
    public GPSTracker gpsTracker;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        binding = DataBindingUtil.setContentView (this, R.layout.activity_main);

        mainViewModel = ViewModelProviders.of (this).get (MainViewModel.class);
        mainViewModel.activity = this;
        binding.setViewModel (mainViewModel);

        mainViewModel.getLoaction ();

        mainViewModel.getAllPosts ().observe (this, posts -> {

            if (posts.size () > 0) {
                binding.linNoData.setVisibility (View.GONE);
                binding.list.setVisibility (View.VISIBLE);
                PostsAdapter adapter = new PostsAdapter (this, posts);
                binding.list.setAdapter (adapter);
            } else {
                binding.linNoData.setVisibility (View.VISIBLE);
                binding.list.setVisibility (View.GONE);
            }

        });
    }


    @Override
    protected void onResume() {
        mainViewModel.isNeedPermission ();

        gpsTracker = new GPSTracker (this);
        mainViewModel.gpsOpen = gpsTracker.isGPSEnabled;

        if (gpsTracker.isGPSEnabled) {
            mainViewModel.lat = gpsTracker.getLatitude ();
            mainViewModel.lon = gpsTracker.getLongitude ();
        }
        super.onResume ();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
            if (grantResults.length <= 0) {
                // If user interaction was interrupted, the permission request is cancelled and you
                // receive empty arrays.

            } else if ((grantResults[0] == PackageManager.PERMISSION_GRANTED) &&
                    (grantResults[1] == PackageManager.PERMISSION_GRANTED)
            ) {
                // Permission was granted.

                if (mainViewModel.gpsOpen)
                    Dialogs.showBottomSheet (this);
                else
                    mainViewModel.getLoaction ();
            } else {

                Dialogs.showSnackbarToGoSettings (binding.addImage, this);
            }
        }
    }


    @Override
    public void onItemClick(int type) {
        if (type == GlobalVariables.CAMERA) {
            Camera.captureImage (this);
        } else if (type == GlobalVariables.GALLERY) {
            Intent i = new Intent (Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult (i, GALLERY_REQUEST);
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult (requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {


            try {
                String path = Camera.getPath (this, Camera.fileUri);
                mainViewModel.openShowCardActivity (path);
            } catch (Exception e) {
                e.printStackTrace ();
            }

        } else if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK) {

            try {
                Uri selectedImage = data.getData ();
                String path = Camera.getPath (this, selectedImage);
                mainViewModel.openShowCardActivity (path);
            } catch (Exception e) {
                e.printStackTrace ();
            }

        }
    }

}