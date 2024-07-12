package com.tokentrzn.weathernow.presentation.screens.main.search

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.tokentrzn.weathernow.data.api.APIClient
import com.tokentrzn.weathernow.domain.model.City
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.io.InputStreamReader
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val apiClient: APIClient): ViewModel() {

    private val _cities = mutableStateOf<List<City>>(emptyList())
    val cities: State<List<City>> = _cities

    private val _searchResults = mutableStateOf<List<City>>(emptyList())
    val searchResults: State<List<City>> = _searchResults

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    /*
    fun loadCities(context: Context): List<City> {
        val inputStream = context.assets.open("cities.json")
        val reader = InputStreamReader(inputStream)
        val cityType = object : TypeToken<List<City>>() {}.type
        return Gson().fromJson(reader, cityType)
    }
     */

}