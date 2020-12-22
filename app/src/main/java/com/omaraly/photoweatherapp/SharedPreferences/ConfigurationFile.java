package com.omaraly.photoweatherapp.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import java.util.Locale;


public class ConfigurationFile {
    private static final String LANGUAGE_KEY = "languageKey";

    private static SharedPreferences configFile;


    public static void setCurrentLanguage(Context context, String language) {


        configFile = context.getSharedPreferences("configFile", Context.MODE_PRIVATE);

        if (language.equals(""))
            language = Locale.getDefault().getLanguage();

        try {

            Locale locale = new Locale(language);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            context.getResources().updateConfiguration(config, null);

        } catch (NullPointerException a) {
            a.printStackTrace();
        } catch (RuntimeException a) {
            a.printStackTrace();
        }

        SharedPreferences.Editor editor = configFile.edit();
        editor.putString(LANGUAGE_KEY, language);
        editor.apply();
    }


}
