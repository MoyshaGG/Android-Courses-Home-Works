package com.mysliukserhii.p110

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mysliukserhii.p110.adapter.WeatherAdapter
import com.mysliukserhii.p110.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {
     lateinit var weatherViewModel: WeatherViewModel
    lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val icon = findViewById<ImageView>(R.id.big_iconWeather)
        val description = findViewById<TextView>(R.id.description)
        recyclerView = findViewById<RecyclerView>(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        weatherViewModel= ViewModelProvider(this).get(WeatherViewModel::class.java)
        weatherViewModel.weatherLiveData.observe(this)
        {
            description.text = it.cityName
            val degrees = findViewById<TextView>(R.id.degrees)
            degrees.text = it.data?.get(0)?.temp.toString() + "°"
            recyclerView.adapter = WeatherAdapter(it, this)
            icon.setImageResource(R.drawable.ic_partly_big)
        }
        weatherViewModel.getWeather()

    }
}