package com.weiweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.widget.Toast

class WeiWeatherApplication:Application() {
    companion object{
        const val TOKEN="Czn2QsmptNWGnRmr"
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        fun String.showToast(duration:Int=Toast.LENGTH_SHORT) {
            Toast.makeText(WeiWeatherApplication.context,this,duration).show( )
        }
    }

    override fun onCreate() {
        super.onCreate()
        context=applicationContext
    }
}