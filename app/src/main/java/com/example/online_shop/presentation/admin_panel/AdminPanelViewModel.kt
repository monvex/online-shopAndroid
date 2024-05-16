package com.example.online_shop.presentation.admin_panel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.online_shop.domain.models.Brand
import com.example.online_shop.domain.models.Category
import com.example.online_shop.domain.repository.OnlineShopRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class AdminPanelViewModel @Inject constructor(
    private val repository: OnlineShopRepository
): ViewModel()
{
    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories

    private val _brands = MutableStateFlow<List<Brand>>(emptyList())
    val brands: StateFlow<List<Brand>> = _brands

    init {
        viewModelScope.launch {
            getCategories()
            getBrands()
        }
    }


    suspend fun getCategories() {
        _categories.value = repository.getCategories()
    }

    fun deleteCategory(title: String){
        viewModelScope.launch {
            repository.deleteCategoryByTitle(title)
            getCategories()
        }
    }

    fun addNewCategory(title: String){
        viewModelScope.launch {
            repository.addNewCategory(Category(title))
            getCategories()
        }
    }

    suspend fun getBrands() {
        _brands.value = repository.getBrands()
    }

    fun deleteBrand(title: String){
        viewModelScope.launch {
            repository.deleteBrandByTitle(title)
            getBrands()
        }
    }

    fun addNewBrand(title: String){
        viewModelScope.launch {
            repository.addNewBrand(Brand(title))
            getBrands()
        }
    }
}