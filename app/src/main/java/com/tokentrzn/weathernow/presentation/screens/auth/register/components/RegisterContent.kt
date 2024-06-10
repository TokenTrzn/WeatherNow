package com.tokentrzn.weathernow.presentation.screens.auth.register.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tokentrzn.weathernow.presentation.components.DefaultButton
import com.tokentrzn.weathernow.presentation.components.DefaultTextField
import com.tokentrzn.weathernow.presentation.screens.auth.register.RegisterViewModel
import com.tokentrzn.weathernow.presentation.theme.PrimaryTextColor

@Composable
fun RegisterContent( viewModel: RegisterViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(bottom = 100.dp),
                text = "Crear una Cuenta Nueva",
                style = MaterialTheme.typography.headlineMedium.copy(),
                fontSize = 30.sp,
                color = PrimaryTextColor,

                )
            DefaultTextField(
                modifier = Modifier.padding(top = 8.dp),
                value = viewModel.state.name,
                onValueChange = { viewModel.onNameInput(it)},
                label = "Nombre",
                icon = Icons.Default.Person,
                keyboardType = KeyboardType.Text,
            )
            Spacer(modifier = Modifier.size(4.dp))
            DefaultTextField(
                modifier = Modifier.padding(top = 8.dp),
                value = viewModel.state.city,
                onValueChange = { viewModel.onCityInput(it)},
                label = "Ciudad",
                icon = Icons.Default.LocationCity,
                keyboardType = KeyboardType.Text
            )
            Spacer(modifier = Modifier.size(4.dp))
            DefaultTextField(
                modifier = Modifier.padding(top = 8.dp),
                value = viewModel.state.email,
                onValueChange = { viewModel.onEmailInput(it)},
                label = "Correo electrónico",
                icon = Icons.Default.Email,
                keyboardType = KeyboardType.Email,
                errorMsg = viewModel.emailErrMsg,
                validateField = { viewModel.validateEmail()
                    viewModel.enabledRegisterButton()}
            )
            Spacer(modifier = Modifier.size(4.dp))
            DefaultTextField(
                modifier = Modifier.padding(top = 0.dp),
                value =viewModel.state.password,
                onValueChange = {viewModel.onPasswordInput(it)},
                label = "Contraseña",
                icon = Icons.Default.Lock,
                hideText = true,
                errorMsg = viewModel.passwordErrMsg,
                validateField = {
                    viewModel.validatePassword()
                    viewModel.enabledRegisterButton()
                }
            )
            Spacer(modifier = Modifier.size(4.dp))
            DefaultTextField(
                modifier = Modifier.padding(top = 0.dp),
                value =viewModel.state.confirmPassword,
                onValueChange = {viewModel.onConfirmPasswordInput(it)},
                label = "Confirmar Contraseña",
                icon = Icons.Default.Lock,
                hideText = true,
                errorMsg = viewModel.passwordNotEqualsMsg,
                validateField = {
                    viewModel.confirmPassword()
                    viewModel.enabledRegisterButton()
                }
            )
            Spacer(modifier = Modifier.size(16.dp))
            DefaultButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 56.dp),
                text = "REGISTER",
                onClick = {  },
                enabled = viewModel.isEnabledRegisterButton
            )
        }
    }
}