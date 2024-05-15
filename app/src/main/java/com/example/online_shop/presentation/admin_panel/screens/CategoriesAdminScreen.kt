package com.example.online_shop.presentation.admin_panel.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.example.online_shop.presentation.admin_panel.AdminPanelViewModel

@Composable
fun CategoriesAdminScreen(
    viewModel: AdminPanelViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        for(i in 1..2) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoriesAdminScreenPreview() {
    CategoriesAdminScreen()
}