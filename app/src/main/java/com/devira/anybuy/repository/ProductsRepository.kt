package com.devira.anybuy.repository

import com.devira.anybuy.model.Product
import com.devira.anybuy.util.Resource
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getAllProducts(): Flow<Resource<List<Product>>>
}