package com.example.online_shop.presentation.admin_panel.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.online_shop.presentation.admin_panel.AdminPanelViewModel

@Composable
fun BrandAddingScreen(
    onBack: () -> Unit,
    viewModel: AdminPanelViewModel = hiltViewModel()
){
    var title by remember { mutableStateOf("") }
    Box( modifier = Modifier
        .fillMaxSize()
        .padding(0.dp, 65.dp)){
        Column() {
            Row( modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text("Введите название бренда")
            }
            Row( modifier = Modifier.fillMaxWidth().padding(5.dp), horizontalArrangement = Arrangement.Center ) {
                OutlinedTextField(value = title, onValueChange = { title = it })
            }
            Row( modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center ) {
                Button(
                    onClick = {
                        if (title.isNotEmpty()) {
                            viewModel.addNewBrand(title)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    border = BorderStroke(width = 1.dp, color = Color.Black)
                ) {
                    Text(text = "Add")
                }
            }
        }
    }
}