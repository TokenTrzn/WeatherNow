package com.tokentrzn.weathernow.domain.use_cases.authentication

data class AuthUseCases(
    val getCurrentUser: GetCurrentUser,
    val getCurrentUserUid: GetCurrentUserUid,
    val login: Login,
    val register: Register,
    val sendPasswordResetEmail: SendPasswordResetEmail,
    val logOut: LogOut,
    val loginWithGoogle: LoginWithGoogle
)
