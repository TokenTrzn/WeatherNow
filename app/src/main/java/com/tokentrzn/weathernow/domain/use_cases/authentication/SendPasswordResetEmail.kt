package com.tokentrzn.weathernow.domain.use_cases.authentication

import com.google.firebase.auth.FirebaseUser
import com.tokentrzn.weathernow.domain.model.FirebaseResponse
import com.tokentrzn.weathernow.domain.repository.AuthRepository
import javax.inject.Inject

class SendPasswordResetEmail @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String): FirebaseResponse<FirebaseUser?> {
        return repository.sendPasswordResetEmail(email)
    }}