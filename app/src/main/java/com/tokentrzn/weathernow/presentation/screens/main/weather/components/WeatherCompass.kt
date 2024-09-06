package com.tokentrzn.weathernow.presentation.screens.main.weather.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tokentrzn.weathernow.R
import com.tokentrzn.weathernow.presentation.theme.PrimaryTextColor

@Composable
fun WeatherCompass(windDirectionDegrees: Int) {

    Box(
        modifier = Modifier
            .size(50.dp)
            .background(
                color = Color.Transparent,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .border(
                    width = 1.dp,
                    color = PrimaryTextColor,
                    shape = CircleShape
                )
                .align(Alignment.Center)
        )
        Text("N", modifier = Modifier.padding(bottom = 30.dp), fontSize = 8.sp, fontWeight = FontWeight.Bold, color = PrimaryTextColor)
        Text("S", modifier = Modifier.padding(top = 30.dp), fontSize = 8.sp, fontWeight = FontWeight.Bold, color = PrimaryTextColor)
        Text("E", modifier = Modifier.padding(end = 30.dp), fontSize = 8.sp, fontWeight = FontWeight.Bold, color = PrimaryTextColor)
        Text("O", modifier = Modifier.padding(start = 30.dp), fontSize = 8.sp, fontWeight = FontWeight.Bold, color = PrimaryTextColor)

        Icon(
            painter = painterResource(id = R.drawable.arrow_upward_icon),
            contentDescription = "Wind Direction",
            modifier = Modifier
                .size(20.dp)
                .graphicsLayer(rotationZ = windDirectionDegrees.toFloat())
                .align(Alignment.Center),
            tint = PrimaryTextColor
        )


    }

}