package com.tokentrzn.weathernow.domain.use_cases.authentication

import com.tokentrzn.weathernow.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUser @Inject constructor(private val authRepository: AuthRepository){
    operator fun invoke() = authRepository.currentUser
}