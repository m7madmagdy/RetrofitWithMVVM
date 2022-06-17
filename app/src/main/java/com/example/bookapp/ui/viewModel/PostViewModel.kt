package com.example.bookapp.ui.viewModel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookapp.client.PostClient
import com.example.bookapp.ui.api.PostModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {
    val postMutableLiveData = MutableLiveData<List<PostModel>>()

    fun getPosts(context: Context) {
        PostClient.create().getPosts().enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                if (response.isSuccessful) {
                    postMutableLiveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
            }
        })
    }
}