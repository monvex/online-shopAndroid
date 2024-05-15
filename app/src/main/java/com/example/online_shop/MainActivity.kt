package com.example.online_shop

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.online_shop.presentation.admin_panel.AdminPanelScreen
import com.example.online_shop.presentation.admin_panel.screens.CategoriesAdminScreen
import com.example.online_shop.presentation.components.AppBar
import com.example.online_shop.ui.theme.OnlineshopTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnlineshopTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize() ,
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            AppBar(navController = navController)
                        }
                    ) {
                        NavHost(
                            navController = navController ,
                            startDestination = "adminMain"
                        ) {
//                            adminPanelNavigation(navController)
                            composable("adminMain") {
                                AdminPanelScreen(
                                    onNavigateToCategories = { navController.navigate("adminCategories") } ,
                                    onNavigateToBrands = { navController.navigate("adminBrands") },
                                    onNavigateToItems = { navController.navigate("adminItems")}
                                )
                            }
                            composable("adminCategories") {
                                CategoriesAdminScreen(

                                )
                            }
                        }

                    }
                }
            }
        }
    }
}

fun NavGraphBuilder.adminPanelNavigation(navController: NavController) {
    navigation(startDestination = "adminMain", route= "adminMainStart") {
        composable("adminMain") {
            AdminPanelScreen(
                onNavigateToCategories = { navController.navigate("adminCategories") } ,
                onNavigateToBrands = { navController.navigate("adminBrands") },
                onNavigateToItems = { navController.navigate("adminItems")}
            )
        }
        composable("adminCategories") {
            CategoriesAdminScreen(

            )
        }
    }
}
