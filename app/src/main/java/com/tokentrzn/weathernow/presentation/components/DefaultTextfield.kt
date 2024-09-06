package com.tokentrzn.weathernow.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tokentrzn.weathernow.presentation.theme.PrimaryTextColor


@Composable
fun DefaultTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (value: String) -> Unit,
    validateField: () -> Unit = {},
    label: String,
    icon: ImageVector,
    keyboardType: KeyboardType = KeyboardType.Text,
    hideText: Boolean = false,
    errorMsg: String = "",
    enabled: Boolean = true,
    readOnly: Boolean = false,
    keyboardOptions: KeyboardOptions,

    ) {

    Column() {
        OutlinedTextField(
            modifier = modifier,
            value = value,
            onValueChange = {
                onValueChange(it)
                validateField()
            },
            singleLine = true,
            keyboardOptions = keyboardOptions,
            label = {
                Text(
                    text = label,
                    color = PrimaryTextColor,
                    modifier = Modifier.background(Color.Transparent)
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                    tint = PrimaryTextColor

                )
            },
            visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = PrimaryTextColor,
                unfocusedTextColor = PrimaryTextColor,
                focusedBorderColor = PrimaryTextColor,
                unfocusedBorderColor = PrimaryTextColor,
                focusedPlaceholderColor = PrimaryTextColor,
                unfocusedPlaceholderColor = PrimaryTextColor,
                disabledPlaceholderColor = PrimaryTextColor
            ),
            enabled = enabled,
            readOnly = readOnly
        )
        Text(
            modifier = Modifier.padding(top = 2.dp),
            text = errorMsg,
            fontSize = 10.sp,
            color = Color.Red
        )
    }
}