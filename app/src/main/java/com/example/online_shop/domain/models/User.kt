package com.example.online_shop.domain.models

data class User(
    val id: Int,
    val username: String,
    val password: String,
    val salt: String,
    val role: String
)

data class UserToDB(
    val username: String,
    val password: String,
    val role: String
)

fun User.toUserToDB(): UserToDB{
    return UserToDB(
        username = username,
        password = password,
        role = role
    )
}
