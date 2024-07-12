package com.tokentrzn.weathernow.presentation.screens.main.search.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tokentrzn.weathernow.domain.model.City
import com.tokentrzn.weathernow.presentation.screens.main.search.SearchViewModel
import com.tokentrzn.weathernow.presentation.theme.LinearGradient
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Composable
fun SearchContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LinearGradient()),
        verticalArrangement = Arrangement.Top
    ) {
        SearchBar()
    }
}