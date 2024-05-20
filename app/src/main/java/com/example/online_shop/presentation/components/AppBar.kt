package com.example.online_shop.presentation.components

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(navController: NavHostController) {
    var title by remember { mutableStateOf("") }

    LaunchedEffect(navController.currentBackStackEntryFlow) {
        navController.currentBackStackEntryFlow.collect {
            title = it.destination.route ?: ""
        }
    }

    Surface(elevation = 3.dp) {
        TopAppBar(
            title = {
                Text(
                    getTitleForRoute(title).uppercase(),
                    style = MaterialTheme.typography.titleLarge
                )
            },
            modifier = Modifier ,
            colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
        )
    }
}


private fun getTitleForRoute(route: String): String {
    return when (route) {
        "adminMain" -> "Панель Админа"
        "adminCategories" -> "Категории"
        "adminBrands" -> "Брэнды"
        "adminItems" -> "Товары"
        "signIn" -> "Авторизация"
        "shopMain" -> "Aboba Store"
        else -> ""
    }
}