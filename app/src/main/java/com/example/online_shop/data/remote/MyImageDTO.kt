package com.example.online_shop.data.remote

import android.media.Image
import com.example.online_shop.domain.models.MyImage

data class MyImageDTO(
    val id: String,
    val filename: String
)

fun MyImageDTO.toMyImage(): MyImage {
    return MyImage(
        id = id,
        filename = filename
    )
}