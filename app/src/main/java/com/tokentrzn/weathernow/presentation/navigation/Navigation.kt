package com.tokentrzn.weathernow.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tokentrzn.weathernow.presentation.screens.auth.forgotpassword.ForgotPasswordScreen
import com.tokentrzn.weathernow.presentation.screens.auth.login.LoginScreen
import com.tokentrzn.weathernow.presentation.screens.auth.register.RegisterScreen
import com.tokentrzn.weathernow.presentation.screens.home.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(Screen.Register.route) {
            RegisterScreen(navController)
        }
        composable(Screen.Home.route) {
            HomeScreen()
        }
        composable(Screen.ForgotPassword.route) {
            ForgotPasswordScreen(navController)
        }
    }
}

sealed class Screen(val route: String) {
    object Login : Screen("LoginScreen")
    object Register : Screen("RegisterScreen")
    object Home : Screen("HomeScreen")
    object ForgotPassword : Screen("ForgotPasswordScreen")
}