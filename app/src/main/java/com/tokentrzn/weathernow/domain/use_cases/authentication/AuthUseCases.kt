package com.tokentrzn.weathernow.domain.use_cases.authentication

data class AuthUseCases(
    val getCurrentUser: GetCurrentUser,
    val login: Login,
    val register: Register
)
