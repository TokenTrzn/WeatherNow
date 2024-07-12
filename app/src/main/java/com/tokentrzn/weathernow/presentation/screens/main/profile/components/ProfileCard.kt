package com.tokentrzn.weathernow.presentation.screens.main.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tokentrzn.weathernow.R
import com.tokentrzn.weathernow.presentation.screens.main.home.components.ForecastRowCard
import com.tokentrzn.weathernow.presentation.screens.main.home.components.TitleForecastCard
import com.tokentrzn.weathernow.presentation.screens.main.profile.ProfileViewModel
import com.tokentrzn.weathernow.presentation.theme.LinearGradient

@Composable
fun ProfileCard() {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Transparent),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(LinearGradient()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.weather_app_icon),
                    contentDescription = "Profile Photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .padding(top = 8.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                ProfileInfoRow(info = "Alberto")
                ProfileInfoRow(info = "a@gmail.com")
                ProfileInfoRow(info = "Tarazona")
            }
        }
    )
}