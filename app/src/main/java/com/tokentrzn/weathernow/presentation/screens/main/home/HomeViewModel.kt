package com.tokentrzn.weathernow.presentation.screens.main.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tokentrzn.weathernow.domain.repository.AuthRepository
import com.tokentrzn.weathernow.domain.repository.WeatherRepository
import com.tokentrzn.weathernow.util.DEFAULT_WEATHER_DESTINATION
import com.tokentrzn.weathernow.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val aRepository: AuthRepository
) : ViewModel() {
    fun logout() {
        viewModelScope.launch {
            aRepository.logout()
        }
    }

}