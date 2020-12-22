package com.omaraly.photoweatherapp.Utilities;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;

import androidx.core.content.FileProvider;

import com.omaraly.photoweatherapp.BuildConfig;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;


public class Utilities {


    public static void downLoadImage(ImageView imageView, String url) {
        if (!url.equals("")) {
            try {
                Picasso.get()
                        .load(url)
                        .into(imageView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void shareImage(Activity activity, String path) {


        try {
            Uri uri = FileProvider.getUriForFile(Objects.requireNonNull(activity),
                    BuildConfig.APPLICATION_ID + ".provider", new File(new URI("file://" + path)));
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("image/jpeg");
            share.putExtra(Intent.EXTRA_STREAM, uri);
            activity.startActivity(Intent.createChooser(share, "Share Image"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }





    }

    public static void downLoadImageLocal(ImageView imageView, String url) {
        if (!url.equals("")) {
            try {
                Picasso.get().load("file://" + url).into(imageView);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }


}
