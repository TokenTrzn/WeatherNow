package com.tokentrzn.weathernow.data.repository

import com.tokentrzn.weathernow.data.api.APIClient
import com.tokentrzn.weathernow.domain.model.WeatherResponse
import com.tokentrzn.weathernow.domain.repository.WeatherRepository
import retrofit2.Call

class WeatherRepositoryImpl (private val apiService: APIClient) : WeatherRepository {
    override fun getCurrentWeather(cityName: String, apiKey: String): Call<WeatherResponse> {
        return apiService.getCurrentWeather(cityName, apiKey)
    }
}