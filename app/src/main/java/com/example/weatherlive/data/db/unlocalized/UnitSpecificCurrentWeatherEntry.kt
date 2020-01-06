package com.example.weatherlive.data.db.unlocalized

interface UnitSpecificCurrentWeatherEntry {
    val temperature: Double
    val weatherDesc: List<String>
    val weatherIcon: List<String>
    val windSpeed: Double
    val windDirection: String
    val precipitationVolume: Double
    val feelsLikeTemperature: Double
    val visibilityDistance: Double
}