package com.example.csotelo.ashstrolling

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.support.multidex.MultiDexApplication

import com.example.csotelo.ashstrolling.core.data.PokemonDBPopulator

class AshstrollingApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        initContext()
        intiDB()
    }

    private fun initContext() {
        context = this
    }

    private fun intiDB() {
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        if (!preferences.getBoolean(KEY_IS_DB_POPULATED, false)) {
//            PokemonDBPopulator.with(this).populateDB()
            preferences.edit().putBoolean(KEY_IS_DB_POPULATED, true).apply()
        }
    }

    companion object {

        val KEY_IS_DB_POPULATED = "DB_IS_POPULATED"
        var context: Context? = null
            private set
    }
}

