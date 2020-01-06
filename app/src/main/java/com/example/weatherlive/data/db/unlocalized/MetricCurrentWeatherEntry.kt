package com.example.weatherlive.data.db.unlocalized

import androidx.room.ColumnInfo

class MetricCurrentWeatherEntry (
    @ColumnInfo(name = "temperature")
    override val temperature: Double,
    @ColumnInfo(name = "weather_descriptions")
    override val weatherDesc: List<String>,
    @ColumnInfo(name = "weather_icons")
    override val weatherIcon: List<String>,
    @ColumnInfo(name = "wind_speed")
    override val windSpeed: Double,
    @ColumnInfo(name = "wind_dir")
    override val windDirection: String,
    @ColumnInfo(name = "precip")
    override val precipitationVolume: Double,
    @ColumnInfo(name = "feelslike")
    override val feelsLikeTemperature: Double,
    @ColumnInfo(name = "visibility")
    override val visibilityDistance: Double
): UnitSpecificCurrentWeatherEntry