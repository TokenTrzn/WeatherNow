package com.tokentrzn.weathernow.domain.model

data class WeatherResponse(
    val temperature: List<Double>,
    val time: List<String>
)
