package com.neil.example.weatherdemo

import android.app.Application
import android.util.Log
import com.neil.example.weatherdemo.ui.UIEventHandler
import com.neil.example.weatherdemo.services.SearchHistoryManager

class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SearchHistoryManager.init(this)
        UIEventHandler.post({
            Log.d("test", "test")
        })

    }
}