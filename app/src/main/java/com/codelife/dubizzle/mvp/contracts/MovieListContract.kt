package com.codelife.dubizzle.mvp.contracts

import com.codelife.dubizzle.model.MovieDetail
import com.codelife.dubizzle.mvp.IPresenter
import com.codelife.dubizzle.mvp.IView

interface MovieListContract {

    interface Presenter : IPresenter<View> {

        fun getPopularMovieList(pageNo: Long)

        fun filterMovieList(minYear: Int, maxYear: Int, unSortedList: List<MovieDetail>)
    }


    interface View : IView {

        fun onMovieList(movieList : List<MovieDetail>)
    }

}
