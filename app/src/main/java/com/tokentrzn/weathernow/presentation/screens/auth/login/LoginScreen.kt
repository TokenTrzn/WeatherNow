package com.tokentrzn.weathernow.presentation.screens.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.tokentrzn.weathernow.presentation.screens.auth.login.components.Login
import com.tokentrzn.weathernow.presentation.screens.auth.login.components.LoginBottomBar
import com.tokentrzn.weathernow.presentation.screens.auth.login.components.LoginContent
import com.tokentrzn.weathernow.presentation.screens.auth.login.components.LoginTopBar
import com.tokentrzn.weathernow.presentation.theme.LinearGradient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LinearGradient())
    ){
        Scaffold (
            containerColor = Color.Transparent,
            topBar = { LoginTopBar() },
            bottomBar = { LoginBottomBar(navController) }
        ){
                contentPadding ->
            // Screen content
            Box(modifier = Modifier
                .padding(contentPadding)) { LoginContent(navController) }
        }
        Login(navController)
    }
}