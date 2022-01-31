package ui.model

import androidx.annotation.ColorRes
import androidx.annotation.StringRes

data class EarthQuakeDvo(
    val time: String,
    val location: String,
    @StringRes val intensityTitle: Int,
    @ColorRes val color: Int,
    val magnitude: String
)