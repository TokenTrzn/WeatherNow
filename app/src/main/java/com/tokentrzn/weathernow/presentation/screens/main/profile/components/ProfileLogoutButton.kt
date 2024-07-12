package com.tokentrzn.weathernow.presentation.screens.main.profile.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tokentrzn.weathernow.presentation.components.DefaultProgressBar
import com.tokentrzn.weathernow.presentation.navigation.Screen
import com.tokentrzn.weathernow.presentation.screens.main.profile.LogoutState
import com.tokentrzn.weathernow.presentation.screens.main.profile.ProfileViewModel

@Composable
fun LogoutButton(navController: NavController, viewModel: ProfileViewModel = hiltViewModel()) {

    val logoutState by viewModel.logoutState.collectAsState()

    Button(
        onClick = { navController.navigate(Screen.Login.route) },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 8.dp, top = 12.dp)
                    .size(32.dp),
                imageVector = Icons.AutoMirrored.Filled.Logout,
                contentDescription = "Icon",
                tint = Color.White
            )

            Text(
                modifier = Modifier
                    .padding(top = 8.dp),
                text = "Cerrar Sesión",
                textAlign = TextAlign.Start,
                color = Color.White,
                fontSize = 12.sp
            )
        }
    }

    when (logoutState) {
        is LogoutState.Loading -> {
            DefaultProgressBar()
        }
        is LogoutState.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(Screen.Login.route) {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                }
            }
        }
        is LogoutState.Error -> {
            Toast.makeText(
                LocalContext.current,
                "Error al cerrar sesión: ${(logoutState as LogoutState.Error).message}",
                Toast.LENGTH_LONG
            ).show()
        }
        else -> { /* No action needed for Idle state */ }
    }
}