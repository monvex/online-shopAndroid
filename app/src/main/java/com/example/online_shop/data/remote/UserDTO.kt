package com.example.online_shop.data.remote

import com.example.online_shop.domain.models.User


data class UserDTO(
    val id: Int,
    val username: String,
    val password: String,
    val salt: String,
    val role: String
)

fun UserDTO.toUser(): User {
    return User(
        id = id,
        username = username,
        password = password,
        salt = salt,
        role = role
    )
}