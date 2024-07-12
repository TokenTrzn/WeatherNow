package com.tokentrzn.weathernow.data.api

import com.tokentrzn.weathernow.BuildConfig.OPENWEATHERMAP_API_KEY
import com.tokentrzn.weathernow.domain.model.City
import com.tokentrzn.weathernow.domain.model.CityResponse
import com.tokentrzn.weathernow.domain.model.Post
import com.tokentrzn.weathernow.domain.model.WeatherResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIClient {

    @GET("v1/forecast")
    suspend fun getWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("hourly") hourly: String = "temperature_2m"
    ): WeatherResponse

    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("units") units: String = "metric",
        @Query("appid") appId: String = OPENWEATHERMAP_API_KEY,
    ): Response<WeatherResponse>

    interface CityService {
        @GET("find")
        suspend fun searchCities(
            @Query("q") query: String,
            @Query("appid") apiKey: String
        ): CityResponse
    }

    object RetrofitClient {
        private const val BASE_URL = "http://api.openweathermap.org/data/2.5/"

        val instance: CityService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CityService::class.java)
        }
    }
}