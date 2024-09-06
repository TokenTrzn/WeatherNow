package com.tokentrzn.weathernow.presentation.screens.auth.register.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tokentrzn.weathernow.R
import com.tokentrzn.weathernow.presentation.components.DefaultButton
import com.tokentrzn.weathernow.presentation.components.DefaultTextField
import com.tokentrzn.weathernow.presentation.navigation.Screen
import com.tokentrzn.weathernow.presentation.screens.auth.register.RegisterViewModel

@Composable
fun RegisterContent( navController: NavController, viewModel: RegisterViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(painter = painterResource(id = R.drawable.weather_app_icon_with_name),
                modifier = Modifier.padding(40.dp),
                contentDescription = "Weather Now icon with name"
            )
            Spacer(modifier = Modifier.height(100.dp))
            Text(
                text = "CREAR CUENTA NUEVA",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
            DefaultTextField(
                modifier = Modifier.padding(top = 8.dp),
                value = viewModel.state.email,
                onValueChange = { viewModel.onEmailInput(it)},
                label = "Correo electrónico",
                icon = Icons.Default.Email,
                keyboardType = KeyboardType.Email,
                errorMsg = viewModel.emailErrMsg,
                validateField = { viewModel.validateEmail()
                    viewModel.enabledRegisterButton() },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )
            Spacer(modifier = Modifier.size(4.dp))
            DefaultTextField(
                modifier = Modifier.padding(top = 0.dp),
                value = viewModel.state.password,
                onValueChange = {viewModel.onPasswordInput(it)},
                label = "Contraseña",
                icon = Icons.Default.Lock,
                hideText = true,
                errorMsg = viewModel.passwordErrMsg,
                validateField = {
                    viewModel.validatePassword()
                    viewModel.enabledRegisterButton()
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )
            Spacer(modifier = Modifier.size(4.dp))
            DefaultTextField(
                modifier = Modifier.padding(top = 0.dp),
                value = viewModel.state.confirmPassword,
                onValueChange = {viewModel.onConfirmPasswordInput(it)},
                label = "Confirmar Contraseña",
                icon = Icons.Default.Lock,
                hideText = true,
                errorMsg = viewModel.passwordNotEqualsMsg,
                validateField = {
                    viewModel.confirmPassword()
                    viewModel.enabledRegisterButton()
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
            )
            Spacer(modifier = Modifier.size(16.dp))
            DefaultButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 56.dp)
                    .padding(bottom = 20.dp),
                text = "CREAR CUENTA",
                onClick = {
                    viewModel.registerUser(viewModel.state.email, viewModel.state.password)
                    navController.navigate(Screen.Weather.route)
                },
                enabled = viewModel.isEnabledRegisterButton
            )
        }
    }
}