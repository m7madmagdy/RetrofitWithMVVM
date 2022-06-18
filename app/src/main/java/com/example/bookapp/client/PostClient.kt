package com.example.bookapp.client

import com.example.bookapp.ui.api.PostInterface
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object PostClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    fun create(): PostInterface {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofitBuilder.create(PostInterface::class.java)
    }
}