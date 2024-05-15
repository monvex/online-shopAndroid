package com.example.online_shop.presentation.admin_panel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.online_shop.domain.models.Category
import com.example.online_shop.domain.repository.OnlineShopRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AdminPanelViewModel @Inject constructor(
    private val repository: OnlineShopRepository
): ViewModel() {

}