package com.tokentrzn.weathernow.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tokentrzn.weathernow.presentation.theme.PrimaryTextColor
import com.tokentrzn.weathernow.presentation.theme.TextIconsColor

@Composable
fun HomeTopBar() {
    Box(modifier = Modifier.fillMaxWidth().background(PrimaryTextColor), Alignment.TopStart) {
        Icon(
            imageVector = Icons.Filled.Menu,
            contentDescription = "Menu",
            modifier = Modifier
                .clickable {  }
                .padding(4.dp),
            tint = TextIconsColor
        )
    }
    Box(modifier = Modifier.fillMaxWidth().background(PrimaryTextColor), Alignment.TopEnd) {
        Icon(
            imageVector = Icons.Filled.Settings,
            contentDescription = "Settings",
            modifier = Modifier
                .clickable {  }
                .padding(4.dp),
            tint = TextIconsColor
        )
    }
}