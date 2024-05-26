package com.devira.anybuy.remote.dto

import com.devira.anybuy.model.Product

data class ProductDto(
    val id: Int,
    val title: String,
    val price: Float,
    val description: String,
    val image: String,
    val category: String
)

fun ProductDto.toModel(): Product = Product(
    id = this.id,
    title = this.title,
    price = this.price,
    description = this.description,
    image = this.image,
    category = this.category
)
