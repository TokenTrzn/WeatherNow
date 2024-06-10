package com.tokentrzn.weathernow.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.tokentrzn.weathernow.domain.model.FirebaseResponse

interface AuthRepository {
    val currentUser : FirebaseUser?
    suspend fun login(email:String, password :String) : FirebaseResponse<FirebaseUser>
    //suspend fun register(name: String, city: String, email: String, password: String, confirmPassword: String) : FirebaseResponse<FirebaseUser>
}