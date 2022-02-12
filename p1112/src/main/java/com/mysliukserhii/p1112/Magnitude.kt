package com.mysliukserhii.p1112

import androidx.annotation.StringRes

enum class Magnitude(
    @StringRes
    var title: Int,
    @StringRes
    var color: Int
) {
    VERY_LOW(R.string.very_low_title, R.color.light_green),
    WEAK(R.string.weak_title, R.color.light_green),
    MEDIUM(R.string.medium_title, R.color.yellow),
    STRONG(R.string.strong_title, R.color.orange),
    VERY_STRONG(R.string.very_strong_title, R.color.red)
}