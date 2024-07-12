package com.tokentrzn.weathernow.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

// MY COLORS

val DarkPrimaryColor = Color(0xFF1976D2)
val LightPrimaryColor = Color(0xFFBBDEFB)
val PrimaryColor = Color(0xFF2196F3)
val TextIconsColor = Color(0xFFFFFFFF)
val AccentColor = Color(0xFF03A9F4)
val PrimaryTextColor = Color(0xFF212121)
val SecondaryTextColor = Color(0xFF757575)
val DividerColor = Color(0xFFBDBDBD)
val DarkTransparentColor = Color(0x88000000)
val LightTransparentColor = Color(0x55000000)

@Composable
fun LinearGradient(): Brush {
    return linearGradient(
        colors = listOf(
            DarkPrimaryColor,
            LightPrimaryColor
        )
    )
}

@Composable
fun DarkLinearGradient(): Brush {
    return linearGradient(
        colors = listOf(
            DarkPrimaryColor,
            AccentColor
        )
    )
}