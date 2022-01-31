package model

import com.google.gson.annotations.SerializedName

data class EarthQuakeDto(
    @SerializedName("features")
    val features: List<FeatureDto>,
    @SerializedName("type")
    val type: String
)

data class FeatureDto(
    @SerializedName("geometry")
    val geometry: GeometryDto,
    @SerializedName("properties")
    val properties: PropertiesDto,
    @SerializedName("type")
    val type: String
)

data class GeometryDto(
    @SerializedName("coordinates")
    val coordinates: List<Double>,
    @SerializedName("type")
    val type: String
)

data class PropertiesDto(
    @SerializedName("depth")
    val depth: Double,
    @SerializedName("locality")
    val locality: String,
    @SerializedName("magnitude")
    val magnitude: Double,
    @SerializedName("mmi")
    val mmi: Int,
    @SerializedName("publicID")
    val publicID: String,
    @SerializedName("quality")
    val quality: String,
    @SerializedName("time")
    val time: String
)
