package com.tokentrzn.weathernow.data.api

import com.tokentrzn.weathernow.BuildConfig.OPENWEATHERMAP_API_KEY
import com.tokentrzn.weathernow.domain.model.WeatherResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIClient {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("units") units: String = "metric",
        @Query("appid") appId: String = OPENWEATHERMAP_API_KEY,
    ): Response<WeatherResponse>

}