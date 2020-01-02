package com.example.weatherlive.data.db.unlocalized

interface UnitSpecificCurrentWeatherEntry {
    val temperature: Double
    val weatherDesc: String
    val weaatherIcon: String
    val windSpeed: Double
    val windDirection: String
    val precipitationVoulme: Double
    val feelsLikeTemperature: Double
    val visibilityDistance: Double
}