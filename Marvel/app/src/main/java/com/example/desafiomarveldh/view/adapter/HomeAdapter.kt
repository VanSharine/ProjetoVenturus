package com.example.desafiomarveldh.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafiomarveldh.R
import com.example.desafiomarveldh.databinding.HomeListComicsBinding
import com.example.desafiomarveldh.model.Result

class HomeAdapter(
        private val onComicClick: (Result?) -> Unit
) : PagedListAdapter<Result, HomeAdapter.ViewHolder>(Result.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HomeListComicsBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it, onComicClick) }
    }

    class ViewHolder(
            val binding: HomeListComicsBinding
    ) : RecyclerView.ViewHolder(
            binding.root
    ) {
        fun bind(movieList: Result, onComicClick: (Result) -> Unit) = with(binding) {
            Glide.with(itemView.context)
                    .load(movieList.thumbnail?.path)
                     .placeholder(R.drawable.notfound)
                    .into(ivComicsPoster)
            tvComicsName.text = "#${movieList.issueNumber?.toInt()}"

            itemView.setOnClickListener {
                onComicClick(movieList)
            }
        }
    }
}