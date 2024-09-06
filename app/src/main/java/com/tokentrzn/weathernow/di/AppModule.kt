package com.tokentrzn.weathernow.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.tokentrzn.weathernow.data.api.APIClient
import com.tokentrzn.weathernow.data.repository.AuthRepositoryImpl
import com.tokentrzn.weathernow.domain.repository.AuthRepository
import com.tokentrzn.weathernow.domain.use_cases.authentication.AuthUseCases
import com.tokentrzn.weathernow.domain.use_cases.authentication.GetCurrentUser
import com.tokentrzn.weathernow.domain.use_cases.authentication.GetCurrentUserUid
import com.tokentrzn.weathernow.domain.use_cases.authentication.LogOut
import com.tokentrzn.weathernow.domain.use_cases.authentication.Login
import com.tokentrzn.weathernow.domain.use_cases.authentication.LoginWithGoogle
import com.tokentrzn.weathernow.domain.use_cases.authentication.Register
import com.tokentrzn.weathernow.domain.use_cases.authentication.SendPasswordResetEmail
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

// Firebase

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirestore(): FirebaseFirestore = FirebaseFirestore.getInstance()

    // Repositories
    @Provides
    @Singleton
    fun provideAuthRepository(firebaseAuth: FirebaseAuth): AuthRepository {
        return AuthRepositoryImpl(firebaseAuth)
    }

    // UseCases
    @Provides
    fun provideAuthUseCases(repository: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        getCurrentUserUid = GetCurrentUserUid(repository),
        login = Login(repository),
        register = Register(repository),
        sendPasswordResetEmail = SendPasswordResetEmail(repository),
        logOut = LogOut(repository),
        loginWithGoogle = LoginWithGoogle(repository)
    )

    @Provides
    @Singleton
    fun provideAPIClient(): APIClient {
        return APIClient.create()
    }
}