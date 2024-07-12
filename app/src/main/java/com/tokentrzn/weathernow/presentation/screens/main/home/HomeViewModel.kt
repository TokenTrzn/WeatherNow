package com.tokentrzn.weathernow.presentation.screens.main.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tokentrzn.weathernow.di.RetrofitInstance
import com.tokentrzn.weathernow.domain.model.FirebaseResponse
import com.tokentrzn.weathernow.domain.model.WeatherResponse
import com.tokentrzn.weathernow.domain.use_cases.weather.GetCurrentWeather
import com.tokentrzn.weathernow.domain.use_cases.weather.GetWeatherUseCase
import com.tokentrzn.weathernow.domain.use_cases.weather.WeatherUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getCurrentWeather: GetCurrentWeather) : ViewModel() {

}