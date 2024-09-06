package com.tokentrzn.weathernow.presentation.screens.main.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tokentrzn.weathernow.presentation.components.DefaultButton
import com.tokentrzn.weathernow.presentation.navigation.Screen
import com.tokentrzn.weathernow.presentation.theme.PrimaryColor

@Composable
fun SettingsScreen(navController: NavController, viewModel: SettingsViewModel = hiltViewModel()) {

    val units = listOf("ºC", "ºF", "K")
    val currentSelection = remember { mutableStateOf(units.first()) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp)
                .background(Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "AJUSTES", 
                fontSize = 30.sp, 
                color = Color.White
            )
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Selecciona la unidad de temperatura: ",
                    color = Color.White,
                    fontSize = 20.sp,

                )
                RadioGroup(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    items = units,
                    selection = currentSelection.value,
                    onItemClick = { clickedItem ->
                        currentSelection.value = clickedItem
                    }
                )
                Spacer(modifier = Modifier.height(24.dp))
                DefaultButton(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 56.dp),
                    text = "Guardar Ajustes",
                    onClick = { navController.navigate(Screen.Weather.route) }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
            Row {
                DefaultButton(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 56.dp),
                    text = "Cerrar Sesión",
                    onClick = {
                        viewModel.logout()
                        navController.navigate(Screen.Login.route)
                    },
                    icon = Icons.AutoMirrored.Filled.Logout
                )
            }
        }
    }
}

@Composable
fun LabelledRadioButton(
    modifier: Modifier = Modifier,
    label: String,
    selected: Boolean,
    onClick: (() -> Unit)?,
    enabled: Boolean = true,
    colors: RadioButtonColors = RadioButtonDefaults.colors(
        selectedColor = PrimaryColor,
        unselectedColor = Color.White
    )
) {
    Row(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick,
            enabled = enabled,
            colors = colors
        )
        Text(
            text = label,
            modifier = Modifier.padding(start = 10.dp),
            color = Color.White
        )
    }
}

@Composable
fun RadioGroup(
    modifier: Modifier,
    items: List<String>,
    selection: String,
    onItemClick: ((String) -> Unit)
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach { item ->
            LabelledRadioButton(
                label = item,
                selected = item == selection,
                onClick = {
                    onItemClick(item)
                }
            )
        }
    }
}