package com.tokentrzn.weathernow.presentation.screens.main.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.tokentrzn.weathernow.domain.model.City
import com.tokentrzn.weathernow.domain.model.WeatherResponse

data class HomeState(
    val currentUser: String = "",
    val currentCity: City,
    private val _weatherInfo: MutableState<WeatherResponse?> = mutableStateOf(null),
    val weatherInfo: State<WeatherResponse?> = _weatherInfo
)
