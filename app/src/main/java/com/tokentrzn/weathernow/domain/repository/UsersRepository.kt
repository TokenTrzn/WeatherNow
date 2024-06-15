package com.tokentrzn.weathernow.domain.repository

interface UsersRepository {
    suspend fun switchToggleButton(isActivated: Boolean): Boolean
}