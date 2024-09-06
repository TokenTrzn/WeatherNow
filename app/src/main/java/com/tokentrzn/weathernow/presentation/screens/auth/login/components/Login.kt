package com.tokentrzn.weathernow.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tokentrzn.weathernow.domain.model.FirebaseResponse
import com.tokentrzn.weathernow.presentation.components.DefaultProgressBar
import com.tokentrzn.weathernow.presentation.navigation.Screen
import com.tokentrzn.weathernow.presentation.screens.auth.login.LoginViewModel


@Composable
fun Login(navController: NavController, viewModel: LoginViewModel = hiltViewModel()) {

    when (viewModel.loginResponse) {

        FirebaseResponse.Loading -> {
            DefaultProgressBar()
        }

        is FirebaseResponse.Success -> {
            navController.navigate(Screen.Weather.route)
        }

        is FirebaseResponse.Error -> {
            viewModel.cleanTextFields()
            Toast.makeText(
                LocalContext.current, "Usuario o contraseña incorrectos",
                Toast.LENGTH_LONG
            ).show()
        }

        else -> {

        }
    }
}