package com.example.online_shop

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.online_shop.data.remote.requests.AuthRequest
import com.example.online_shop.presentation.admin_panel.AdminPanelScreen
import com.example.online_shop.presentation.admin_panel.screens.BrandAddingScreen
import com.example.online_shop.presentation.admin_panel.screens.BrandsAdminScreen
import com.example.online_shop.presentation.admin_panel.screens.CategoriesAdminScreen
import com.example.online_shop.presentation.admin_panel.screens.CategoryAddingScreen
import com.example.online_shop.presentation.auth.AuthScreen
import com.example.online_shop.presentation.auth.AuthScreenViewModel
import com.example.online_shop.presentation.components.AppBar
import com.example.online_shop.ui.theme.OnlineshopTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
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
                                    onNavigateToItems = { navController.navigate("adminItems")},
                                    onNavigateToUsers = { navController.navigate("adminUsers")},
                                    onNavigateToSignIn = { navController.navigate("signIn")}
                                )
                            }
                            composable("adminCategories") {
                                CategoriesAdminScreen( { navController.navigate("categoryAdding") } )
                            }
                            composable("categoryAdding"){
                                CategoryAddingScreen( { navController.navigate("adminCategories"){
                                    launchSingleTop = true
                                    popUpTo("adminCategories") { inclusive = true }
                                    }
                                } )
                            }
                            composable("adminBrands") {
                                BrandsAdminScreen( { navController.navigate("brandAdding") } )
                            }
                            composable("brandAdding") {
                                BrandAddingScreen({ navController.navigate("adminBrands"){
                                    launchSingleTop = true
                                    popUpTo("adminBrands") { inclusive = true }
                                }
                                })
                            }
                            composable("adminItems") {
                                //CategoriesAdminScreen()
                            }
                            composable("adminUsers") {
                                //CategoriesAdminScreen()
                            }
                            composable("signIn") {
                                val viewModel: AuthScreenViewModel = hiltViewModel()
                                val localContext = LocalContext.current
                                AuthScreen(
                                    onSignInClick = {
                                        runBlocking {
                                            try {
                                                val response = viewModel.signIn(AuthRequest(viewModel.uiState.value.login, viewModel.uiState.value.password))
                                                Toast.makeText(
                                                    localContext,
                                                    response.token,
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            } catch (e: Exception){
                                                Toast.makeText(
                                                    localContext,
                                                    "Анлак Бро",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }

                                        }
                                    }
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}
