package com.tokentrzn.weathernow.domain.use_cases.authentication

import com.google.firebase.auth.FirebaseUser
import com.tokentrzn.weathernow.domain.model.FirebaseResponse
import com.tokentrzn.weathernow.domain.repository.AuthRepository

class LoginWithGoogle (private val repository: AuthRepository) {
    suspend operator fun invoke(idToken: String): FirebaseResponse<FirebaseUser> {
        return repository.loginWithGoogle(idToken)
    }
}