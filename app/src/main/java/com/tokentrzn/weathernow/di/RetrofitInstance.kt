package com.tokentrzn.weathernow.di

import com.tokentrzn.weathernow.data.api.APIClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: APIClient by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIClient::class.java)
    }
}