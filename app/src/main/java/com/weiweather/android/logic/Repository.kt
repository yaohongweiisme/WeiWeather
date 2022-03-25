package com.weiweather.android.logic

import androidx.lifecycle.liveData
import com.weiweather.android.logic.model.Place
import com.weiweather.android.logic.network.WeiWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.RuntimeException

object Repository {
    fun searchPlaces(query:String)=liveData(Dispatchers.IO){
        val result=try{
            val placeResponse=WeiWeatherNetwork.searchPlaces(query)
            if(placeResponse.status=="ok"){
                val places=placeResponse.places
                Result.success(places)
            } else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}