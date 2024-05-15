package com.example.online_shop.data.remote

import android.media.Image
import com.example.online_shop.domain.models.Brand
import com.example.online_shop.domain.models.Category
import com.example.online_shop.domain.models.Item
import retrofit2.http.GET
import retrofit2.http.Header

interface OnlineShopApi {
    fun getItems(): List<Item>
    fun getPaginatedItems(page: Int, size: Int): List<Item>
    fun getItemById(id: Int): Item
    fun deleteItemById(id: Int)
    fun addNewItem(item: Item)
    fun updateItemById(id: Int, newItem: Item)

    fun getBrands(): List<Brand>
    fun deleteBrandById(id: Int)
    fun updateBrandById(id: Int, newBrand: Brand)
    fun addNewBrand(brand: Brand)

    @GET("/categories")
    fun getCategories(
        @Header("Authorization") token: String
    ): List<CategoryDTO>
    fun deleteCategoryById(id: Int)
    fun updateCategoryById(id: Int, newBrand: Category)
    fun addNewCategory(brand: Category)

    fun getImageByItemId(id: Int)
    fun addNewImage(image: Image)
    fun deleteImageById(id: String)
}