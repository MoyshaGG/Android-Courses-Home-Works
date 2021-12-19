package com.mysliukserhii.p110.api

import com.mysliukserhii.p110.model.DailyDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface WeatherService {
    @Headers("X-RapidAPI-Key: 2c8611d64emsh5d4b88db38edaadp1f5388jsna3ddf89164bc")
    @GET("forecast/hourly")
    fun getDaily(@Query("lat")lat: Float,
                 @Query("lon") lon: Float,
                 @Query("hours")hours:Int): Call<DailyDto>
}