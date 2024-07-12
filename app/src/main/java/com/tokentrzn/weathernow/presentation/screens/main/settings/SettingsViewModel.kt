package com.tokentrzn.weathernow.presentation.screens.main.settings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SettingsViewModel @Inject constructor(): ViewModel(){
    var notificationsEnabled by mutableStateOf(false)
        private set
    fun toggleNotifications() {
        notificationsEnabled = !notificationsEnabled
    }

}