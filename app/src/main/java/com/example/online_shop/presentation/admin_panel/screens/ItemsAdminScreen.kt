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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.online_shop.R
import com.example.online_shop.domain.models.Brand
import com.example.online_shop.domain.models.Item
import com.example.online_shop.presentation.admin_panel.AdminPanelViewModel

@Composable
fun ItemsAdminScreen(
    onNavigateToItemAdding: () -> Unit,
    viewModel: AdminPanelViewModel = hiltViewModel()
) {
    val items by viewModel.items.collectAsState()
    Box( modifier = Modifier
        .fillMaxSize()
        .padding(0.dp, 60.dp, 0.dp, 0.dp)
    ){
        LazyColumn(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxSize()
        ) {
            items(items) { item ->
                ItemCard(item, viewModel)
            }
        }
        Row( modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Bottom ){
            Button(onClick = onNavigateToItemAdding,
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
fun ItemCard(item: Item, viewModel: AdminPanelViewModel){
    Row( modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
    ){
        Column(modifier = Modifier.fillMaxWidth(0.25f)){
            AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                .data("http://192.168.0.105:8080/images/${item.imageId}")
                .crossfade(true)
                .build(),
                contentDescription = null)
        }
        Column( modifier = Modifier.fillMaxWidth(0.25f) ){
            Text(text = item.itemTitle, fontSize = 20.sp)
        }
        Column(){
            Text(text = item.brand, fontSize = 20.sp)
        }
        Column(){
            Text(text = item.category, fontSize = 20.sp)
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
            Button(onClick = { viewModel.deleteItem(item.id) },
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
