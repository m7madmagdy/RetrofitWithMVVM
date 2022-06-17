package com.example.bookapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookapp.databinding.ActivityMainBinding
import com.example.bookapp.ui.adapter.PostAdapter
import com.example.bookapp.ui.api.PostModel
import com.example.bookapp.ui.viewModel.PostViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var postViewModel: PostViewModel
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postViewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        postViewModel.getPosts(this)

        postAdapter = PostAdapter()
        val recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = postAdapter

        postViewModel.postMutableLiveData.observe(this) {
            postAdapter.setData(it)
            binding.progressBar.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }
    }
}