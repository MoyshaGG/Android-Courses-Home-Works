package com.mysliukserhii.p110.model

import com.google.gson.annotations.SerializedName


data class WeatherDailyDto(
    @SerializedName("data") var data: List<WeatherDataDto> = arrayListOf(),
    @SerializedName("city_name") var cityName: String? = null,
    @SerializedName("lon") var lon: Double? = null,
    @SerializedName("timezone") var timezone: String? = null,
    @SerializedName("lat") var lat: Double? = null,
    @SerializedName("country_code") var countryCode: String? = null,
    @SerializedName("state_code") var stateCode: String? = null
)

data class WeatherDto(

    @SerializedName("icon") var icon: String? = null,
    @SerializedName("code") var code: Double? = null,
    @SerializedName("description") var description: String? = null

)

data class WeatherDataDto(

    @SerializedName("wind_cdir")
    var windCdir: String? = null,
    @SerializedName("rh")
    var rh: Double? = null,
    @SerializedName("pod")
    var pod: String? = null,
    @SerializedName("timestamp_utc")
    var timestampUtc: String? = null,
    @SerializedName("pres")
    var pres: Double? = null,
    @SerializedName("solar_rad") var solarRad: Double? = null,
    @SerializedName("ozone") var ozone: Double? = null,
    @SerializedName("weather") var weather: WeatherDto? = WeatherDto(),
    @SerializedName("wind_gust_spd") var windGustSpd: Double? = null,
    @SerializedName("timestamp_local") var timestampLocal: String? = null,
    @SerializedName("snow_depth") var snowDepth: Double? = null,
    @SerializedName("clouds") var clouds: Double? = null,
    @SerializedName("ts") var ts: Double? = null,
    @SerializedName("wind_spd") var windSpd: Double? = null,
    @SerializedName("pop") var pop: Double? = null,
    @SerializedName("wind_cdir_full") var windCdirFull: String? = null,
    @SerializedName("slp") var slp: Double? = null,
    @SerializedName("dni") var dni: Double? = null,
    @SerializedName("dewpt") var dewpt: Double? = null,
    @SerializedName("snow") var snow: Double? = null,
    @SerializedName("uv") var uv: Double? = null,
    @SerializedName("wind_dir") var windDir: Double? = null,
    @SerializedName("clouds_hi") var cloudsHi: Double? = null,
    @SerializedName("precip") var precip: Double? = null,
    @SerializedName("vis") var vis: Double? = null,
    @SerializedName("dhi") var dhi: Double? = null,
    @SerializedName("app_temp") var appTemp: Double? = null,
    @SerializedName("datetime") var datetime: String? = null,
    @SerializedName("temp") var temp: Double? = null,
    @SerializedName("ghi") var ghi: Double? = null,
    @SerializedName("clouds_mid") var cloudsMid: Double? = null,
    @SerializedName("clouds_low") var cloudsLow: Double? = null

)