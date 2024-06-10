package com.tokentrzn.weathernow.data.repository

import com.tokentrzn.weathernow.domain.model.FirebaseResponse
import com.tokentrzn.weathernow.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(private val firebaseAuth: FirebaseAuth): AuthRepository {

    override val currentUser: FirebaseUser? get() = firebaseAuth.currentUser

    override suspend fun login(email: String, password: String): FirebaseResponse<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            FirebaseResponse.Success(result.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            FirebaseResponse.Error(e)
        }
    }

    /*
override suspend fun register(name: String, city: String, email: String, password: String, confirmPassword: String): FirebaseResponse<FirebaseUser> {
    return
}
 */
}
