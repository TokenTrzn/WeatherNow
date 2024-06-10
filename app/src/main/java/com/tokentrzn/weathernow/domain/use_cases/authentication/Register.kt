package com.tokentrzn.weathernow.domain.use_cases.authentication

import com.tokentrzn.weathernow.domain.repository.AuthRepository
import javax.inject.Inject

class Register @Inject constructor(private val repository: AuthRepository){
    //suspend operator fun invoke (name: String, city: String, email: String, password: String, confirmPassword: String) = repository.register(name, city, email, password, confirmPassword)
}