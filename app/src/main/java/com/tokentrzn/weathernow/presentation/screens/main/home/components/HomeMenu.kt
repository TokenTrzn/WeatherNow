package com.tokentrzn.weathernow.presentation.screens.main.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tokentrzn.weathernow.R
import com.tokentrzn.weathernow.presentation.navigation.Screen
import com.tokentrzn.weathernow.presentation.theme.DarkTransparentColor

@Composable
fun DrawerHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.weather_app_icon),
            modifier = Modifier.size(100.dp),
            contentDescription = "App icon"
        )
        Text(
            text = "Weather\nNow",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}

@Composable
fun DrawerContent(navController: NavController) {
    Column(modifier = Modifier
        .background(DarkTransparentColor)
        .fillMaxHeight()) {
        DrawerHeader()
        HorizontalDivider(thickness = 1.dp, color = Color.White, modifier = Modifier.padding(10.dp))
        MenuButton(navController = navController, route = Screen.Profile.route, icon = Icons.Default.Person, text = "Perfil")
        HorizontalDivider(thickness = 1.dp, color = Color.White, modifier = Modifier.padding(10.dp))
        MenuButton(navController = navController, route = Screen.Settings.route, icon = Icons.Default.Settings, text = "Ajustes")
        HorizontalDivider(thickness = 1.dp, color = Color.White, modifier = Modifier.padding(10.dp))

    }
}
