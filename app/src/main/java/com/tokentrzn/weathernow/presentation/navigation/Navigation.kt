package com.tokentrzn.weathernow.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tokentrzn.weathernow.presentation.screens.auth.forgotpassword.ForgotPasswordScreen
import com.tokentrzn.weathernow.presentation.screens.auth.login.LoginScreen
import com.tokentrzn.weathernow.presentation.screens.auth.register.RegisterScreen
import com.tokentrzn.weathernow.presentation.screens.main.settings.SettingsScreen
import com.tokentrzn.weathernow.presentation.screens.main.weather.WeatherScreen
@RequiresApi(Build.VERSION_CODES.O)
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
        composable(Screen.Weather.route) {
            WeatherScreen(navController)
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
    object Weather : Screen("WeatherScreen")
    object ForgotPassword : Screen("ForgotPasswordScreen")
    object Settings : Screen("SettingsScreen")

}