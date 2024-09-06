package com.tokentrzn.weathernow.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.tokentrzn.weathernow.domain.model.FirebaseResponse

interface AuthRepository {
    val currentUser : FirebaseUser?
    suspend fun login(email:String, password :String) : FirebaseResponse<FirebaseUser>
    suspend fun register(email: String, password: String): FirebaseResponse<FirebaseUser>
    suspend fun sendPasswordResetEmail(email: String): FirebaseResponse<FirebaseUser>
    suspend fun loginWithGoogle(idToken: String): FirebaseResponse<FirebaseUser>
    suspend fun logout()
}