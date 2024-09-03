package com.tokentrzn.weathernow.presentation.screens.main.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tokentrzn.weathernow.R
import com.tokentrzn.weathernow.presentation.theme.LinearGradient

@Composable
fun HomeContent() {
    Box(
        modifier = Modifier
            .background(LinearGradient())
            .padding(top = 100.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Tarazona",
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier.padding(6.dp)
            )
            Text(
                text = "28º",
                color = Color.White,
                fontSize = 80.sp,
                modifier = Modifier.padding(6.dp)
            )
            Text(
                text = "Despejado 32º/15º",
                color = Color.White,
                fontSize = 25.sp

            )
            Image(
                painter = painterResource(id = R.drawable.sun_icon),
                contentDescription = "Main Weather Icon",
                modifier = Modifier
                    .padding(25.dp)
                    .size(150.dp)
            )
        }
    }
}