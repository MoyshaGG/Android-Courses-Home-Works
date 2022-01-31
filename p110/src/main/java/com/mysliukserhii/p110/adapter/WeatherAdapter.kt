package com.mysliukserhii.p110.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mysliukserhii.p110.MainActivity
import com.mysliukserhii.p110.R
import com.mysliukserhii.p110.model.WeatherDailyDto
import com.mysliukserhii.p110.model.WeatherDataDto


class WeatherAdapter(private val weather: WeatherDailyDto, private val mainActivity: MainActivity) :
    RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {
    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        weather.data.let { holder.bind(it[position]) }
    }

    inner class WeatherViewHolder(itemView: View, mainActivity: MainActivity) :
        RecyclerView.ViewHolder(itemView) {

        private var degrees = mainActivity.findViewById<TextView>(R.id.degrees)
        private var bigIconWeather = mainActivity.findViewById<ImageView>(R.id.big_iconWeather)
        private val button = itemView.findViewById<LinearLayout>(R.id.button)
        private val time = itemView.findViewById<TextView>(R.id.time)
        private val icon_weather = itemView.findViewById<ImageView>(R.id.icon_weather)
        private var degreesText = itemView.findViewById<TextView>(R.id.degreesText)
        private var idWeather: Int = 0

        fun bind(weatherDataDto: WeatherDataDto) {

            degreesText.text = weatherDataDto.appTemp.toString() + "°"
            time.text = weatherDataDto.timestampUtc?.split("T")?.get(1)
            if (time.text == "01:00:00" || time.text == "02:00:00" || time.text == "03:00:00" || time.text == "04:00:00"
                || time.text == "05:00:00" || time.text == "06:00:00" || time.text == "00:00:00" || time.text == "23:00:00"
            ) {
                icon_weather.setImageResource(R.drawable.ic_night34)
                idWeather = R.drawable.ic_night_big
            } else if (weatherDataDto.weather?.description == "Light Weather") {
                icon_weather.setImageResource(R.drawable.ic_sunny34)
                idWeather = R.drawable.ic_sunny_big
            } else if (weatherDataDto.weather?.description == "Light drizzle") {
                icon_weather.setImageResource(R.drawable.ic_rain_34)
                idWeather = R.drawable.ic_rain_big
            } else if (weatherDataDto.weather?.description == "Light snow") {
                icon_weather.setImageResource(R.drawable.ic_rain_34)
                idWeather = R.drawable.ic_rain_big
            } else if (weatherDataDto.weather?.description == "Overcast clouds") {
                icon_weather.setImageResource(R.drawable.ic_partly34)
                idWeather = R.drawable.ic_partly_big
            } else if (weatherDataDto.weather?.description == "Scattered clouds") {
                icon_weather.setImageResource(R.drawable.ic_partly34)
                idWeather = R.drawable.ic_partly_big
            } else if (weatherDataDto.weather?.description == "Light rain") {
                icon_weather.setImageResource(R.drawable.ic_rain_34)
                idWeather = R.drawable.ic_rain_big
            } else if (weatherDataDto.weather?.description == "Snow shower") {
                icon_weather.setImageResource(R.drawable.ic_rain_34)
                idWeather = R.drawable.ic_rain_big
            } else {
                icon_weather.setImageResource(R.drawable.ic_partly34)
                idWeather = R.drawable.ic_partly_big
            }
            button.setOnClickListener {
                degrees.text = degreesText.text
                bigIconWeather.setImageResource(idWeather)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weather, parent, false)
        return WeatherViewHolder(itemView, mainActivity)
    }

    override fun getItemCount(): Int {
        return weather.data.size
    }
}