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
    suspend fun getItems(): List<Item>
    fun getPaginatedItems(page: Int, size: Int): List<Item>
    fun getItemById(id: Int): Item
    fun deleteItemById(id: Int)
    fun addNewItem(item: Item)
    fun updateItemById(id: Int, newItem: Item)

    suspend fun getBrands(): List<Brand>
    suspend fun deleteBrandByTitle(title: String)
    fun updateBrandById(id: Int, newBrand: Brand)
    suspend fun addNewBrand(brand: Brand)


    suspend fun getCategories(): List<Category>
    suspend fun deleteCategoryByTitle(title: String)
    fun updateCategoryById(id: Int, newBrand: Category)
    suspend fun addNewCategory(category: Category)

    fun getImageByItemId(id: Int)
    fun addNewImage(image: Image)
    fun deleteImageById(id: String)

    suspend fun login(auth: AuthRequest): AuthResponse

}