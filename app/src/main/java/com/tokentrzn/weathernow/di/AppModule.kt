package com.tokentrzn.weathernow.di

import com.google.firebase.auth.FirebaseAuth
import com.tokentrzn.weathernow.data.api.APIClient
import com.tokentrzn.weathernow.data.repository.AuthRepositoryImpl
import com.tokentrzn.weathernow.domain.repository.AuthRepository
import com.tokentrzn.weathernow.domain.repository.WeatherRepository
import com.tokentrzn.weathernow.domain.use_cases.authentication.AuthUseCases
import com.tokentrzn.weathernow.domain.use_cases.authentication.GetCurrentUser
import com.tokentrzn.weathernow.domain.use_cases.authentication.Login
import com.tokentrzn.weathernow.domain.use_cases.authentication.Register
import com.tokentrzn.weathernow.domain.use_cases.weather.GetCurrentWeather
import com.tokentrzn.weathernow.domain.use_cases.weather.GetWeatherUseCase
import com.tokentrzn.weathernow.domain.use_cases.weather.WeatherUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

object AppModule {
    @InstallIn(SingletonComponent::class)
    @Module
    object AppModule {

        // FIREBASE
        @Provides
        fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

        //REPOSITORIES
        @Provides
        fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

        // USECASES
        @Provides
        fun provideAuthUseCases(repository: AuthRepository) = AuthUseCases(
            getCurrentUser = GetCurrentUser(repository),
            login = Login(repository),
            register = Register(repository),
        )

        @Provides
        fun provideWeatherRepository(repository: WeatherRepository) = WeatherUseCases(
            getCurrentWeather = GetCurrentWeather(repository),
            getWeatherUseCase = GetWeatherUseCase(repository),
        )

        //PROVIDE RETROFIT
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

        @Provides
        @Singleton
        fun provideGetCurrentWeather(repository: WeatherRepository): GetCurrentWeather {
            return GetCurrentWeather(repository)
        }
    }
}