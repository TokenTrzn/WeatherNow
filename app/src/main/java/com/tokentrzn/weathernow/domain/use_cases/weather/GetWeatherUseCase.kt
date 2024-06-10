package com.tokentrzn.weathernow.domain.use_cases.weather

import com.tokentrzn.weathernow.domain.model.WeatherResponse
import com.tokentrzn.weathernow.domain.repository.WeatherRepository
import retrofit2.Call

class GetWeatherUseCase(private val weatherRepository: WeatherRepository) {
    fun execute(cityName: String, apiKey: String): Call<WeatherResponse> {
        return weatherRepository.getCurrentWeather(cityName, apiKey)
    }
}