package com.mysliukserhii.p110

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.mysliukserhii.p110.adapter.WeatherAdapter
import com.mysliukserhii.p110.model.WeatherDailyDto
import com.mysliukserhii.p110.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var weatherViewModel: WeatherViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val icon = findViewById<ImageView>(R.id.big_iconWeather)
        val description = findViewById<TextView>(R.id.description)

        weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        weatherViewModel.weatherLiveData.observe(this)
        {
            setWeatherDetail(description, it, icon)
        }

        recyclerView = findViewById(R.id.recycleView)
        recyclerView.adapter = WeatherAdapter(weatherViewModel.weatherLiveData.value!!, this)
    }

    private fun setWeatherDetail(
        description: TextView,
        it: WeatherDailyDto,
        icon: ImageView
    ) {
        description.text = it.cityName
        val degrees = findViewById<TextView>(R.id.degrees)
        degrees.text = it.data[0].temp.toString() + "°"
        icon.setImageResource(R.drawable.ic_partly_big)
    }
}