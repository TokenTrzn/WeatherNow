package com.tokentrzn.weathernow.domain.repository

import com.tokentrzn.weathernow.domain.model.City
import com.tokentrzn.weathernow.domain.model.FirebaseResponse
import com.tokentrzn.weathernow.domain.model.WeatherResponse

interface WeatherRepository {
    suspend fun getCurrentWeather(city: String, apiKey: String): FirebaseResponse<WeatherResponse?>
    suspend fun getWeatherUseCases(city: String, apiKey: String): FirebaseResponse<WeatherResponse?>
    suspend fun getCity(city: String): String
}