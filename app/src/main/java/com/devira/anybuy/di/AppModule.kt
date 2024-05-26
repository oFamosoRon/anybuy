package com.devira.anybuy.di

import com.devira.anybuy.remote.FakeStoreApi
import com.devira.anybuy.remote.Network
import com.devira.anybuy.repository.ProductsRepository
import com.devira.anybuy.repository.ProductsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideFakeStoreApi(): FakeStoreApi {
        return Network.api
    }

    @Provides
    fun provideProductsRepository(fakeStoreApi: FakeStoreApi): ProductsRepository {
        return ProductsRepositoryImpl(fakeStoreApi = fakeStoreApi)
    }
}