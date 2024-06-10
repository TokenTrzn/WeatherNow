package com.tokentrzn.weathernow.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.tokentrzn.weathernow.presentation.screens.home.components.HomeBottomBar
import com.tokentrzn.weathernow.presentation.screens.home.components.HomeContent
import com.tokentrzn.weathernow.presentation.screens.home.components.HomeTopBar
import com.tokentrzn.weathernow.presentation.theme.LinearGradient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LinearGradient())
    ){
        Scaffold (
            containerColor = Color.Transparent,
            topBar = { HomeTopBar() },
            bottomBar = { HomeBottomBar() }
        ){
                contentPadding ->
            // Screen content
            Box(modifier = Modifier
                .padding(contentPadding)) { HomeContent() }
        }
    }
}