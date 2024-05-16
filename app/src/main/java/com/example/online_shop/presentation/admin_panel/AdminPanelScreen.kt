package com.example.online_shop.presentation.admin_panel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AdminPanelScreen(
    onNavigateToCategories: () -> Unit,
    onNavigateToBrands: () -> Unit,
    onNavigateToSignIn: () -> Unit
    onNavigateToItems: () -> Unit,
    onNavigateToUsers: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = onNavigateToCategories
            ) {
                Text("Категории")
            }
            Button(
                onClick = onNavigateToBrands
            ) {
                Text("Брэнды")
            }
            Button(
                onClick = onNavigateToItems
            ) {
                Text("Товары")
            }
            Button(
                onClick = onNavigateToSignIn
            ) {
                Text("Авторизация")
            }
            Button(
                onClick = onNavigateToUsers
            ) {
                Text("Пользователи")
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun AdminPanelScreenPreview() {
    AdminPanelScreen(onNavigateToCategories = { /*TODO*/ } , onNavigateToBrands = { /*TODO*/ }, onNavigateToItems = { })
}