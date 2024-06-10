package com.tokentrzn.weathernow.domain.model

data class WeatherResponse(
    val coord: Coord,
    val weather: List<Weather>,
    val main: Main,
    val name: String
)
