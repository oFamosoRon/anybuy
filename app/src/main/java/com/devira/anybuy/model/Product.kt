package com.devira.anybuy.model

data class Product(
    val id: Int,
    val title: String,
    val price: Float,
    val description: String,
    val image: String,
    val category: String
)
