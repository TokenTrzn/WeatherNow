package com.tokentrzn.weathernow.presentation.screens.main.settings.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tokentrzn.weathernow.R

@Composable
fun SettingToggleButton(title: String) {
    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontSize = 20.sp
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "ON")

            IconToggleButton(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                },
                modifier = Modifier
                    .padding(16.dp)
                    .size(70.dp)
            ) {
                if (isChecked) {
                    Icon(
                        painter = painterResource(id = R.drawable.toggle_button_on),
                        contentDescription = "Checked Icon",
                        modifier = Modifier
                            .size(300.dp),
                        tint = Color.Black
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.toggle_button_off),
                        contentDescription = "Unchecked Icon",
                        modifier = Modifier
                            .size(300.dp),
                        tint = Color.Black
                    )
                }
            }

            Text(text = "OFF")
        }
    }
}