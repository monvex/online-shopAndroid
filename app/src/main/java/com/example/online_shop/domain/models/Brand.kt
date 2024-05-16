package com.example.online_shop.domain.models

import com.example.online_shop.data.remote.BrandDTO
import com.example.online_shop.data.remote.CategoryDTO

data class Brand(
    val brandTitle: String
)

fun Brand.toBrandDTO(): BrandDTO {
    return BrandDTO(
        brandTitle = brandTitle

    )
}