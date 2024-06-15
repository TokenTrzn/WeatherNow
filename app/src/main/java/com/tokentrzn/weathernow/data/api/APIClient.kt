package com.tokentrzn.weathernow.data.api

import com.tokentrzn.weathernow.BuildConfig.OPENWEATHERMAP_API_KEY
import com.tokentrzn.weathernow.domain.model.City
import com.tokentrzn.weathernow.domain.model.WeatherResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface APIClient {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("units") units: String = "metric",
        @Query("appid") appId: String = OPENWEATHERMAP_API_KEY,
    ): Response<WeatherResponse>

    @GET("geo/1.0/direct")
    suspend fun searchCities(
        @Query("q") query: String,
        @Query("limit") limit: Int = 10,
        @Query("appid") apiKey: String = OPENWEATHERMAP_API_KEY
    ): List<City>

    companion object {
        private const val BASE_URL = "https://api.openweathermap.org/"
        fun create(): APIClient {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(APIClient::class.java)
        }
    }
}