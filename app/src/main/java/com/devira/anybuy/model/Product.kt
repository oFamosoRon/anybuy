package com.devira.anybuy.model

data class Product(
    val id: Int = 0,
    val title: String = "",
    val price: Float = 0F,
    val description: String = "",
    val image: String = "",
    val category: String = ""
)
