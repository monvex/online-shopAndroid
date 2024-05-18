package com.example.online_shop.data.repository

import android.media.Image
import androidx.lifecycle.viewModelScope
import androidx.test.core.app.ActivityScenario.launch
import com.example.online_shop.data.dataStore.TokenManager
import com.example.online_shop.data.remote.CategoryDTO
import com.example.online_shop.data.remote.ItemDTO
import com.example.online_shop.data.remote.OnlineShopApi
import com.example.online_shop.data.remote.requests.AuthRequest
import com.example.online_shop.data.remote.responses.AuthResponse
import com.example.online_shop.data.remote.toBrand
import com.example.online_shop.data.remote.toCategory
import com.example.online_shop.data.remote.toItem
import com.example.online_shop.domain.models.Brand
import com.example.online_shop.domain.models.Category
import com.example.online_shop.domain.models.Item
import com.example.online_shop.domain.models.toBrandDTO
import com.example.online_shop.domain.models.toCategoryDTO
import com.example.online_shop.domain.repository.OnlineShopRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OnlineShopRepositoryImpl @Inject constructor(
    private val api: OnlineShopApi,
    private val tokenManager: TokenManager
) : OnlineShopRepository {
    override suspend fun getItems(token: String): List<Item> {
        return api.getItems(token = token).map { itemDTO -> itemDTO.toItem()  }
    }

    override fun getPaginatedItems(page: Int , size: Int , token: String): List<Item> {
        TODO("Not yet implemented")
    }

    override fun getItemById(id: Int , token: String): Item {
        TODO("Not yet implemented")
    }

    override fun deleteItemById(id: Int , token: String) {
        TODO("Not yet implemented")
    }

    override fun addNewItem(item: Item , token: String) {
        TODO("Not yet implemented")
    }

    override fun updateItemById(id: Int , newItem: Item , token: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getBrands(token: String): List<Brand> {
        return api.getBrands(token = token).map { brandDTO -> brandDTO.toBrand()  }
    }

    override suspend fun deleteBrandByTitle(title: String , token: String) {
        api.deleteBrandByTitle(title, token = token)
    }

    override fun updateBrandById(id: Int , newBrand: Brand , token: String) {
        TODO("Not yet implemented")
    }

    override suspend fun addNewBrand(brand: Brand , token: String) {
        api.addNewBrand(brand.toBrandDTO(), token = token)
    }

    override suspend fun getCategories(token: String): List<Category> {
        return api.getCategories(token = token).map { categoryDTO -> categoryDTO.toCategory()  }
    }

    override suspend fun deleteCategoryByTitle(title: String , token: String) {
        api.deleteCategoryByTitle(title, token = token)
    }

    override fun updateCategoryById(id: Int , newBrand: Category , token: String) {
        TODO("Not yet implemented")
    }

    override suspend fun addNewCategory(category: Category , token: String) {
        api.addNewCategory(category.toCategoryDTO(), token = token)
    }

    override fun getImageByItemId(id: Int , token: String) {
        TODO("Not yet implemented")
    }

    override fun addNewImage(image: Image , token: String) {
        TODO("Not yet implemented")
    }

    override fun deleteImageById(id: String , token: String) {
        TODO("Not yet implemented")
    }

    override suspend fun login(auth: AuthRequest): AuthResponse {
        val response = api.signIn(auth)
        tokenManager.saveToken(response.body()?.token ?: "")
        tokenManager.saveRole(response.body()?.role ?: "")

        return AuthResponse(
            token = response.body()?.token ?: "",
            role = response.body()?.role ?: "user"
        )
    }
}