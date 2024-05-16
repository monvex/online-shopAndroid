package com.example.online_shop.presentation.admin_panel.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.online_shop.domain.models.Brand
import com.example.online_shop.domain.models.Category
import com.example.online_shop.presentation.admin_panel.AdminPanelViewModel

@Composable
fun BrandsAdminScreen(
    onNavigateToBrandAdding: () -> Unit,
    viewModel: AdminPanelViewModel = hiltViewModel()
) {
    val brands by viewModel.brands.collectAsState()
    Box( modifier = Modifier
        .fillMaxSize()
        .padding(0.dp, 60.dp, 0.dp, 0.dp)
    ){
        LazyColumn(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxSize()
        ) {
            items(brands) { brand ->
                BrandCard(brand, viewModel)
            }
        }
        Row( modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Bottom ){
            Button(onClick = onNavigateToBrandAdding,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                border = BorderStroke(width = 1.dp, color = Color.Black)
            ){
                Text(text = "Add")
            }
        }
    }
}

@Composable
fun BrandCard(brand: Brand, viewModel: AdminPanelViewModel){
    Row( modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
    ){
        Column( modifier = Modifier.fillMaxWidth(0.5f) ){
            Text(text = brand.brandTitle, fontSize = 20.sp)
        }
        Column(){
            Button(onClick = {  },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                border = BorderStroke(width = 1.dp, color = Color.Black)
            ){
                Text(text = "Edit")
            }
        }
        Column( modifier = Modifier.padding(5.dp, 0.dp, 0.dp, 0.dp)){
            Button(onClick = { viewModel.deleteBrand(brand.brandTitle) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                border = BorderStroke(width = 1.dp, color = Color.Black)
            ) {
                Text(text = "Delete")
            }
        }
    }
    Divider(
        modifier = Modifier.fillMaxWidth(0.95f),
        color = Color.LightGray, thickness = 1.dp
    )
}

@Preview(showBackground = true)
@Composable
fun BrandsAdminScreenPreview() {
    CategoriesAdminScreen( {} )
}