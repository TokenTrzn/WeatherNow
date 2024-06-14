package com.tokentrzn.weathernow.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tokentrzn.weathernow.presentation.screens.auth.forgotpassword.ForgotPasswordScreen
import com.tokentrzn.weathernow.presentation.screens.auth.login.LoginScreen
import com.tokentrzn.weathernow.presentation.screens.auth.register.RegisterScreen
import com.tokentrzn.weathernow.presentation.screens.main.home.HomeScreen
import com.tokentrzn.weathernow.presentation.screens.main.settings.SettingsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(Screen.Register.route) {
            RegisterScreen(navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.ForgotPassword.route) {
            ForgotPasswordScreen(navController)
        }
        composable(Screen.Settings.route) {
            SettingsScreen(navController)
        }
    }
}

sealed class Screen(val route: String) {
    object Login : Screen("LoginScreen")
    object Register : Screen("RegisterScreen")
    object Home : Screen("HomeScreen")
    object ForgotPassword : Screen("ForgotPasswordScreen")

    object Settings : Screen("SettingsScreen")
}