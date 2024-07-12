package com.tokentrzn.weathernow.domain.use_cases.authentication

import com.tokentrzn.weathernow.domain.repository.AuthRepository
import com.tokentrzn.weathernow.domain.repository.UsersRepository
import javax.inject.Inject

class LogOut @Inject constructor(private val repository: AuthRepository) {
/*
suspend operator fun invoke() {
        repository.logout()
    }
 */

}