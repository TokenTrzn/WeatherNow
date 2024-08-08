package com.tokentrzn.weathernow.di

import com.google.gson.GsonBuilder
import com.tokentrzn.weathernow.BuildConfig
import com.tokentrzn.weathernow.data.api.APIClient
import com.tokentrzn.weathernow.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        return if (BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(httpLoggingInterceptor).build()
        } else {
            okHttpClient.build()
        }
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideWeatherApi(retrofit: Retrofit): APIClient = retrofit
        .create(APIClient::class.java)

}
