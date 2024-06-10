package com.tokentrzn.weathernow.domain.model

data class City(
    val id: Int,
    val name: String,
    val country: String,
    val coord: Coord
)
