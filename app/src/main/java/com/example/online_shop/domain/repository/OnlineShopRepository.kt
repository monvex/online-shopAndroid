package com.example.online_shop.domain.repository

import android.media.Image
import com.example.online_shop.data.remote.requests.AuthRequest
import com.example.online_shop.data.remote.responses.AuthResponse
import com.example.online_shop.domain.models.Brand
import com.example.online_shop.domain.models.Category
import com.example.online_shop.domain.models.Item
import com.example.online_shop.utils.ApiResponse
import com.example.online_shop.utils.apiRequestFlow
import kotlinx.coroutines.flow.Flow

interface OnlineShopRepository {
    suspend fun getItems(token: String): List<Item>
    fun getPaginatedItems(page: Int, size: Int, token: String): List<Item>
    fun getItemById(id: Int, token: String): Item
    fun deleteItemById(id: Int, token: String)
    fun addNewItem(item: Item, token: String)
    fun updateItemById(id: Int, newItem: Item, token: String)

    suspend fun getBrands(token: String): List<Brand>
    suspend fun deleteBrandByTitle(title: String, token: String)
    fun updateBrandById(id: Int, newBrand: Brand, token: String)
    suspend fun addNewBrand(brand: Brand, token: String)


    suspend fun getCategories(token: String): List<Category>
    suspend fun deleteCategoryByTitle(title: String, token: String)
    fun updateCategoryById(id: Int, newBrand: Category, token: String)
    suspend fun addNewCategory(category: Category, token: String)

    fun getImageByItemId(id: Int, token: String)
    fun addNewImage(image: Image, token: String)
    fun deleteImageById(id: String, token: String)

    suspend fun login(auth: AuthRequest): AuthResponse

}