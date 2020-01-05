package com.example.weatherlive.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import internal.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.sql.NClob

class ConnectivityInterceptorImpl(context: Context) : ConnectivityInterceptor {

    private val appcontext = context.applicationContext


    override fun intercept(chain: Interceptor.Chain): Response {
        if(!isOnline()){
            //when offline
            throw NoConnectivityException()
        }

        return chain.proceed(chain.request())
    }

    private fun isOnline(): Boolean {
        val connectivityManager = appcontext.getSystemService(Context.CONNECTIVITY_SERVICE)
        as ConnectivityManager

        var result = false
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
            result = when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }else{
            //lower versions of API < 28 (Mostly Deprecated)
            connectivityManager.run {
                connectivityManager.activeNetworkInfo?.run {
                    result = when(type){
                        ConnectivityManager.TYPE_WIFI -> true
                        ConnectivityManager.TYPE_MOBILE -> true
                        ConnectivityManager.TYPE_ETHERNET -> true
                        else -> false
                    }
                }
            }
        }
        return result
    }
}