package com.devira.anybuy.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    companion object {
        private const val BASE_URL = "https://fakestoreapi.com/"

        private val retrofit: Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api: FakeStoreApi = retrofit.create(FakeStoreApi::class.java)
    }
}