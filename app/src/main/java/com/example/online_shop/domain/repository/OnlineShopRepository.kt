package com.example.online_shop.domain.repository

import android.media.Image
import com.example.online_shop.data.remote.requests.AuthRequest
import com.example.online_shop.data.remote.responses.AuthResponse
import com.example.online_shop.domain.models.Brand
import com.example.online_shop.domain.models.Category
import com.example.online_shop.domain.models.Item
import com.example.online_shop.domain.models.MyImage
import com.example.online_shop.domain.models.User
import com.example.online_shop.domain.models.UserToDB

interface OnlineShopRepository {
    suspend fun getItems(token: String): List<Item>
    fun getPaginatedItems(page: Int, size: Int, token: String): List<Item>
    fun getItemById(id: Int, token: String): Item
    suspend fun deleteItemById(id: Int, token: String)
    fun addNewItem(item: Item, token: String)
    fun updateItemById(id: Int, newItem: Item, token: String)

    suspend fun getUsers(token: String): List<User>

    suspend fun addNewUser(user: UserToDB, token: String)

    suspend fun deleteUserById(id: Int, token: String)

    suspend fun getBrands(token: String): List<Brand>
    suspend fun deleteBrandByTitle(title: String, token: String)
    suspend fun updateBrand(title: String, newBrand: Brand, token: String)
    suspend fun addNewBrand(brand: Brand, token: String)


    suspend fun getCategories(token: String): List<Category>
    suspend fun deleteCategoryByTitle(title: String, token: String)
    suspend fun updateCategory(title: String, newCategory: Category, token: String)
    suspend fun addNewCategory(category: Category, token: String)

    suspend fun buyItemsFromShoppingCart(shoppingCart: MutableList<Item>, token: String): Double
    suspend fun getImageById(id: String, token: String): MyImage
    fun addNewImage(image: Image, token: String)
    fun deleteImageById(id: String, token: String)

    suspend fun login(auth: AuthRequest): AuthResponse

}