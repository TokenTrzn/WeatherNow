package com.tokentrzn.weathernow.presentation.screens.auth.register

data class RegisterState(
    val name: String = "",
    val city: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)
