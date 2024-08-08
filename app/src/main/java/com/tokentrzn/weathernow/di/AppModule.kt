package com.tokentrzn.weathernow.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.tokentrzn.weathernow.BuildConfig.OPENWEATHERMAP_API_KEY
import com.tokentrzn.weathernow.data.api.APIClient
import com.tokentrzn.weathernow.data.repository.AuthRepositoryImpl
import com.tokentrzn.weathernow.data.repository.WeatherRepositoryImpl
import com.tokentrzn.weathernow.domain.repository.AuthRepository
import com.tokentrzn.weathernow.domain.repository.WeatherRepository
import com.tokentrzn.weathernow.domain.use_cases.authentication.AuthUseCases
import com.tokentrzn.weathernow.domain.use_cases.authentication.GetCurrentUser
import com.tokentrzn.weathernow.domain.use_cases.authentication.GetCurrentUserUid
import com.tokentrzn.weathernow.domain.use_cases.authentication.LogOut
import com.tokentrzn.weathernow.domain.use_cases.authentication.Login
import com.tokentrzn.weathernow.domain.use_cases.authentication.Register
import com.tokentrzn.weathernow.domain.use_cases.authentication.SendPasswordResetEmail
import com.tokentrzn.weathernow.domain.use_cases.weather.GetCurrentWeather
import com.tokentrzn.weathernow.domain.use_cases.weather.GetWeatherUseCase
import com.tokentrzn.weathernow.domain.use_cases.weather.WeatherUseCases
import com.tokentrzn.weathernow.presentation.screens.main.profile.ProfileViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    /*
    // FIREBASE
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    //REPOSITORIES
    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideWeatherRepository(apiClient: APIClient): WeatherRepository {
        return WeatherRepositoryImpl(apiClient)
    }

    // USECASES
    @Provides
    fun provideAuthUseCases(repository: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository),
        register = Register(repository),
        sendPasswordResetEmail = SendPasswordResetEmail(repository)
    )

    @Provides
    fun provideWeatherUseCases(repository: WeatherRepository) = WeatherUseCases(
        getCurrentWeather = GetCurrentWeather(repository),
        getWeatherUseCase = GetWeatherUseCase(repository),
    )

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherApiService(retrofit: Retrofit): APIClient {
        return retrofit.create(APIClient::class.java)
    }
     */
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

    @Provides
    fun provideWeatherRepository(apiClient: APIClient): WeatherRepository {
        return WeatherRepositoryImpl(apiClient)
    }

    // UseCases
    @Provides
    fun provideAuthUseCases(repository: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        getCurrentUserUid = GetCurrentUserUid(repository),
        login = Login(repository),
        register = Register(repository),
        sendPasswordResetEmail = SendPasswordResetEmail(repository),
        logOut = LogOut(repository)
    )

    @Provides
    fun provideWeatherUseCases(repository: WeatherRepository): WeatherUseCases {
        return WeatherUseCases(
            getCurrentWeather = GetCurrentWeather(repository),
            getWeatherUseCase = GetWeatherUseCase(repository)
        )
    }
}