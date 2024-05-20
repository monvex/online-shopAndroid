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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.online_shop.data.remote.requests.AuthRequest
import com.example.online_shop.presentation.admin_panel.AdminPanelScreen
import com.example.online_shop.presentation.admin_panel.screens.BrandAddingScreen
import com.example.online_shop.presentation.admin_panel.screens.BrandEditScreen
import com.example.online_shop.presentation.admin_panel.screens.BrandsAdminScreen
import com.example.online_shop.presentation.admin_panel.screens.CategoriesAdminScreen
import com.example.online_shop.presentation.admin_panel.screens.CategoryAddingScreen
import com.example.online_shop.presentation.admin_panel.screens.CategoryEditScreen
import com.example.online_shop.presentation.admin_panel.screens.ItemAddingScreen
import com.example.online_shop.presentation.admin_panel.screens.ItemsAdminScreen
import com.example.online_shop.presentation.admin_panel.screens.UserAddingScreen
import com.example.online_shop.presentation.admin_panel.screens.UsersAdminScreen
import com.example.online_shop.presentation.auth.AuthScreen
import com.example.online_shop.presentation.auth.AuthScreenViewModel
import com.example.online_shop.presentation.components.AppBar
import com.example.online_shop.presentation.user_shop.main_screen.ShoppingCartScreen
import com.example.online_shop.presentation.user_shop.main_screen.UserShopMainScreen
import com.example.online_shop.presentation.user_shop.main_screen.UserShopMainScreenViewModel
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
                            startDestination = "onBoarding"
                        ) {
//                            adminPanelNavigation(navController)
                            composable("onBoarding") {
                                val viewModel: AuthScreenViewModel = hiltViewModel()
                                if (viewModel.token == null) {
                                    navController.navigate("signIn")
                                } else {
                                    navController.navigate("shopMain")
                                }
                            }
                            composable("shopMain") {
                                UserShopMainScreen(
                                    onAdminPanelClicked = {navController.navigate("adminMain")},
                                    onShoppingCartClicked = { navController.navigate("shoppingCart")}
                                )
                            }
                            composable("shoppingCart") { backStackEntry ->
                                val parentEntry  = remember(backStackEntry) {
                                    navController.getBackStackEntry("shopMain")
                                }
                                val parentViewModel = hiltViewModel<UserShopMainScreenViewModel>(parentEntry)
                                ShoppingCartScreen(viewModel = parentViewModel)
                            }
                            composable("adminMain") {
                                val viewModel: AuthScreenViewModel = hiltViewModel()
                                val localContext = LocalContext.current
                                AdminPanelScreen(
                                    onShowStuffClick = {
                                        Toast.makeText(
                                            localContext,
                                            viewModel.token,
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    },
                                    onNavigateToCategories = { navController.navigate("adminCategories") } ,
                                    onNavigateToBrands = { navController.navigate("adminBrands") },
                                    onNavigateToItems = { navController.navigate("adminItems")},
                                    onNavigateToSignIn = { navController.navigate("signIn")},
                                    onNavigateToUsers = { navController.navigate("adminUsers")}
                                )
                            }
                            composable("signIn") {
                                val viewModel: AuthScreenViewModel = hiltViewModel()
                                val localContext = LocalContext.current
                                AuthScreen(
                                    onSignInClick = {
                                        runBlocking {
                                            try {
                                                val response = viewModel.signIn(AuthRequest(viewModel.uiState.value.login, viewModel.uiState.value.password))
                                                if (response.token != "") {
                                                    Toast.makeText(
                                                        localContext,
                                                        response.token,
                                                        Toast.LENGTH_SHORT
                                                    ).show()
                                                    navController.navigate("shopMain")
                                                } else {
                                                    Toast.makeText(
                                                        localContext,
                                                        "Анлак Бро",
                                                        Toast.LENGTH_SHORT
                                                    ).show()
                                                }

                                            } catch (e: Exception){

                                            }

                                        }
                                    }
                                )
                            }
                            composable("adminCategories") {
                                CategoriesAdminScreen( { navController.navigate("categoryAdding") }, navController )
                            }
                            composable("categoryAdding"){
                                CategoryAddingScreen( { navController.navigate("adminCategories") } )
                            }
                            composable("categoryEdit/{categoryTitle}"){
                                CategoryEditScreen(categoryTitle = it.arguments?.getString("categoryTitle") ?: "")
                            }
                            composable("adminBrands") {
                                BrandsAdminScreen( { navController.navigate("brandAdding") }, navController )
                            }
                            composable("brandAdding") {
                                BrandAddingScreen( { navController.navigate("adminBrands") } )
                            }
                            composable("brandEdit/{brandTitle}"){
                                BrandEditScreen(brandTitle = it.arguments?.getString("brandTitle") ?: "")
                            }
                            composable("adminItems") {
                                ItemsAdminScreen({navController.navigate("itemAdding")})
                            }
                            composable("itemAdding"){
                                ItemAddingScreen()
                            }
                            composable("adminUsers") {
                                UsersAdminScreen( { navController.navigate("userAdding") } )
                            }
                            composable("userAdding") {
                                UserAddingScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}

