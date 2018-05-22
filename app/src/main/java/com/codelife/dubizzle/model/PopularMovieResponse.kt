package com.codelife.dubizzle.model

import com.google.gson.annotations.SerializedName

data class PopularMovieResponse(
        @SerializedName("page") val pageNumber: Int,
        @SerializedName("total_pages") val totalPages: Int,
        @SerializedName("results") var movieList: List<MovieDetail>
){
    init {
        movieList = ArrayList()
    }
}