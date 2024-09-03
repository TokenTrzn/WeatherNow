package com.tokentrzn.weathernow.presentation.screens.main.weather.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tokentrzn.weathernow.presentation.navigation.Screen
import com.tokentrzn.weathernow.presentation.theme.DividerColor
import com.tokentrzn.weathernow.presentation.theme.TextIconsColor

@Composable
fun HomeTopBar(navController: NavController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(top = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box() {
            IconButton(
                onClick = { /* Handle action */ }
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu Icon",
                    tint = TextIconsColor
                )
            }
        }

        Text(
            text = "Tarazona",
            color = DividerColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

