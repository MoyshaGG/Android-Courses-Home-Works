package com.mysliukserhii.p110.viewmodel

import com.mysliukserhii.p110.api.WeatherService
import com.mysliukserhii.p110.model.WeatherDailyDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WeatherViewModel : ViewModel() {

    private val weatherService = initServer()

    private val _weatherLiveData = MutableLiveData<WeatherDailyDto>()
    val weatherLiveData: LiveData<WeatherDailyDto> = _weatherLiveData

    init {
        getWeather()
    }

    private fun getWeather() {
        weatherService
            .getDaily(49.4310484f, 31.9091472f, 24)
            .enqueue(object : Callback<WeatherDailyDto> {

                override fun onResponse(
                    call: Call<WeatherDailyDto>,
                    response: Response<WeatherDailyDto>
                ) {
                    _weatherLiveData.value = response.body()
                }

                override fun onFailure(call: Call<WeatherDailyDto>, t: Throwable) {
                }
            })
    }

    private fun initServer() = Retrofit.Builder()
        .baseUrl("https://weatherbit-v1-mashape.p.rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(WeatherService::class.java)
}