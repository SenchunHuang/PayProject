package com.example.myapplication.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {

    const val BASE_URL = "https://api.apilayer.com/exchangerates_data/"
    const val KEY_API = "Gw3HjVzOILAUGICd6ecm0gpgtkVUUeTf"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

}
