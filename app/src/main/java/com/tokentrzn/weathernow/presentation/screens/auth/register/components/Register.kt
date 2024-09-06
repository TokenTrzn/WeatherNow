package com.tokentrzn.weathernow.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tokentrzn.weathernow.domain.model.FirebaseResponse
import com.tokentrzn.weathernow.presentation.components.DefaultProgressBar
import com.tokentrzn.weathernow.presentation.navigation.Screen
import com.tokentrzn.weathernow.presentation.screens.auth.register.RegisterViewModel

@Composable
fun Register(navController: NavController, viewModel: RegisterViewModel = hiltViewModel()) {
    val context = LocalContext.current

    when (val response = viewModel.registerResponse) {
        FirebaseResponse.Loading -> {
            DefaultProgressBar()
        }
        is FirebaseResponse.Success -> {
            if (response.data != null) {
                Toast.makeText(context,"Usuario registrado correctamente", Toast.LENGTH_LONG).show()
                viewModel.registerUser(viewModel.state.email, viewModel.state.password)
                navController.navigate(Screen.Login.route)
            }
        }
        is FirebaseResponse.Error -> {
            viewModel.cleanTextFields()
            Toast.makeText(
                context,
                "Error en el registro: ${(response).exception?.message}",
                Toast.LENGTH_LONG
            ).show()
        }
        else -> {  }
    }
}