package com.tokentrzn.weathernow.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.tokentrzn.weathernow.domain.use_cases.weather.WeatherUseCases
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val weatherUseCases: WeatherUseCases): ViewModel() {
}