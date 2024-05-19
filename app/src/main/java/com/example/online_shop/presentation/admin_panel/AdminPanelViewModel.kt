package com.example.online_shop.presentation.admin_panel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.online_shop.data.dataStore.TokenManager
import com.example.online_shop.domain.models.Brand
import com.example.online_shop.domain.models.Category
import com.example.online_shop.domain.models.Item
import com.example.online_shop.domain.models.User
import com.example.online_shop.domain.models.UserToDB
import com.example.online_shop.domain.repository.OnlineShopRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AdminPanelViewModel @Inject constructor(
    private val repository: OnlineShopRepository,
    private val tokenManager: TokenManager
): ViewModel()
{
    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories

    private val _brands = MutableStateFlow<List<Brand>>(emptyList())
    val brands: StateFlow<List<Brand>> = _brands

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> = _items

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    private val _token: String? = null
    var token = _token

    init {
        runBlocking {
            token = tokenManager.getToken().first()
        }
        viewModelScope.launch {
            getCategories()
            getBrands()
            getItems()
            getUsers()
        }
    }


    suspend fun getCategories() {
        _categories.value = repository.getCategories(token.toString())
    }

    fun deleteCategory(title: String){
        viewModelScope.launch {
            repository.deleteCategoryByTitle(title, token.toString())
            getCategories()
        }
    }

    fun addNewCategory(title: String){
        viewModelScope.launch {
            repository.addNewCategory(Category(title), token.toString())
            getCategories()
        }
    }

    suspend fun getBrands() {
        _brands.value = repository.getBrands(token.toString())
    }

    fun deleteBrand(title: String){
        viewModelScope.launch {
            repository.deleteBrandByTitle(title, token.toString())
            getBrands()
        }
    }

    fun addNewBrand(title: String){
        viewModelScope.launch {
            repository.addNewBrand(Brand(title), token.toString())
            getBrands()
        }
    }

    suspend fun getItems() {
        _items.value = repository.getItems(token.toString())
    }

    fun deleteItem(id: Int){
        viewModelScope.launch {
            repository.deleteItemById(id, token.toString())
            getItems()
        }
    }

    suspend fun getUsers() {
        _users.value = repository.getUsers(token.toString())
    }

    fun deleteUser(id: Int){
        viewModelScope.launch {
            repository.deleteUserById(id, token.toString())
            getBrands()
        }
    }

    fun addNewUser(user: UserToDB){
        viewModelScope.launch {
            repository.addNewUser(user, token.toString())
            getBrands()
        }
    }
}