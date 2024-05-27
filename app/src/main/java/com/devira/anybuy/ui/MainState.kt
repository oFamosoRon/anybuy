package com.devira.anybuy.ui

import com.devira.anybuy.model.Product

data class MainState(
    val products: List<Product> = emptyList(),
    val isLoadingProducts: Boolean = false
)