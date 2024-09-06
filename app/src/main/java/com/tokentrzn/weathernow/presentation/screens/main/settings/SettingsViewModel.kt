package com.tokentrzn.weathernow.presentation.screens.main.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tokentrzn.weathernow.domain.use_cases.authentication.LogOut
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val logOut: LogOut): ViewModel() {

    private val _unit = MutableStateFlow("metric")
    val unit: StateFlow<String> = _unit.asStateFlow()

    fun updateUnit(newUnit: String) {
        _unit.value = newUnit
    }

    fun logout() {
        viewModelScope.launch {
            logOut()
        }
    }
}