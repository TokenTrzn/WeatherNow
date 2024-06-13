package com.tokentrzn.weathernow.di

import com.google.firebase.auth.FirebaseAuth
import com.tokentrzn.weathernow.BuildConfig.OPENWEATHERMAP_API_KEY
import com.tokentrzn.weathernow.data.api.APIClient
import com.tokentrzn.weathernow.data.repository.AuthRepositoryImpl
import com.tokentrzn.weathernow.data.repository.WeatherRepositoryImpl
import com.tokentrzn.weathernow.domain.repository.AuthRepository
import com.tokentrzn.weathernow.domain.repository.WeatherRepository
import com.tokentrzn.weathernow.domain.use_cases.authentication.AuthUseCases
import com.tokentrzn.weathernow.domain.use_cases.authentication.GetCurrentUser
import com.tokentrzn.weathernow.domain.use_cases.authentication.Login
import com.tokentrzn.weathernow.domain.use_cases.authentication.Register
import com.tokentrzn.weathernow.domain.use_cases.authentication.SendPasswordResetEmail
import com.tokentrzn.weathernow.domain.use_cases.weather.GetCurrentWeather
import com.tokentrzn.weathernow.domain.use_cases.weather.GetWeatherUseCase
import com.tokentrzn.weathernow.domain.use_cases.weather.WeatherUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    // Repositories
    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideWeatherRepository(apiClient: APIClient): WeatherRepository {
        return WeatherRepositoryImpl(apiClient)
    }

    // UseCases
    @Provides
    fun provideAuthUseCases(repository: AuthRepository): AuthUseCases {
        return AuthUseCases(
            getCurrentUser = GetCurrentUser(repository),
            login = Login(repository),
            register = Register(repository),
            sendPasswordResetEmail = SendPasswordResetEmail(repository)
        )
    }

    @Provides
    fun provideWeatherUseCases(repository: WeatherRepository): WeatherUseCases {
        return WeatherUseCases(
            getCurrentWeather = GetCurrentWeather(repository),
            getWeatherUseCase = GetWeatherUseCase(repository)
        )
    }

    // Retrofit
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = Interceptor { chain ->
            val originalRequest = chain.request()
            val originalHttpUrl = originalRequest.url()

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("units", "metric")
                .addQueryParameter("appid", OPENWEATHERMAP_API_KEY)
                .build()

            val requestBuilder = originalRequest.newBuilder()
                .url(url)

            val request = requestBuilder.build()
            chain.proceed(request)
        }

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherApiService(retrofit: Retrofit): APIClient {
        return retrofit.create(APIClient::class.java)
    }
}