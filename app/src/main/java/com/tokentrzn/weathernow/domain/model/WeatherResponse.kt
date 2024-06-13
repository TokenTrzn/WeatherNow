package com.tokentrzn.weathernow.domain.model

data class WeatherResponse(
    val main: Main,
    val weather: List<Weather>,
    val name: String
)
