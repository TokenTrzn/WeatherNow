package com.tokentrzn.weathernow.domain.repository

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser
import com.tokentrzn.weathernow.domain.model.FirebaseResponse
import com.tokentrzn.weathernow.domain.model.User

interface AuthRepository {
    val currentUser : FirebaseUser?
    suspend fun login(email:String, password :String) : FirebaseResponse<FirebaseUser>
    suspend fun register(email: String, password: String): FirebaseResponse<FirebaseUser>
    suspend fun sendPasswordResetEmail(email: String): FirebaseResponse<FirebaseUser>
    suspend fun loginWithGoogle(credential: AuthCredential): FirebaseResponse<FirebaseUser>
    //suspend fun logout()
}