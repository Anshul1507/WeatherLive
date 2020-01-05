package com.example.weatherlive.data.network

import androidx.lifecycle.LiveData
import com.example.weatherlive.data.db.entity.Current
import com.example.weatherlive.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {

    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )
}