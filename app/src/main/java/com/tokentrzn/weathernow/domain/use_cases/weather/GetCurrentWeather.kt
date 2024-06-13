package com.tokentrzn.weathernow.domain.use_cases.weather

import com.tokentrzn.weathernow.domain.model.FirebaseResponse
import com.tokentrzn.weathernow.domain.model.WeatherResponse
import com.tokentrzn.weathernow.domain.repository.WeatherRepository
import javax.inject.Inject

class GetCurrentWeather @Inject constructor(private val repository: WeatherRepository) {
    suspend operator fun invoke(cityName: String, apiKey: String): FirebaseResponse<WeatherResponse?> {
        return repository.getCurrentWeather(cityName, apiKey)
    }
}