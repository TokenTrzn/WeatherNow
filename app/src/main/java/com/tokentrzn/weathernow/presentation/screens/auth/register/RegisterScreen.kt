package com.tokentrzn.weathernow.presentation.screens.auth.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.tokentrzn.weathernow.presentation.screens.auth.register.components.Register
import com.tokentrzn.weathernow.presentation.screens.auth.register.components.RegisterContent
import com.tokentrzn.weathernow.presentation.screens.auth.register.components.RegisterTopBar
import com.tokentrzn.weathernow.presentation.theme.LinearGradient

@Composable
fun RegisterScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LinearGradient())
    ){
        Scaffold (
            containerColor = Color.Transparent,
            topBar = { RegisterTopBar(navController) }
        ){
                contentPadding ->
            // Screen content
            Box(modifier = Modifier
                .padding(contentPadding)) { RegisterContent(navController) }
        }
        Register(navController)
    }
}