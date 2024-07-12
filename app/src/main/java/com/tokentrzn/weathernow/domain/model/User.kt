package com.tokentrzn.weathernow.domain.model

data class User(
    val id: String,
    val name: String,
    val email: String,
    val city: String,
    val favoriteCities: List<String> = emptyList()
)
