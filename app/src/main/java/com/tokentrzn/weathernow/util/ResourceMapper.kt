package com.tokentrzn.weathernow.util

import com.tokentrzn.weathernow.R

object ResourceMapper {
    private val resourceMap = mapOf(
        "01d" to R.drawable.i01d,
        "02d" to R.drawable.i02d,
        "03d" to R.drawable.i03d,
        "04d" to R.drawable.i04d,
        "09d" to R.drawable.i09d,
        "i10d" to R.drawable.i10d,
        "i11d" to R.drawable.i11d,
        "i13d" to R.drawable.i13d,
        "i50d" to R.drawable.i50d,
        "01n" to R.drawable.i01n,
        "02n" to R.drawable.i02n,
        "03n" to R.drawable.i03n,
        "04n" to R.drawable.i04n,
        "09n" to R.drawable.i09n,
        "i10n" to R.drawable.i10n,
        "i11n" to R.drawable.i11n,
        "i13n" to R.drawable.i13n,
        "i50n" to R.drawable.i50n
    )

    fun getDrawableId(name: String): Int {
        return resourceMap[name]!!
    }
}