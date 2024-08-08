package com.tokentrzn.weathernow.data.api

import com.tokentrzn.weathernow.BuildConfig
import com.tokentrzn.weathernow.data.model.ForecastResponse
import com.tokentrzn.weathernow.util.DEFAULT_WEATHER_DESTINATION
import com.tokentrzn.weathernow.util.NUMBER_OF_DAYS
import retrofit2.http.GET
import retrofit2.http.Query

interface APIClient {
    @GET("forecast.json")
    suspend fun getWeatherForecast(
        @Query("key") key: String = BuildConfig.OPENWEATHERMAP_API_KEY,
        @Query("q") city: String = DEFAULT_WEATHER_DESTINATION,
        @Query("days") days: Int = NUMBER_OF_DAYS,
    ): ForecastResponse
}