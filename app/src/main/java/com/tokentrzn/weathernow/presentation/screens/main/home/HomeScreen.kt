package com.tokentrzn.weathernow.presentation.screens.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tokentrzn.weathernow.presentation.navigation.Screen
import com.tokentrzn.weathernow.presentation.screens.main.home.components.HomeContentPreview
import com.tokentrzn.weathernow.presentation.theme.DarkTransparentColor
import com.tokentrzn.weathernow.presentation.theme.LinearGradient
import com.tokentrzn.weathernow.presentation.theme.SecondaryTextColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavController) {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        modifier = Modifier
            .background(LinearGradient()),
        drawerState = drawerState,
        drawerContent = {
            Box(
                Modifier
                    .width(250.dp)
                    .fillMaxHeight()
                    .background(Color.DarkGray)
            ) {
                MenuContent(navController)
            }
        },
        content = {
            Scaffold(
                containerColor = Color.Transparent,
                topBar = { MenuTopBar( navController = navController, drawerState = drawerState, scope = scope) },
                content = { contentPadding ->
                    Box(modifier = Modifier
                        .padding(contentPadding)) { HomeContentPreview() }
                }
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuTopBar(navController: NavController, drawerState: DrawerState, scope: CoroutineScope) {
    TopAppBar(
        title = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),  // Ajusta el padding horizontal según sea necesario
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Tarazona",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp  // Ajusta el tamaño de fuente según sea necesario
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    drawerState.open()
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu Icon",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = DarkTransparentColor,
            titleContentColor = Color.White
        ),
        actions = { AddCityButton(navController) }
    )
}

@Composable
fun MenuButton(navController: NavController, route: String, icon: ImageVector, text: String) {
    Button(
        onClick = { navController.navigate(route) },
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

@Composable
fun MenuContent(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Text("Menú", fontSize = 26.sp, modifier = Modifier
            .padding(8.dp)
            .padding(bottom = 12.dp), fontWeight = FontWeight.Bold, color = Color.White)
        MenuButton(navController = navController, route = Screen.Profile.route, icon = Icons.Default.Person, text = "Perfil")
        MenuDivider()
        MenuButton(navController = navController, route = Screen.Settings.route, icon = Icons.Default.StarBorder, text = "Favoritos")
        MenuDivider()
        MenuButton(navController = navController, route = Screen.Settings.route, icon = Icons.Default.Settings, text = "Ajustes")
    }
}

@Composable
fun MenuDivider() {
    Divider(
        Modifier
            .padding(start = 16.dp, end = 16.dp)
            .background(SecondaryTextColor)
            .height(1.dp)

    )
}

@Composable
fun AddCityButton(navController: NavController) {
    IconButton(
        onClick = { navController.navigate(Screen.Search.route) },
        modifier = Modifier
            .padding(8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add Icon",
            tint = Color.White
        )
    }
}

@Composable
fun FavoriteButton() {
    var isSelected by remember { mutableStateOf(false) }

    IconButton(
        onClick = { isSelected = !isSelected },
        modifier = Modifier
            .padding(8.dp)
    ) {
        Icon(
            imageVector = if (isSelected) Icons.Default.Star else Icons.Default.StarBorder,
            contentDescription = "Star Icon",
            tint = Color.White
        )
    }
}