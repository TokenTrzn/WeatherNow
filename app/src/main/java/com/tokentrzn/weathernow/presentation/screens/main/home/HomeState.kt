package com.tokentrzn.weathernow.presentation.screens.main.home

import com.tokentrzn.weathernow.domain.model.City

data class HomeState(
    val currentUser: String = "",
    val currentCity: City
)
