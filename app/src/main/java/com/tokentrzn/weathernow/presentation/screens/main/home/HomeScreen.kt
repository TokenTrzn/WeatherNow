package com.tokentrzn.weathernow.presentation.screens.main.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.tokentrzn.weathernow.presentation.screens.main.home.components.HomeBottomBar
import com.tokentrzn.weathernow.presentation.screens.main.home.components.HomeContent
import com.tokentrzn.weathernow.presentation.screens.main.home.components.HomeContentPreview
import com.tokentrzn.weathernow.presentation.screens.main.home.components.HomeTopBar
import com.tokentrzn.weathernow.presentation.theme.LinearGradient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LinearGradient())
    ){
        Scaffold (
            containerColor = Color.Transparent,
            topBar = { HomeTopBar(navController) },
            bottomBar = { HomeBottomBar() }
        ){
                contentPadding ->
            // Screen content
            Box(modifier = Modifier
                .padding(contentPadding)) { HomeContentPreview() }
        }
    }
}