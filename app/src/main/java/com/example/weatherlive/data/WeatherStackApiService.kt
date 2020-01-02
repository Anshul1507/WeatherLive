package com.example.weatherlive.data

import com.example.weatherlive.data.db.network.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "ecf11578b8e7f85950150a76046a65a9"
const val BASE_URL = "http://api.weatherstack.com/";
//http://api.weatherstack.com/current?access_key=ecf11578b8e7f85950150a76046a65a9&query=New%20Delhi&lang=en

interface WeatherStackApiService{

    @GET("current")
    fun getCurrentWeather(
        @Query("query") location:String,
        @Query("lang") languageCode:String = "en"

    ): Deferred<CurrentWeatherResponse> //using deferred for async waiting for response from api

    companion object{
        operator fun invoke(): WeatherStackApiService{
            val requestInterceptor = Interceptor{chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherStackApiService::class.java)
        }
    }
}