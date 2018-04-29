package com.example.csotelo.ashstrolling;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.csotelo.ashstrolling.core.data.PokemonDBPopulator;

public class AshstrollingApplication extends Application {

    public static final String KEY_IS_DB_POPULATED = "DB_IS_POPULATED";
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initContext();
        intiDB();
    }

    private void initContext() {
        context = this;
    }

    private void intiDB() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (!preferences.getBoolean(KEY_IS_DB_POPULATED, false)) {
            PokemonDBPopulator.with(this).populateDB();
            preferences.edit().putBoolean(KEY_IS_DB_POPULATED, true).apply();
        }
    }
}

