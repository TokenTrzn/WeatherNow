package com.tokentrzn.weathernow.domain.repository

import com.tokentrzn.weathernow.domain.model.WeatherResponse
import retrofit2.Call

interface WeatherRepository {
    fun getCurrentWeather(cityName: String, apiKey: String): Call<WeatherResponse>
}