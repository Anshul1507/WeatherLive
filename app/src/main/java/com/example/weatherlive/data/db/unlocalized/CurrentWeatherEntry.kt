package com.example.weatherlive.data.db.unlocalized

import androidx.room.ColumnInfo

class CurrentWeatherEntry (
    @ColumnInfo(name = "temperature")
    override val temperature: Double,
    @ColumnInfo(name = "weather_descriptions")
    override val weatherDesc: String,
    @ColumnInfo(name = "weather_icons")
    override val weaatherIcon: String,
    @ColumnInfo(name = "wind_speed")
    override val windSpeed: Double,
    @ColumnInfo(name = "wind_dir")
    override val windDirection: String,
    @ColumnInfo(name = "precip")
    override val precipitationVoulme: Double,
    @ColumnInfo(name = "feelslike")
    override val feelsLikeTemperature: Double,
    @ColumnInfo(name = "visibility")
    override val visibilityDistance: Double
): UnitSpecificCurrentWeatherEntry