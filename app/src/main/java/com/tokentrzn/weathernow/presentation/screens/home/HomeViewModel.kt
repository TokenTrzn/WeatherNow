package com.tokentrzn.weathernow.presentation.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tokentrzn.weathernow.domain.model.FirebaseResponse
import com.tokentrzn.weathernow.domain.model.WeatherResponse
import com.tokentrzn.weathernow.domain.use_cases.weather.GetCurrentWeather
import com.tokentrzn.weathernow.domain.use_cases.weather.GetWeatherUseCase
import com.tokentrzn.weathernow.domain.use_cases.weather.WeatherUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val getCurrentWeather: GetCurrentWeather) : ViewModel() {

    private val _weatherData = MutableLiveData<FirebaseResponse<WeatherResponse?>>()
    val weatherData: LiveData<FirebaseResponse<WeatherResponse?>>
        get() = _weatherData

    fun fetchWeather(cityName: String, apiKey: String) {
        viewModelScope.launch {
            _weatherData.value = getCurrentWeather(cityName, apiKey)
        }
    }
}