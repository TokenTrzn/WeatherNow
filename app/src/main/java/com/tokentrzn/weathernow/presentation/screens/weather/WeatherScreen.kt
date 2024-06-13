package com.tokentrzn.weathernow.presentation.screens.weather

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tokentrzn.weathernow.domain.model.FirebaseResponse
import com.tokentrzn.weathernow.presentation.screens.home.WeatherViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun WeatherScreen(weatherViewModel: WeatherViewModel) {
    // State para almacenar el resultado de la llamada al servicio de clima
    val weatherData by weatherViewModel.weatherData.observeAsState()

    // Llama al método para obtener datos del clima cuando la pantalla se muestra
    LaunchedEffect(Unit) {
        weatherViewModel.fetchWeather("London", "your_api_key_here")
    }

    // UI de la pantalla principal
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Transparent
    ) {
        weatherData?.let { response ->
            when (response) {
                is FirebaseResponse.Success -> {
                    val weatherResponse = response.data
                    // Mostrar datos del clima
                    Text("Temperature: ${weatherResponse?.main?.temp} °C")
                    Text("Description: ${weatherResponse?.weather?.firstOrNull()?.description ?: "N/A"}")
                }
                is FirebaseResponse.Error -> {
                    // Manejar el error al obtener el clima
                    Text("Error: ${response.exception}")
                }
                is FirebaseResponse.Loading -> {
                    // Mostrar un indicador de carga si es necesario
                    CircularProgressIndicator()
                }
            }
        }
    }
}