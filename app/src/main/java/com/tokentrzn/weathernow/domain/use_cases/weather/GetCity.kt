package com.tokentrzn.weathernow.domain.use_cases.weather

import com.tokentrzn.weathernow.domain.repository.WeatherRepository
import javax.inject.Inject

class GetCity @Inject constructor(private val repository: WeatherRepository) {
    suspend operator fun invoke(cityName: String): String {
        return repository.getCity(cityName)
    }
}