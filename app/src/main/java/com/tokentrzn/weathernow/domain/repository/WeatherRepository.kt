package com.tokentrzn.weathernow.domain.repository

import com.tokentrzn.weathernow.domain.model.Weather
import com.tokentrzn.weathernow.util.Result
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherForecast(city: String): Flow<Result<Weather>>
}