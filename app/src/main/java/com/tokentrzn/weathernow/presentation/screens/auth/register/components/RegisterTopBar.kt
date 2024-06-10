package com.tokentrzn.weathernow.presentation.screens.auth.register.components

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tokentrzn.weathernow.presentation.navigation.Screen
import com.tokentrzn.weathernow.presentation.theme.PrimaryTextColor

@Composable
fun RegisterTopBar(navController: NavController) {
    Box(modifier = Modifier.fillMaxWidth(), Alignment.TopStart) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "close",
            modifier = Modifier
                .clickable { navController.navigate(Screen.Login.route) }
                .padding(4.dp),
            tint = PrimaryTextColor
        )
    }
}