package com.example.online_shop.data.remote

import com.example.online_shop.domain.models.Brand
import com.example.online_shop.domain.models.Item

data class ItemDTO(
    val id: Int,
    val itemTitle: String,
    val brand: String,
    val category: String,
    val price: Double,
    val imageId: String
)

fun ItemDTO.toItem(): Item {
    return Item(
        id = id,
        itemTitle = itemTitle,
        brand = brand,
        category = category,
        price = price,
        imageId = imageId
    )
}
