package com.example.online_shop.data.remote

import com.example.online_shop.domain.models.Brand
import com.example.online_shop.domain.models.Category

data class BrandDTO(
    val brandTitle: String

)

fun BrandDTO.toBrand(): Brand {
    return Brand(
        brandTitle = brandTitle

    )
}