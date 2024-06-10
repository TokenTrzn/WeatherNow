package com.tokentrzn.weathernow.presentation.screens.auth.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tokentrzn.weathernow.presentation.theme.PrimaryTextColor

@Composable
fun LoginSocial(
    text: String,
    image: Painter,
    onClic: () -> Unit = {}
) {

    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 108.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = image,
            contentDescription = "Social Login", Modifier.size(32.dp)
        )
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = PrimaryTextColor,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .clickable { onClic() }
        )
    }
}