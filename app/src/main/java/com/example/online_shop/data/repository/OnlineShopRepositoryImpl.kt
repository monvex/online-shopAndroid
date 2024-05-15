package com.example.online_shop.data.repository

import android.media.Image
import com.example.online_shop.data.remote.CategoryDTO
import com.example.online_shop.data.remote.OnlineShopApi
import com.example.online_shop.data.remote.toCategory
import com.example.online_shop.domain.models.Brand
import com.example.online_shop.domain.models.Category
import com.example.online_shop.domain.models.Item
import com.example.online_shop.domain.repository.OnlineShopRepository
import javax.inject.Inject

class OnlineShopRepositoryImpl @Inject constructor(
    private val api: OnlineShopApi
) : OnlineShopRepository {
    override fun getItems(): List<Item> {
        TODO("Not yet implemented")
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

    override fun getBrands(): List<Brand> {
        TODO("Not yet implemented")
    }

    override fun deleteBrandById(id: Int) {
        TODO("Not yet implemented")
    }

    override fun updateBrandById(id: Int , newBrand: Brand) {
        TODO("Not yet implemented")
    }

    override fun addNewBrand(brand: Brand) {
        TODO("Not yet implemented")
    }

    override suspend fun getCategories(): List<Category> {

        return api.getCategories("[{\"key\":\"Authorization\",\"value\":\"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJodHRwOi8vMC4wLjAuMDo4MDgwL2hlbGxvIiwiaXNzIjoiaHR0cDovLzAuMC4wLjA6ODA4MC8iLCJleHAiOjE3NDM0MDYxMzMsInVzZXJJZCI6IjYiLCJyb2xlIjoiYWRtaW4ifQ.4AS1e-Vlogi-H_RbbkbPEJy52SLAqAGrp-Ot28UtxGo\",\"description\":\"\",\"type\":\"text\",\"enabled\":true}]").map { categoryDTO -> categoryDTO.toCategory()  }
    }

    override fun deleteCategoryById(id: Int) {
        TODO("Not yet implemented")
    }

    override fun updateCategoryById(id: Int , newBrand: Category) {
        TODO("Not yet implemented")
    }

    override fun addNewCategory(brand: Category) {
        TODO("Not yet implemented")
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
}