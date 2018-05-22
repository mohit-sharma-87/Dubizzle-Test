package com.codelife.dubizzle.model

import com.codelife.dubizzle.BuildConfig
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

data class MovieDetail(
        @SerializedName("vote_count") val voteCount: Int,
        @SerializedName("id") val movieId: Long,
        @SerializedName("vote_average") val rating: Float,
        @SerializedName("title") val title: String,
        @SerializedName("poster_path") private val imagePath: String,
        @SerializedName("backdrop_path") private val coverImage: String,
        @SerializedName("overview") val overview: String,
        @SerializedName("release_date") val releaseDate: Date
) {

    fun getMoviePosterImageUrl(): String {
        return BuildConfig.IMAGE_BASE_URL + imagePath
    }

    fun getMovieCoverImageUrl(): String {
        return BuildConfig.IMAGE_BASE_URL + coverImage
    }

    fun getFormatedReleaseDate():String{
        return SimpleDateFormat("dd-MMM-yyyy").format(releaseDate)
    }

}





