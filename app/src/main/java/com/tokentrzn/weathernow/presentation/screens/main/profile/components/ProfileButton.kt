package com.tokentrzn.weathernow.presentation.screens.main.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tokentrzn.weathernow.presentation.navigation.Screen
import com.tokentrzn.weathernow.presentation.screens.main.home.HomeViewModel
import com.tokentrzn.weathernow.presentation.screens.main.profile.ProfileViewModel

@Composable
fun ProfileButton(navController: NavController, route: String, icon: ImageVector, text: String, viewModel: HomeViewModel = hiltViewModel()) {
    Button(
        onClick = {
            //viewModel.logout()
            navController.navigate(Screen.Login.route)
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 8.dp, top = 12.dp)
                    .size(32.dp),
                imageVector = icon,
                contentDescription = "Icon",
                tint = Color.White
            )

            Text(
                modifier = Modifier
                    .padding(top = 8.dp),
                text = text,
                textAlign = TextAlign.Start,
                color = Color.White,
                fontSize = 12.sp
            )
        }
    }
}