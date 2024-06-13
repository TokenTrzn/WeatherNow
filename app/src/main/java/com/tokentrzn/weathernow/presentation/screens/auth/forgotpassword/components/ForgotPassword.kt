package com.tokentrzn.weathernow.presentation.screens.auth.forgotpassword.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.tokentrzn.weathernow.domain.model.FirebaseResponse
import com.tokentrzn.weathernow.presentation.components.DefaultProgressBar
import com.tokentrzn.weathernow.presentation.screens.auth.forgotpassword.ForgotPasswordViewModel

@Composable
fun ForgotPassword(viewModel: ForgotPasswordViewModel = hiltViewModel()) {
    when (viewModel.response) {

        FirebaseResponse.Loading -> {
            DefaultProgressBar()
        }

        is FirebaseResponse.Success -> {

            Toast.makeText(
                LocalContext.current, "Email enviado correctamente",
                Toast.LENGTH_LONG
            ).show()
        }

        is FirebaseResponse.Error -> {
            Toast.makeText(
                LocalContext.current, "Error al enviar el email",
                Toast.LENGTH_LONG
            ).show()
        }

        else -> {}
    }
}