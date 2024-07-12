package com.tokentrzn.weathernow.domain.use_cases.authentication

import com.google.firebase.auth.FirebaseUser
import com.tokentrzn.weathernow.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUser @Inject constructor(private val repository: AuthRepository){
    operator fun invoke(): FirebaseUser? {
        return repository.currentUser
    }
}