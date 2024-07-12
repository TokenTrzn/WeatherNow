package com.tokentrzn.weathernow.presentation.screens.main.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tokentrzn.weathernow.presentation.screens.main.search.components.SearchContent
import com.tokentrzn.weathernow.presentation.screens.main.search.components.SearchTopBar
import com.tokentrzn.weathernow.presentation.theme.LinearGradient

@Composable
fun SearchScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LinearGradient())
    ){
        Scaffold(
            topBar = { SearchTopBar(navController) },
            containerColor = Transparent
        ){
                contentPadding ->
            Box(modifier = Modifier
                .padding(contentPadding)) { SearchContent() }
        }
    }
}