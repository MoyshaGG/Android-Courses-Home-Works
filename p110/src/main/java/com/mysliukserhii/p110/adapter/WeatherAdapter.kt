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
import com.mysliukserhii.p110.model.DailyDto
import com.mysliukserhii.p110.model.DataDto


class WeatherAdapter(private val weather:DailyDto, val mainActivity: MainActivity) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>(){
    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        weather.data?.let { holder.bind(it.get(position)) }
    }

    inner class WeatherViewHolder(itemView: View, mainActivity: MainActivity): RecyclerView.ViewHolder(itemView)
    {

        var degrees = mainActivity.findViewById<TextView>(R.id.degrees)
        var bigIconWeather = mainActivity.findViewById<ImageView>(R.id.big_iconWeather)
        val button = itemView.findViewById<LinearLayout>(R.id.button)
        val time = itemView.findViewById<TextView>(R.id.time)
        val icon_weather = itemView.findViewById<ImageView>(R.id.icon_weather)
        var degreesText = itemView.findViewById<TextView>(R.id.degreesText)
        var idWeather:Int = 0

        fun bind(dataDto: DataDto)
        {

           degreesText.text = dataDto?.appTemp.toString() + "°"
            time.text = dataDto.timestampUtc?.split("T")?.get(1)
            if(time.text == "01:00:00" ||time.text == "02:00:00" ||time.text == "03:00:00" ||time.text == "04:00:00"
                || time.text =="05:00:00" || time.text =="06:00:00" ||time.text =="00:00:00" || time.text =="23:00:00")
            {
                icon_weather.setImageResource(R.drawable.ic_night34)
                idWeather = R.drawable.ic_night_big
            }
           else if(dataDto.weather?.description == "Light Weather")
           {
               icon_weather.setImageResource(R.drawable.ic_sunny34)
               idWeather = R.drawable.ic_sunny_big
           }
            else if(dataDto.weather?.description == "Light drizzle")
            {
                icon_weather.setImageResource(R.drawable.ic_rain_34)
                idWeather = R.drawable.ic_rain_big
            }
           else  if(dataDto.weather?.description == "Light snow")
            {
                icon_weather.setImageResource(R.drawable.ic_rain_34)
                idWeather = R.drawable.ic_rain_big
            }
           else if(dataDto.weather?.description == "Overcast clouds")
            {
                icon_weather.setImageResource(R.drawable.ic_partly34)
                idWeather = R.drawable.ic_partly_big
            }
           else  if(dataDto.weather?.description == "Scattered clouds")
            {
                icon_weather.setImageResource(R.drawable.ic_partly34)
                idWeather = R.drawable.ic_partly_big
            }
           else  if(dataDto.weather?.description == "Light rain")
            {
                icon_weather.setImageResource(R.drawable.ic_rain_34)
                idWeather = R.drawable.ic_rain_big
            }
           else  if(dataDto.weather?.description == "Snow shower")
            {
                icon_weather.setImageResource(R.drawable.ic_rain_34)
                idWeather = R.drawable.ic_rain_big
            }
            else
            {
                icon_weather.setImageResource(R.drawable.ic_partly34)
                idWeather = R.drawable.ic_partly_big
            }
            button.setOnClickListener{
                degrees.text = degreesText.text
                bigIconWeather.setImageResource(idWeather)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weather,parent,false)
        return WeatherViewHolder(itemView, mainActivity)
    }

    override fun getItemCount(): Int {
        return weather.data.size
    }
}