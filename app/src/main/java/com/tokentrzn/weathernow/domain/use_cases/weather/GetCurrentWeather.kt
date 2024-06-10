package com.tokentrzn.weathernow.domain.use_cases.weather

import com.tokentrzn.weathernow.domain.repository.WeatherRepository

class GetCurrentWeather(private val repository: WeatherRepository) {
    operator fun invoke(cityName: String, apiKey: String) = repository.getCurrentWeather(cityName, apiKey)
}