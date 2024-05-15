package com.example.online_shop.data.remote

import com.example.online_shop.domain.models.Category

data class CategoryDTO(
    val categoryTitle: String

)

fun CategoryDTO.toCategory(): Category {
    return Category(
        categoryTitle = categoryTitle

    )
}



