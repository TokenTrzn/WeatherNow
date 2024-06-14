package com.tokentrzn.weathernow.presentation.screens.main.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.tokentrzn.weathernow.presentation.screens.main.home.components.HomeBottomBar
import com.tokentrzn.weathernow.presentation.screens.main.home.components.HomeContentPreview
import com.tokentrzn.weathernow.presentation.screens.main.home.components.HomeTopBar
import com.tokentrzn.weathernow.presentation.screens.main.settings.components.SettingsContent
import com.tokentrzn.weathernow.presentation.screens.main.settings.components.SettingsTopBar
import com.tokentrzn.weathernow.presentation.theme.LinearGradient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Scaffold (
            topBar = { SettingsTopBar(navController) }
        ){
                contentPadding ->
            Box(modifier = Modifier
                .padding(contentPadding)) { SettingsContent() }
        }
    }
}