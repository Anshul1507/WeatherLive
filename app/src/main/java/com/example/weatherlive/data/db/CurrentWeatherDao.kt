package com.example.weatherlive.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherlive.data.db.entity.CURRENT_WEATHER_ID
import com.example.weatherlive.data.db.entity.Current
import com.example.weatherlive.data.db.unlocalized.MetricCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {
    //upsert = update + insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: Current)

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    //same if we have different temp value like F/C
}