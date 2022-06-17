package com.example.bookapp.ui.api

import retrofit2.Call
import retrofit2.http.GET

interface PostInterface {
    @GET("posts")
    fun getPosts(): Call<List<PostModel>>
}