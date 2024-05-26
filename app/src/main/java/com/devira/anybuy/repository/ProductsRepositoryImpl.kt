package com.devira.anybuy.repository

import com.devira.anybuy.model.Product
import com.devira.anybuy.remote.FakeStoreApi
import com.devira.anybuy.remote.dto.toModel
import com.devira.anybuy.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val fakeStoreApi: FakeStoreApi
) : ProductsRepository {

    override suspend fun getAllProducts(): Flow<Resource<List<Product>>> = flow {
        try {
            emit(Resource.Loading())
            val result = fakeStoreApi.getAllProducts()
            emit(Resource.Success(result.map { it.toModel() }))
        } catch (e: Exception) {
            emit(Resource.Error("some exception"))
        }
    }
}