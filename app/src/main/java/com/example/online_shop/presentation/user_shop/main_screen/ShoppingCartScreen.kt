package com.example.online_shop.presentation.user_shop.main_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.online_shop.data.remote.ItemDTO
import com.example.online_shop.domain.models.Item
import kotlinx.coroutines.runBlocking

@Composable
fun ShoppingCartScreen(
    viewModel: UserShopMainScreenViewModel = hiltViewModel()
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 70.dp)
                    .fillMaxWidth()
                    .height(60.dp)
            ) {

                Button(onClick = {
                    runBlocking {
                        viewModel.buyItemsFromShoppingCart()
                    }
                }) {
                    Text("Купить")
                }

            }
            LazyColumn(
                modifier = Modifier
                    .padding(4.dp)
            ) {
                item {
                    val shoppingCart = viewModel.shoppingCart.collectAsState()
                    shoppingCart.value.forEach {
                        ItemCardShoppingCart(item = it, viewModel = viewModel)
                    }

                }
            }


        }
    }
}


@Composable
fun ItemCardShoppingCart(item: Item , viewModel: UserShopMainScreenViewModel){
    Row( modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceAround
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
            androidx.compose.material3.Button(
                onClick = {viewModel.addItemToShoppingCart(item) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White ,
                    contentColor = Color.Black
                ) ,
                border = BorderStroke(width = 1.dp , color = Color.Black)
            ) {
                Text(text = "+")
            }
        }
    }
    Divider(
        modifier = Modifier.fillMaxWidth(0.95f),
        color = Color.LightGray, thickness = 1.dp
    )
}