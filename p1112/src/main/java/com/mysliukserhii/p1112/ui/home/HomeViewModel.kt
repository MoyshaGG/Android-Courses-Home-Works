package com.mysliukserhii.p1112.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mysliukserhii.p1112.QuakesAPI
import com.mysliukserhii.p1112.model.Quakes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeViewModel : ViewModel() {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.geonet.org.nz")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val _quakesAPI = retrofit.create(QuakesAPI::class.java)
    private val _quakesLiveData = MutableLiveData<Quakes>()
    val quakesLiveData: LiveData<Quakes> = _quakesLiveData
    fun getQuakes() {
        _quakesAPI.getQuakes().enqueue(object :
            Callback<Quakes> {
            override fun onResponse(call: Call<Quakes>, response: Response<Quakes>) {
                _quakesLiveData.value = response.body()
            }

            override fun onFailure(call: Call<Quakes>, t: Throwable) {
            }
        })
    }
}