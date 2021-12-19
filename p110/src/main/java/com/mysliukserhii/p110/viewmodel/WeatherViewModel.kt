package com.mysliukserhii.p110.viewmodel

import com.mysliukserhii.p110.api.WeatherService
import com.mysliukserhii.p110.model.DailyDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class WeatherViewModel(application: Application):AndroidViewModel(application) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://weatherbit-v1-mashape.p.rapidapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            private val _weatherLiveData = MutableLiveData<DailyDto>()
            val weatherService = retrofit.create(WeatherService::class.java)
            val weatherLiveData : LiveData<DailyDto> = _weatherLiveData
            fun getWeather()
            {
                weatherService.getDaily(49.4310484f,31.9091472f, 24).enqueue(object : Callback<DailyDto> {
                    override fun onResponse(call: Call<DailyDto>, response: Response<DailyDto>) {
                        _weatherLiveData.value = response.body()
                    }
                    override fun onFailure(call: Call<DailyDto>, t: Throwable) {
                    }
                })
            }
}