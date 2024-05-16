package com.example.online_shop.domain.models

import com.example.online_shop.data.remote.CategoryDTO

data class Category(
    val categoryTitle: String
)

fun Category.toCategoryDTO(): CategoryDTO {
    return CategoryDTO(
        categoryTitle = categoryTitle

    )
}