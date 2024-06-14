package com.tokentrzn.weathernow.presentation.screens.main.settings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.tokentrzn.weathernow.presentation.navigation.Screen
import com.tokentrzn.weathernow.presentation.theme.PrimaryTextColor
import com.tokentrzn.weathernow.presentation.theme.TextIconsColor


@Composable
fun SettingsTopBar(navController: NavController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(PrimaryTextColor),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box() {
            IconButton(
                onClick = { navController.navigate(Screen.Home.route) }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back Icon",
                    tint = TextIconsColor
                )
            }
        }
    }
}