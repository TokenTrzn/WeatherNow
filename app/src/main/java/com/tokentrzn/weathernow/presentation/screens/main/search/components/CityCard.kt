package com.tokentrzn.weathernow.presentation.screens.main.search.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tokentrzn.weathernow.R
import com.tokentrzn.weathernow.presentation.theme.DarkLinearGradient
import com.tokentrzn.weathernow.presentation.theme.DarkTransparentColor
import com.tokentrzn.weathernow.presentation.theme.LinearGradient

@Composable
fun CityCard(cityName: String) {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        content = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DarkTransparentColor)
                    .height(80.dp)
                ,
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(6.dp),
                    painter = painterResource(id = R.drawable.sun_icon),
                    contentDescription = ""
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = cityName,
                        fontSize = 18.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(2.dp)
                    )
                    Text(
                        text = "15º / 33º",
                        fontSize = 12.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(2.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "32º",
                        fontSize = 24.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(10.dp)
                    )
                }
            }
        }
    )
}