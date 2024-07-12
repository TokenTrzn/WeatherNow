package com.tokentrzn.weathernow.presentation.screens.main.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.tokentrzn.weathernow.presentation.screens.main.profile.components.ProfileContent
import com.tokentrzn.weathernow.presentation.screens.main.profile.components.ProfileTopBar

@Composable
fun ProfileScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ){
        Scaffold (
            topBar = { ProfileTopBar(navController) }
        ){
                contentPadding ->
            Box(modifier = Modifier
                .padding(contentPadding)) { ProfileContent(navController) }
        }
    }
}

