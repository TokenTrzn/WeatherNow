package com.tokentrzn.weathernow.presentation.screens.main.weather.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tokentrzn.weathernow.presentation.navigation.Screen
import com.tokentrzn.weathernow.presentation.theme.PrimaryTextColor

@Composable
fun WeatherTopBar(navController: NavController) {
    Box(modifier = Modifier.fillMaxWidth(), Alignment.TopEnd) {
        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = "Settings Icon",
            modifier = Modifier
                .clickable { navController.navigate(Screen.Settings.route) }
                .padding(8.dp),
            tint = PrimaryTextColor
        )
    }
}

