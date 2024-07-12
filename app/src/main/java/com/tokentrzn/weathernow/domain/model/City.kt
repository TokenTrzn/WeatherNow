package com.tokentrzn.weathernow.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class City(
    val id: Int,
    val name: String,
    val state: String,
    val country: String,
    val lon: Double,
    val lat: Double
)
