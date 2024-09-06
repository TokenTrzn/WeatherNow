package com.tokentrzn.weathernow.domain.use_cases.authentication

import com.tokentrzn.weathernow.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUserUid @Inject constructor(private val repository: AuthRepository){
    operator fun invoke(): String? {
        return repository.currentUser?.uid
    }
}