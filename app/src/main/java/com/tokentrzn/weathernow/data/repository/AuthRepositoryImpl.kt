package com.tokentrzn.weathernow.data.repository

import com.tokentrzn.weathernow.domain.model.FirebaseResponse
import com.tokentrzn.weathernow.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(private val firebaseAuth: FirebaseAuth): AuthRepository {

    override val currentUser: FirebaseUser? get() = firebaseAuth.currentUser

    override suspend fun login(email: String, password: String): FirebaseResponse<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            val user = result.user
            if (user != null) {
                FirebaseResponse.Success(user)
            } else {
                FirebaseResponse.Error("User is null")
            }
        } catch (e: Exception) {
            FirebaseResponse.Error(e.message ?: "An unknown error occurred")
        }
    }


    override suspend fun register(email: String, password: String): FirebaseResponse<FirebaseUser> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val user = result.user ?: throw Exception("Usuario no creado correctamente")
            FirebaseResponse.Success(user)
        } catch (e: Exception) {
            FirebaseResponse.Error("Error al registrar usuario: ${e.message}")
        }
    }

    override suspend fun sendPasswordResetEmail(email: String): FirebaseResponse<FirebaseUser> {
        return try {
            firebaseAuth.sendPasswordResetEmail(email).await()
            FirebaseResponse.Success(firebaseAuth.currentUser!!)
        } catch (e: Exception) {
            FirebaseResponse.Error("Error al enviar email para restablecer contraseña: ${e.message}")
        }
    }

}
