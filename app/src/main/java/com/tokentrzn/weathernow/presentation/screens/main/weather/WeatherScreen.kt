package com.tokentrzn.weathernow.presentation.screens.main.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.material.icons.filled.Water
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.tokentrzn.weathernow.BuildConfig
import com.tokentrzn.weathernow.R
import com.tokentrzn.weathernow.presentation.screens.main.weather.components.WeatherCard
import com.tokentrzn.weathernow.presentation.theme.DarkPrimaryColor
import com.tokentrzn.weathernow.presentation.theme.LinearGradient
import com.tokentrzn.weathernow.presentation.theme.PrimaryTextColor

@Composable
fun WeatherScreen(navController: NavController) {

    val viewModel: WeatherViewModel = viewModel()
    val weatherData by viewModel.weatherData.collectAsState()
    var city by remember { mutableStateOf("") }
    val apiKey = BuildConfig.OPENWEATHERMAP_API_KEY

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LinearGradient())
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Box(
                modifier = Modifier.padding(10.dp),
                contentAlignment = Alignment.Center) {
                    Image(painter = painterResource(
                        id = R.drawable.weather_app_icon),
                        contentDescription = "WeatherNow Icon"
                    )
            }
            Spacer(modifier = Modifier.height(180.dp))
            OutlinedTextField(
                value = city,
                onValueChange = { city = it },
                label = { Text(text = "City", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(30.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { viewModel.fetchWeather(city, apiKey) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkPrimaryColor,
                    contentColor = PrimaryTextColor
                )
            ) {
               Text(text = "Check Weather")
            }

            Spacer(modifier = Modifier.height(16.dp))

            weatherData?.let {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    WeatherCard(label = "City", value = it.name, icon = Icons.Default.Place)
                    WeatherCard(label = "Temperature", value = "${it.main.temp}ºC", icon = Icons.Default.Thermostat)
                }
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    WeatherCard(label = "Humidity", value = "${it.main.humidity}%", icon = Icons.Default.Water)
                    WeatherCard(label = "Description", value = "${it.weather[0].description}", icon = Icons.Default.Info)
                }
            }
        }
    }
}

