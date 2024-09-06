package com.tokentrzn.weathernow.domain.model
data class WeatherResponse(
    val name: String,
    val main: Main,
    val wind: Wind,
    val clouds: Clouds,
    val sys: Sys,
    val timezone: Int,
    val weather: List<Weather>
)
data class Main (
    val temp: Float,
    val feels_like: Float,
    val humidity: Int
)
data class Weather(
    val description: String,
    val icon: String
)
data class Wind(
    val speed: Float,
    val deg: Int
)
data class Clouds(
    val all: Int
)
data class Sys(
    val sunrise: Int,
    val sunset: Int
)