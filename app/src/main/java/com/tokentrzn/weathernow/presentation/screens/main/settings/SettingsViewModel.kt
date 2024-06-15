package com.tokentrzn.weathernow.presentation.screens.main.settings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.tokentrzn.weathernow.domain.repository.UsersRepository
import javax.inject.Inject

class SettingsViewModel @Inject constructor(private val usersRepository: UsersRepository): ViewModel(){
    var state by mutableStateOf(SettingsState())
        private set
}