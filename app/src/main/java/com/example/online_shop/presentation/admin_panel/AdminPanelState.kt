package com.example.online_shop.presentation.admin_panel

import com.example.online_shop.domain.models.Category

data class CategoriesAdminState(
    val categories: List<Category> = emptyList()
)