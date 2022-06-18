package com.example.bookapp.ui.api

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface PostInterface {
    @GET("posts")
    fun getPosts(): Observable<ArrayList<PostModel>>
}