package com.example.online_shop.domain.models

data class Item(
    val itemTitle: String,
    val brand: String,
    val category: String,
    val price: Double,
    val imageId: String
)
