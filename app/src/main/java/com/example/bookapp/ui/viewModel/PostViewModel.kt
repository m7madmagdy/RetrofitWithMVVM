package com.example.bookapp.ui.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookapp.client.PostClient
import com.example.bookapp.ui.api.PostModel
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.schedulers.Schedulers

class PostViewModel : ViewModel() {
    val postMutableLiveData = MutableLiveData<List<PostModel>>()

    fun getPosts(context: Context) {
        val observable = PostClient.create().getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        val observer = object : Observer<ArrayList<PostModel>> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: ArrayList<PostModel>) {
                postMutableLiveData.value = t
            }

            override fun onError(e: Throwable) {
                Toast.makeText(context, "Error No Internet Connection", Toast.LENGTH_LONG).show()
            }

            override fun onComplete() {
            }
        }
        observable.subscribe(observer)
    }
}