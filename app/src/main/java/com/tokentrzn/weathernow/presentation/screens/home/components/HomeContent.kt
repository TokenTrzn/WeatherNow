package com.tokentrzn.weathernow.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.tokentrzn.weathernow.presentation.screens.home.WeatherViewModel

@Composable
fun HomeContent(viewModel: WeatherViewModel = hiltViewModel()) {
/*
val weatherState = viewModel.weatherState.collectAsState().value

    Box(
        modifier = Modifier
            .fillMaxSize(),
        Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("City: ${weatherState?.name}")
            Text("Temperature: ${weatherState?.main?.temp}°C")
            Text("Humidity: ${weatherState?.main?.humidity}%")
            Text("Pressure: ${weatherState?.main?.pressure} hPa")
            weatherState?.weather?.firstOrNull()?.let {
                Text("Condition: ${it.description}")
            }
        }
    }
 */

}