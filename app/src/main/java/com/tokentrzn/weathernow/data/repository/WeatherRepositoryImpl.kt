package com.tokentrzn.weathernow.data.repository

import com.tokentrzn.weathernow.data.api.APIClient
import com.tokentrzn.weathernow.data.model.toWeather
import com.tokentrzn.weathernow.domain.model.Weather
import com.tokentrzn.weathernow.domain.repository.WeatherRepository
import com.tokentrzn.weathernow.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: APIClient,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : WeatherRepository {
    override fun getWeatherForecast(city: String): Flow<Result<Weather>> = flow {
        emit(Result.Loading)
        try {
            val result = weatherApi.getWeatherForecast(city = city).toWeather()
            emit(Result.Success(result))
        } catch (exception: HttpException) {
            emit(Result.Error(exception.message.orEmpty()))
        } catch (exception: IOException) {
            emit(Result.Error("Please check your network connection and try again!"))
        }
    }.flowOn(dispatcher)
}
