package com.weiweather.android.logic.network

import com.weiweather.android.WeiWeatherApplication
import com.weiweather.android.logic.model.DailyResponse
import com.weiweather.android.logic.model.RealTimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {
    @GET("v2.5/${WeiWeatherApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng") lng:String,@Path("lat") lat:String):
            Call<RealTimeResponse>

    @GET("v2.5/${WeiWeatherApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String,@Path("lat") lat: String):
            Call<DailyResponse>
}