package com.example.myapplication.network


import com.example.myapplication.model.ConvertResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/*
* 汇率接口
*/
interface RateService {

    @Headers("apikey:${ServiceCreator.KEY_API}")
    @GET("convert?to=USD&from=CNY")
    fun getUSDAmount(@Query("amount") amount: Double): Call<ConvertResponse>

}