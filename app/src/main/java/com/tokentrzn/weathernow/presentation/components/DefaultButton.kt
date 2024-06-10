package com.tokentrzn.weathernow.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.tokentrzn.weathernow.presentation.theme.LightPrimaryColor
import com.tokentrzn.weathernow.presentation.theme.PrimaryColor
import com.tokentrzn.weathernow.presentation.theme.PrimaryTextColor

@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    color: Color = PrimaryColor,
    icon: ImageVector = Icons.AutoMirrored.Filled.ArrowForward,
    enabled: Boolean = true
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
        Icon(
            imageVector = icon,
            contentDescription = "Icon Button",
            tint = PrimaryTextColor
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            color = PrimaryTextColor
        )
    }

}