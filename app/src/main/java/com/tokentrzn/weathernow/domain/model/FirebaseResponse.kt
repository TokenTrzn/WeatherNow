package com.tokentrzn.weathernow.domain.model

sealed class FirebaseResponse<out T> {
    object Loading: FirebaseResponse<Nothing>()
    data class Success <out T>(val data: T?): FirebaseResponse<T>()
    data class Error <out T>(val exception: String?): FirebaseResponse<T>()
}
