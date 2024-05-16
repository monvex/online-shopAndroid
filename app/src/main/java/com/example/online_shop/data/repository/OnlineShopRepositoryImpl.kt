package com.example.online_shop.data.repository

import android.media.Image
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
import javax.inject.Inject

class OnlineShopRepositoryImpl @Inject constructor(
    private val api: OnlineShopApi,
    private val tokenManager: TokenManager
) : OnlineShopRepository {
    override suspend fun getItems(): List<Item> {
        return api.getItems("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJodHRwOi8vMC4wLjAuMDo4MDgwL2hlbGxvIiwiaXNzIjoiaHR0cDovLzAuMC4wLjA6ODA4MC8iLCJleHAiOjI1Nzk4MDkxOTcsInVzZXJJZCI6IjIiLCJyb2xlIjoiYWRtaW4ifQ.ArgJqeaB2Nd4KH7bMf_7UPF4Npe_sYUoOLGcVShe29c").map { itemDTO -> itemDTO.toItem()  }
    }

    override fun getPaginatedItems(page: Int , size: Int): List<Item> {
        TODO("Not yet implemented")
    }

    override fun getItemById(id: Int): Item {
        TODO("Not yet implemented")
    }

    override fun deleteItemById(id: Int) {
        TODO("Not yet implemented")
    }

    override fun addNewItem(item: Item) {
        TODO("Not yet implemented")
    }

    override fun updateItemById(id: Int , newItem: Item) {
        TODO("Not yet implemented")
    }

    override suspend fun getBrands(): List<Brand> {
        return api.getBrands("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJodHRwOi8vMC4wLjAuMDo4MDgwL2hlbGxvIiwiaXNzIjoiaHR0cDovLzAuMC4wLjA6ODA4MC8iLCJleHAiOjI1Nzk4MDkxOTcsInVzZXJJZCI6IjIiLCJyb2xlIjoiYWRtaW4ifQ.ArgJqeaB2Nd4KH7bMf_7UPF4Npe_sYUoOLGcVShe29c").map { brandDTO -> brandDTO.toBrand()  }
    }

    override suspend fun deleteBrandByTitle(title: String) {
        api.deleteBrandByTitle(title, "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJodHRwOi8vMC4wLjAuMDo4MDgwL2hlbGxvIiwiaXNzIjoiaHR0cDovLzAuMC4wLjA6ODA4MC8iLCJleHAiOjI1Nzk4MDkxOTcsInVzZXJJZCI6IjIiLCJyb2xlIjoiYWRtaW4ifQ.ArgJqeaB2Nd4KH7bMf_7UPF4Npe_sYUoOLGcVShe29c")
    }

    override fun updateBrandById(id: Int , newBrand: Brand) {
        TODO("Not yet implemented")
    }

    override suspend fun addNewBrand(brand: Brand) {
        api.addNewBrand(brand.toBrandDTO(), "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJodHRwOi8vMC4wLjAuMDo4MDgwL2hlbGxvIiwiaXNzIjoiaHR0cDovLzAuMC4wLjA6ODA4MC8iLCJleHAiOjI1Nzk4MDkxOTcsInVzZXJJZCI6IjIiLCJyb2xlIjoiYWRtaW4ifQ.ArgJqeaB2Nd4KH7bMf_7UPF4Npe_sYUoOLGcVShe29c")
    }

    override suspend fun getCategories(): List<Category> {
        return api.getCategories("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJodHRwOi8vMC4wLjAuMDo4MDgwL2hlbGxvIiwiaXNzIjoiaHR0cDovLzAuMC4wLjA6ODA4MC8iLCJleHAiOjI1Nzk4MDkxOTcsInVzZXJJZCI6IjIiLCJyb2xlIjoiYWRtaW4ifQ.ArgJqeaB2Nd4KH7bMf_7UPF4Npe_sYUoOLGcVShe29c").map { categoryDTO -> categoryDTO.toCategory()  }
    }

    override suspend fun deleteCategoryByTitle(title: String) {
        api.deleteCategoryByTitle(title, "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJodHRwOi8vMC4wLjAuMDo4MDgwL2hlbGxvIiwiaXNzIjoiaHR0cDovLzAuMC4wLjA6ODA4MC8iLCJleHAiOjI1Nzk4MDkxOTcsInVzZXJJZCI6IjIiLCJyb2xlIjoiYWRtaW4ifQ.ArgJqeaB2Nd4KH7bMf_7UPF4Npe_sYUoOLGcVShe29c")
    }

    override fun updateCategoryById(id: Int , newBrand: Category) {
        TODO("Not yet implemented")
    }

    override suspend fun addNewCategory(category: Category) {
        api.addNewCategory(category.toCategoryDTO(), "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJodHRwOi8vMC4wLjAuMDo4MDgwL2hlbGxvIiwiaXNzIjoiaHR0cDovLzAuMC4wLjA6ODA4MC8iLCJleHAiOjI1Nzk4MDkxOTcsInVzZXJJZCI6IjIiLCJyb2xlIjoiYWRtaW4ifQ.ArgJqeaB2Nd4KH7bMf_7UPF4Npe_sYUoOLGcVShe29c")
    }

    override fun getImageByItemId(id: Int) {
        TODO("Not yet implemented")
    }

    override fun addNewImage(image: Image) {
        TODO("Not yet implemented")
    }

    override fun deleteImageById(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun login(auth: AuthRequest): AuthResponse {
        val response = api.signIn(auth)
        tokenManager.saveToken(response.body()?.token ?: "")
        return AuthResponse(
            token = response.body()?.token ?: "",
            role = response.body()?.role ?: "user"
        )
    }
}