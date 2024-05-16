package com.example.online_shop.data.remote

import android.media.Image
import com.example.online_shop.data.remote.requests.AuthRequest
import com.example.online_shop.data.remote.responses.AuthResponse
import com.example.online_shop.domain.models.Brand
import com.example.online_shop.domain.models.Category
import com.example.online_shop.domain.models.Item
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.DELETE
import retrofit2.http.Path

interface OnlineShopApi {

    @GET("/items")
    suspend fun getItems(@Header("Authorization") token: String): List<ItemDTO>
    fun getPaginatedItems(page: Int, size: Int): List<Item>
    fun getItemById(id: Int): Item
    fun deleteItemById(id: Int)
    fun addNewItem(item: Item)
    fun updateItemById(id: Int, newItem: Item)

    @GET("/brands")
    suspend fun getBrands(
        @Header("Authorization") token: String
    ): List<BrandDTO>

    @DELETE("/brands/{title}")
    suspend fun deleteBrandByTitle(@Path("title") title: String, @Header("Authorization") token: String)
    fun updateBrandById(id: Int, newBrand: Brand)

    @POST("/brands/add")
    suspend fun addNewBrand(@Body brand: BrandDTO, @Header("Authorization") token: String)

    @GET("/categories")
    suspend fun getCategories(
        @Header("Authorization") token: String
    ): List<CategoryDTO>

    @DELETE("/categories/{title}")
    suspend fun deleteCategoryByTitle(@Path("title") title: String, @Header("Authorization") token: String)
    fun updateCategoryById(id: Int, newBrand: Category)

    @POST("/categories/add")
    suspend fun addNewCategory(@Body brand: CategoryDTO, @Header("Authorization") token: String)

    fun getImageByItemId(id: Int)
    fun addNewImage(image: Image)
    fun deleteImageById(id: String)
    @POST("/signin")
    suspend fun signIn(
        @Body auth: AuthRequest
    ): Response<AuthResponse>
}