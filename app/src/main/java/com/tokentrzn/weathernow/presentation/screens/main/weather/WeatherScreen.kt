package com.tokentrzn.weathernow.presentation.screens.main.weather

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Air
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.tokentrzn.weathernow.BuildConfig
import com.tokentrzn.weathernow.presentation.components.DefaultButton
import com.tokentrzn.weathernow.presentation.screens.main.settings.SettingsViewModel
import com.tokentrzn.weathernow.presentation.screens.main.weather.components.WeatherCard
import com.tokentrzn.weathernow.presentation.screens.main.weather.components.WeatherCardLong
import com.tokentrzn.weathernow.presentation.screens.main.weather.components.WeatherCardWind
import com.tokentrzn.weathernow.presentation.screens.main.weather.components.WeatherInfoCard
import com.tokentrzn.weathernow.presentation.screens.main.weather.components.WeatherSunsetCard
import com.tokentrzn.weathernow.presentation.screens.main.weather.components.WeatherTopBar
import com.tokentrzn.weathernow.presentation.theme.DarkPrimaryColor
import com.tokentrzn.weathernow.presentation.theme.LinearGradient
import com.tokentrzn.weathernow.presentation.theme.PrimaryTextColor

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WeatherScreen(navController: NavController) {

    val settingsViewModel: SettingsViewModel = hiltViewModel()
    val viewModel: WeatherViewModel = viewModel()
    val weatherData by viewModel.weatherData.collectAsState()
    var city by remember { mutableStateOf("") }
    val apiKey = BuildConfig.OPENWEATHERMAP_API_KEY

    val unit by settingsViewModel.unit.collectAsState()
    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LinearGradient())
    ) {
        Scaffold(
            containerColor = Color.Transparent,
            topBar = { WeatherTopBar(navController = navController)}
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    OutlinedTextField(
                        value = city,
                        onValueChange = { city = it },
                        label = { Text(text = "Ciudad", color = PrimaryTextColor) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(30.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PrimaryTextColor,
                            unfocusedBorderColor = PrimaryTextColor,
                            focusedPlaceholderColor = PrimaryTextColor,
                            unfocusedPlaceholderColor = PrimaryTextColor,

                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 70.dp),
                        text = "Buscar",
                        onClick = {
                            viewModel.fetchWeather(city, apiKey, unit)
                            city = ""
                            keyboardController?.hide()
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    weatherData?.let {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(8.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(bottom = 8.dp)
                                ) {
                                    WeatherCardLong(
                                        value = "${it.main.temp}ºC",
                                        icon = it.weather[0].icon,
                                        desc = it.weather[0].description
                                    )
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                Row(
                                    modifier = Modifier.fillMaxHeight()
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(end = 8.dp)
                                    ) {
                                        WeatherCard(
                                            label = "Ciudad",
                                            value = it.name,
                                            value2 = "${it.main.feels_like}ºC",
                                            icon = Icons.Default.Place,
                                            modifier = Modifier.weight(1f)
                                        )
                                        WeatherCardWind(
                                            label = "Viento",
                                            value = "${it.wind.speed}Km/h",
                                            deg = it.wind.deg,
                                            icon = Icons.Default.Air,
                                            modifier = Modifier.weight(1f)
                                        )
                                    }
                                    Column(modifier = Modifier.weight(1f)) {
                                        WeatherInfoCard(
                                            value1 = "${it.main.humidity}%",
                                            value2 = "${it.clouds.all}%",
                                            value3 = "${it.main.feels_like}ºC",
                                            icon = Icons.Default.Info,
                                            label = "Más Información"
                                        )
                                        WeatherSunsetCard(
                                            sunrise = it.sys.sunrise.toLong(),
                                            sunset = it.sys.sunset.toLong(),
                                            timeZone = it.timezone
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}