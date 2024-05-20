package com.example.online_shop.presentation.user_shop.main_screen

import android.graphics.Bitmap
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.online_shop.data.dataStore.TokenManager
import com.example.online_shop.domain.models.Brand
import com.example.online_shop.domain.models.Category
import com.example.online_shop.domain.models.Item
import com.example.online_shop.domain.repository.OnlineShopRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class UserShopMainScreenViewModel @Inject constructor(
    private val tokenManager: TokenManager,
    private val repository: OnlineShopRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val savedState = savedStateHandle

    companion object {
        private val USER_CART = "user_cart"
    }


    private var token: String? = null
    var role: String? = null

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories

    private val _brands = MutableStateFlow<List<Brand>>(emptyList())
    val brands: StateFlow<List<Brand>> = _brands

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> = _items

    private val _shoppingCart = MutableStateFlow<MutableList<Item>>(mutableListOf())
    val shoppingCart: StateFlow<MutableList<Item>> = _shoppingCart

    private val _shoppingCartSize = MutableStateFlow<Int>(0)
    val shoppingCartSize: StateFlow<Int> = _shoppingCartSize

    val baseImageUrl: String = "http://192.168.0.105:8080/images/"
    var bitmap: Bitmap? = null


    fun getCurrentShoppingCart(): MutableList<Item> {
        return savedState.get(USER_CART)?: mutableListOf<Item>()
    }

    fun saveCurrentShoppingCart(cart: MutableList<Item>) {
        savedState.set(USER_CART, cart)
    }


    suspend fun getImage() {
        val response = repository.getImageById(id = "images/avatar82572816.jpg", token.toString())
    }




    init {
        _shoppingCart.value = getCurrentShoppingCart()
        runBlocking {
            token = tokenManager.getToken().first()
            role = tokenManager.getRole().first()
            getItems()
        }

        viewModelScope.launch {
            getCategories()
        }
        viewModelScope.launch {
            getBrands()
        }

    }

    suspend fun buyItemsFromShoppingCart(): Double{
        return repository.buyItemsFromShoppingCart(_shoppingCart.value , token = token.toString())
    }

    fun addItemToShoppingCart(item: Item) {
        _shoppingCart.value = mutableListOf<Item>().apply {
            for(i in _shoppingCart.value) {
                add(i)
            }
            add(item)
        }
        _shoppingCartSize.value = _shoppingCart.value.size
        saveCurrentShoppingCart(_shoppingCart.value)
    }



    suspend fun getCategories() {
        _categories.value = repository.getCategories(token.toString())
    }

    suspend fun getItems() {
        _items.value = repository.getItems(token.toString())
    }

    suspend fun getBrands() {
        _brands.value = repository.getBrands(token.toString())
    }
}