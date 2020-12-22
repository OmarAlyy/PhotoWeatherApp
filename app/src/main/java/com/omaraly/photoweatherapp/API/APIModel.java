package com.omaraly.photoweatherapp.API;


import android.app.Activity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.MySSLSocketFactory;
import com.loopj.android.http.TextHttpResponseHandler;
import com.omaraly.photoweatherapp.R;
import com.omaraly.photoweatherapp.Utilities.Dialogs;

import java.security.KeyStore;


public class APIModel {
    public final static String BASE_URL = "http://api.openweathermap.org/data/2.5/weather/";
    public final static String APP_ID = "d79f496b52da2403c1e1ada52e5ca414";
    public final static String URL_IMAGE = "https://openweathermap.org/img/wn/";

    public static void handleFailure(final Activity activity, int statusCode, RefreshListener refreshListener) {


        switch (statusCode) {


            default:

                if (activity != null) {
                    if (activity.getCurrentFocus () != null)
                        Dialogs.showSnackbarRefresh (activity.getCurrentFocus (), activity.getString (R.string.no_network), refreshListener);

                }
                break;


        }
    }


    public static AsyncHttpClient getMethod(String url, TextHttpResponseHandler textHttpResponseHandler) {
        AsyncHttpClient client = new AsyncHttpClient ();
        KeyStore trustStore = null;
        try {
            trustStore = KeyStore.getInstance (KeyStore.getDefaultType ());
            trustStore.load (null, null);
            MySSLSocketFactory socketFactory = new MySSLSocketFactory (trustStore);
            socketFactory.setHostnameVerifier (MySSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            client.setSSLSocketFactory (socketFactory);
        } catch (Exception e) {
            e.printStackTrace ();
        }

        client.addHeader ("Accept", "application/json");
        client.addHeader ("User-Agent", "PostmanRuntime/7.2.0");
        client.get (BASE_URL + url, textHttpResponseHandler);

        return client;
    }


    public interface RefreshListener {
        void onRefresh();
    }


}