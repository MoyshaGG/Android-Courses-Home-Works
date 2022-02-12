package com.mysliukserhii.p1112

import com.mysliukserhii.p1112.model.Quakes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface QuakesAPI {
    @GET("quake?MMI=3")
    fun getQuakes(): Call<Quakes>
}