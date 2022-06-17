package com.example.bookapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapp.R
import com.example.bookapp.ui.api.PostModel

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    private var movieList: List<PostModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.post_items, parent, false) as ViewGroup
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(movieList: List<PostModel>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

    inner class PostViewHolder(itemView: ViewGroup) : RecyclerView.ViewHolder(itemView) {
        fun bind(postModel: PostModel) {
            val idTv = itemView.findViewById<TextView>(R.id.idTv)
            val titleTv = itemView.findViewById<TextView>(R.id.titleTv)
            val bodyTv = itemView.findViewById<TextView>(R.id.bodyTv)
            idTv.text = postModel.id.toString()
            titleTv.text = postModel.title
            bodyTv.text = postModel.body
        }
    }
}

