package com.tokentrzn.weathernow.presentation.screens.main.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tokentrzn.weathernow.R
import com.tokentrzn.weathernow.presentation.theme.DarkTransparentColor

@Composable
fun HomeForecastCard() {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = DarkTransparentColor),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                TitleForecastCard()
                ForecastRowCard(icon = R.drawable.sun_icon)
                ForecastRowCard(icon = R.drawable.storm_icon)
                ForecastRowCard(icon = R.drawable.snow_icon)
            }
        }
    )
}

@Composable
fun TitleForecastCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier
                .padding(end = 8.dp, top = 12.dp)
                .size(32.dp),
            imageVector = Icons.Default.CalendarMonth,
            contentDescription = "Calendar",
            tint = Color.White
        )

        Text(
            modifier = Modifier
                .padding(end = 120.dp),
            text = "Pronóstico de 5 días",
            textAlign = TextAlign.Start,
            color = Color.White,
            fontSize = 12.sp
        )

        Text(
            modifier = Modifier,
            text = "Más detalles",
            textAlign = TextAlign.End,
            color = Color.White,
            fontSize = 10.sp
        )
        Icon(
            modifier = Modifier
                .size(10.dp),
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "More Details",
            tint = Color.White
        )
    }
}

@Composable
fun ForecastRowCard(icon: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "Weather Icon",
            modifier = Modifier
                .padding(end = 8.dp)
        )

        Text(
            modifier = Modifier
                .padding(end = 120.dp),
            text = "Pronóstico de 5 días",
            textAlign = TextAlign.Start,
            color = Color.White,
            fontSize = 12.sp
        )

        Text(
            modifier = Modifier,
            text = "Más detalles",
            textAlign = TextAlign.End,
            color = Color.White,
            fontSize = 10.sp
        )
        Icon(
            modifier = Modifier
                .size(10.dp),
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "More Details",
            tint = Color.White
        )
    }
}