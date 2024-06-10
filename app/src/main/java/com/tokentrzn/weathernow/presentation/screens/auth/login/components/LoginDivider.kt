package com.tokentrzn.weathernow.presentation.screens.auth.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tokentrzn.weathernow.presentation.theme.DividerColor
import com.tokentrzn.weathernow.presentation.theme.PrimaryTextColor

@Composable
fun LoginDivider() {

    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(
            Modifier
                .padding(start = 48.dp)
                .background(DividerColor)
                .weight(1f)
                .height(1.dp)

        )
        Text(
            text = "O",
            Modifier.padding(horizontal = 18.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryTextColor
        )
        Divider(
            Modifier
                .padding(end = 48.dp)
                .background(DividerColor)
                .weight(1f)
                .height(1.dp)

        )
    }
}