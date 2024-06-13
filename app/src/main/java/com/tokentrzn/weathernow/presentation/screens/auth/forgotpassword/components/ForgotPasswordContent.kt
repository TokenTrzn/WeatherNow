package com.tokentrzn.weathernow.presentation.screens.auth.forgotpassword.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tokentrzn.weathernow.R
import com.tokentrzn.weathernow.presentation.components.DefaultButton
import com.tokentrzn.weathernow.presentation.components.DefaultTextField
import com.tokentrzn.weathernow.presentation.screens.auth.forgotpassword.ForgotPasswordViewModel
import com.tokentrzn.weathernow.presentation.theme.PrimaryTextColor

@Composable
fun ForgotPasswordContent( viewModel: ForgotPasswordViewModel = hiltViewModel()) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.forgot_password_icon),
                modifier = Modifier.size(200.dp).padding(10.dp, bottom = 70.dp),
                contentDescription = "Lock Icon"
            )
            Text(
                modifier = Modifier.padding(16.dp, bottom = 12.dp),
                text = "¿OLVIDASTE TU CONTRASEÑA?",
                fontSize = 20.sp,
                color = PrimaryTextColor,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(8.dp, bottom = 30.dp),
                text = "Introduce tu correo y te mandaremos un email para cambiarla",
                fontSize = 12.sp,
                color = PrimaryTextColor,
                fontWeight = FontWeight.Light
            )
            DefaultTextField(
                modifier = Modifier.padding(top = 8.dp),
                value = viewModel.state.email,
                onValueChange = { viewModel.onEmailInput(it)},
                label = "Correo electronico",
                icon = Icons.Default.Email,
                keyboardType = KeyboardType.Email,
                errorMsg = viewModel.emailErrMsg,
                validateField = { viewModel.validateEmail()
                    viewModel.isEnabledSendEmailButton}
            )
            Spacer(modifier = Modifier.size(4.dp))
            DefaultButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 56.dp),
                text = "ENVIAR EMAIL",
                onClick = { /* viewModel.sendPasswordRecoveryEmail() */ },
                enabled = viewModel.isEnabledSendEmailButton
            )
        }
    }
}