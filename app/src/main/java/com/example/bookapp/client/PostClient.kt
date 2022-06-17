package com.example.bookapp.client

import com.example.bookapp.ui.api.PostInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PostClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    fun create(): PostInterface {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofitBuilder.create(PostInterface::class.java)
    }
}