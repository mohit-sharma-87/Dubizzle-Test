package com.codelife.dubizzle.dataService

import com.codelife.dubizzle.BuildConfig
import com.codelife.dubizzle.model.PopularMovieResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by mohitsharma on 29/08/17.
 */

interface EndPoints {

    @GET("movie/top_rated")
    fun getPopularMovies(@Query("api_key") apiKey: String = BuildConfig.API_KEY,
                         @Query("page") pageNo: Long): Observable<PopularMovieResponse>

}
