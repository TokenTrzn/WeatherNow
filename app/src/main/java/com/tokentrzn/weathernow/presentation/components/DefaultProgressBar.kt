package com.tokentrzn.weathernow.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tokentrzn.weathernow.presentation.theme.DarkPrimaryColor

@Composable
fun DefaultProgressBar(){
    Box( contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        CircularProgressIndicator(color = DarkPrimaryColor)
    }
}