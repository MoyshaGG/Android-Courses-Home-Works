package com.mysliukserhii.p111_20

enum class Magnitude {
    SCARCELY_PARCEPTIBLE,
    WEAK,
    AVERAGE,
    STRONG,
    VERY_STRONG;

    val title: Int
        get() = when (this) {
            SCARCELY_PARCEPTIBLE -> R.string.scarcely_parceptible
            WEAK -> R.string.weak
            AVERAGE -> R.string.average
            STRONG -> R.string.strong
            VERY_STRONG -> R.string.very_strong
        }

    val color: Int
        get() = when (this) {
            SCARCELY_PARCEPTIBLE -> R.color.scarcely_parceptible_color
            WEAK -> R.color.weak_color
            AVERAGE -> R.color.average_color
            STRONG -> R.color.strong_color
            VERY_STRONG -> R.color.very_strong_color
        }

    companion object {
        fun getMagnitude(magnitude: Double): Magnitude {
            return when (magnitude) {
                in 1.0..1.99 -> SCARCELY_PARCEPTIBLE
                in 2.0..2.99 -> WEAK
                in 3.0..4.49 -> AVERAGE
                in 4.5..5.99 -> STRONG
                else -> VERY_STRONG
            }
        }
    }
}