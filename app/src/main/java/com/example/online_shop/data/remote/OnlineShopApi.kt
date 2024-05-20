package com.example.online_shop.data.remote

import android.media.Image
import com.example.online_shop.data.ShoppingCart
import com.example.online_shop.data.remote.requests.AuthRequest
import com.example.online_shop.data.remote.responses.AuthResponse
import com.example.online_shop.domain.models.Brand
import com.example.online_shop.domain.models.Category
import com.example.online_shop.domain.models.Item
import com.example.online_shop.domain.models.UserToDB
import org.json.JSONArray
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.DELETE
import retrofit2.http.PUT
import retrofit2.http.Path

interface OnlineShopApi {

    @GET("/items")
    suspend fun getItems(@Header("Authorization") token: String): List<ItemDTO>
    fun getPaginatedItems(page: Int, size: Int): List<Item>
    fun getItemById(id: Int): Item
    @POST("/purchase")
    suspend fun buyItemsFromShoppingCart(@Body items: List<Item>, @Header("Authorization") token: String): Double
    @DELETE("items/{id}")
    suspend fun deleteItemById(@Path("id") id : Int, @Header("Authorization") token: String)
    fun addNewItem(item: Item)
    fun updateItemById(id: Int, newItem: Item)

    @GET("/users")
    suspend fun getUsers(@Header("Authorization") token: String): List<UserDTO>

    @DELETE("users/{id}")
    suspend fun deleteUserById(@Path("id") id : Int, @Header("Authorization") token: String)

    @POST("/signup")
    suspend fun addNewUser(@Body user: UserToDB, @Header("Authorization") token: String)

    @GET("/brands")
    suspend fun getBrands(
        @Header("Authorization") token: String
    ): List<BrandDTO>

    @DELETE("/brands/{title}")
    suspend fun deleteBrandByTitle(@Path("title") title: String, @Header("Authorization") token: String)

    @PUT("/brands/{title}")
    suspend fun updateBrand(@Path("title") title: String, @Body newBrand: Brand, @Header("Authorization") token: String)

    @POST("/brands/add")
    suspend fun addNewBrand(@Body brand: BrandDTO, @Header("Authorization") token: String)

    @GET("/categories")
    suspend fun getCategories(
        @Header("Authorization") token: String
    ): List<CategoryDTO>

    @DELETE("/categories/{title}")
    suspend fun deleteCategoryByTitle(@Path("title") title: String, @Header("Authorization") token: String)
    @PUT("/categories/{title}")
    suspend fun updateCategory(@Path("title") title: String, @Body newCategory: Category, @Header("Authorization") token: String)

    @POST("/categories/add")
    suspend fun addNewCategory(@Body brand: CategoryDTO, @Header("Authorization") token: String)

    @GET("/images/{id}")
    suspend fun getImageById(@Path("id") id: String, @Header("Authorization") token: String): MyImageDTO
    fun addNewImage(image: Image)
    fun deleteImageById(id: String)
    @POST("/signin")
    suspend fun signIn(
        @Body auth: AuthRequest
    ): Response<AuthResponse>
}