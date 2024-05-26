package com.devira.anybuy.remote

import com.devira.anybuy.remote.dto.ProductDto
import retrofit2.http.GET

interface FakeStoreApi {

    @GET("products")
    suspend fun getAllProducts(): List<ProductDto>
}