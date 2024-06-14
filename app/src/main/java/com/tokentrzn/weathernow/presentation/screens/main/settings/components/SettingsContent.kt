package com.tokentrzn.weathernow.presentation.screens.main.settings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SettingsContent() {
    Box(
        modifier = Modifier
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            SettingToggleButton(title = "Notificaciones")
        }
    }

}