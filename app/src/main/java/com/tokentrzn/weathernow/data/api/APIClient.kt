package com.tokentrzn.weathernow.data.api

import com.tokentrzn.weathernow.data.model.WeatherResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface APIClient {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") unit: String = "metric",
    ): WeatherResponse

    companion object {
        private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

        fun create(): APIClient {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(APIClient::class.java)
        }
    }
}