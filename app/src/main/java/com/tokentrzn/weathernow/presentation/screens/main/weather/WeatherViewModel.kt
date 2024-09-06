package com.tokentrzn.weathernow.presentation.screens.main.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tokentrzn.weathernow.data.api.APIClient
import com.tokentrzn.weathernow.domain.model.WeatherResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {

    private val _weatherData = MutableStateFlow<WeatherResponse?>(null)
    val weatherData: StateFlow<WeatherResponse?> = _weatherData
    private val apiClient = APIClient.create()

    fun fetchWeather(city: String, apiKey: String, units: String) {
        viewModelScope.launch {
            try {
                val response = apiClient.getWeather(city, apiKey, units)
                _weatherData.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}