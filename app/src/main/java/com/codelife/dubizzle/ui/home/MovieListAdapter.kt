package com.codelife.dubizzle.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.codelife.dubizzle.databinding.LayoutItemMovieBinding
import com.codelife.dubizzle.model.MovieDetail
import com.codelife.dubizzle.ui.ListViewHolder

class MovieListAdapter(val movieList: List<MovieDetail>) : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {

    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(parent.context)
        return ListViewHolder(LayoutItemMovieBinding.inflate(inflater)!!)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
        val binding :LayoutItemMovieBinding  = ((holder as ListViewHolder).binding) as LayoutItemMovieBinding
        binding.detail = movieList[position]
        Glide.with(context).load(movieList[position].getMoviePosterImageUrl()).into(binding.ivPosterImage)
    }

}