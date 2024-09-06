package com.tokentrzn.weathernow.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.tokentrzn.weathernow.domain.model.FirebaseResponse
import com.tokentrzn.weathernow.domain.repository.AuthRepository
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


    override suspend fun loginWithGoogle(idToken: String): FirebaseResponse<FirebaseUser> {
        return try {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            val authResult = firebaseAuth.signInWithCredential(credential).await()
            FirebaseResponse.Success(authResult.user!!)
        } catch (e: Exception) {
            FirebaseResponse.Error(e)
        }
    }



    override suspend fun register(email: String, password: String): FirebaseResponse<FirebaseUser> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            FirebaseResponse.Success(result.user!!)

        } catch (e: Exception) {
            e.printStackTrace()
            FirebaseResponse.Error(e)
        }
    }


    override suspend fun sendPasswordResetEmail(email: String): FirebaseResponse<FirebaseUser> {
        return try {
            firebaseAuth.sendPasswordResetEmail(email).await()
            FirebaseResponse.Success(firebaseAuth.currentUser!!)
        } catch (e: Exception) {
            FirebaseResponse.Error(e)
        }
    }

    override suspend fun logout() {
        firebaseAuth.signOut()
    }

}
