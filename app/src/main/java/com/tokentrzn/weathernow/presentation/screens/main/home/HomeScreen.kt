package com.tokentrzn.weathernow.presentation.screens.main.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.tokentrzn.weathernow.presentation.navigation.Screen
import com.tokentrzn.weathernow.presentation.screens.main.home.components.DrawerContent
import com.tokentrzn.weathernow.presentation.screens.main.home.components.HomeContentPreview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet { DrawerContent(navController = navController) }
            },
        ) {
            Scaffold(
                topBar = { MenuTopBar(drawerState = drawerState, scope = scope, navController = navController) },
                content = { HomeContentPreview() }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuTopBar(drawerState: DrawerState, scope: CoroutineScope, navController: NavController) {
    TopAppBar(
        title = { Text(text = "") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    drawerState.open()
                }
            }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu Icon", tint = Color.White)
            }
        },
        actions = {
            IconButton(onClick = { navController.navigate(Screen.Search.route) }) {
                Icon(Icons.Filled.Add, contentDescription = "Add Icon", tint = Color.White)
            }
        }
    )
}

