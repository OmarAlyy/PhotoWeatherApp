package com.omaraly.photoweatherapp.Utilities;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.omaraly.photoweatherapp.API.APIModel;
import com.omaraly.photoweatherapp.Activities.MainActivity;
import com.omaraly.photoweatherapp.BuildConfig;
import com.omaraly.photoweatherapp.Fragments.ActionBottomDialogFragment;
import com.omaraly.photoweatherapp.R;


public abstract class Dialogs {


    public static void showAlertPermission(MainActivity activity) {

        AlertDialog.Builder builder = new MaterialAlertDialogBuilder(activity, R.style.AlertDialogTheme)

                .setTitle("request a permission")
                .setMessage("We will fetch the weather from your current location and we will need permission to access your location, camera, and gallery")
                .setPositiveButton("GOT IT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        activity.mainViewModel.requestPermissions();

                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        builder.show();

    }


    public static void showBottomSheet(AppCompatActivity activity) {
        ActionBottomDialogFragment addPhotoBottomDialogFragment =
                ActionBottomDialogFragment.newInstance();
        addPhotoBottomDialogFragment.show(activity.getSupportFragmentManager(), "");
    }


    public static void showSnackbarToGoSettings(View view, Activity activity) {
        Snackbar.make(
                view,
                "permission denied, We need location, camera and storage permission ",
                Snackbar.LENGTH_INDEFINITE)
                .setAction("settings", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Build intent that displays the App settings screen.
                        Intent intent = new Intent();
                        intent.setAction(
                                Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package",
                                BuildConfig.APPLICATION_ID, null);
                        intent.setData(uri);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        activity.startActivity(intent);
                    }
                })
                .show();
    }

    public static void showSnackbarText(View view, String message) {


        if (view != null) {
            Snackbar snackbar = Snackbar
                    .make(view, message, Snackbar.LENGTH_LONG);
            View snackbarView = snackbar.getView();
            int snackbarTextId = com.google.android.material.R.id.snackbar_text;
            TextView textView = (TextView) snackbarView.findViewById(snackbarTextId);
            textView.setTextColor(Color.parseColor("#ffffff"));
            snackbarView.setBackgroundColor(Color.BLACK);
            snackbar.show();
        }
    }

    public static void showSnackbarRefresh(View view, String message, final APIModel.RefreshListener listener) {


        if (view != null) {
            Snackbar snackbar = Snackbar
                    .make(view, message, Snackbar.LENGTH_LONG);
            View snackbarView = snackbar.getView();
            int snackbarTextId = com.google.android.material.R.id.snackbar_text;
            TextView textView = (TextView) snackbarView.findViewById(snackbarTextId);
            textView.setTextColor(Color.parseColor("#ffffff"));
            snackbarView.setBackgroundColor(Color.BLACK);
            snackbar.setAction("RETRY", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onRefresh();
                }
            });
            snackbar.setActionTextColor(Color.parseColor("#424fdd"));
            snackbar.show();
        }
    }


}
