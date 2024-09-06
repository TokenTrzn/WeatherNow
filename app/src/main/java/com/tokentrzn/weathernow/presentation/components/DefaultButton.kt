package com.tokentrzn.weathernow.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import com.tokentrzn.weathernow.presentation.theme.LightPrimaryColor
import com.tokentrzn.weathernow.presentation.theme.PrimaryColor
import com.tokentrzn.weathernow.presentation.theme.PrimaryTextColor

@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    color: Color = PrimaryColor,
    enabled: Boolean = true,
    icon: ImageVector? = null
) {

    Button(
        modifier = modifier,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryColor,
            disabledContainerColor = LightPrimaryColor,
            disabledContentColor = Color.White
        ),
        enabled = enabled
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Logout icon",
                    tint = PrimaryTextColor
                )
            }
            Text(
                text = text,
                color = PrimaryTextColor,
                fontWeight = FontWeight.Bold
            )
        }

    }

}