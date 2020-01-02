package com.example.weatherlive.data.db.network.response

import com.example.weatherlive.data.db.entity.Current
import com.example.weatherlive.data.db.entity.Location
import com.example.weatherlive.data.db.entity.Request


data class CurrentWeatherResponse(
    val current: Current,
    val location: Location,
    val request: Request
)