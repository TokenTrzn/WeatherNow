package com.tokentrzn.weathernow.data.repository

import com.tokentrzn.weathernow.data.api.APIClient
import com.tokentrzn.weathernow.domain.model.FirebaseResponse
import com.tokentrzn.weathernow.domain.model.WeatherResponse
import com.tokentrzn.weathernow.domain.repository.WeatherRepository
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val apiService: APIClient) : WeatherRepository {
    override suspend fun getCurrentWeather(city: String, apiKey: String): FirebaseResponse<WeatherResponse?> {
        return try {
            val response = apiService.getCurrentWeather(city, apiKey)
            if (response.isSuccessful) {
                FirebaseResponse.Success(response.body())
            } else {
                FirebaseResponse.Error("Error al obtener el clima: ${response.message()}")
            }
        } catch (e: Exception) {
            FirebaseResponse.Error("Error al obtener el clima: ${e.message}")
        }
    }

    override suspend fun getWeatherUseCases(
        city: String,
        apiKey: String
    ): FirebaseResponse<WeatherResponse?> {
        TODO("Not yet implemented")
    }
}