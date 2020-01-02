package com.example.weatherlive.data.response


data class CurrentWeatherResponse(
    val current: Current,
    val location: Location,
    val request: Request
)