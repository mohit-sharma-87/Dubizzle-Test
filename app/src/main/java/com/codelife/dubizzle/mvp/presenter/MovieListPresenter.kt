package com.codelife.dubizzle.mvp.presenter

import com.codelife.dubizzle.dataService.DataServiceFactory
import com.codelife.dubizzle.model.MovieDetail
import com.codelife.dubizzle.mvp.contracts.MovieListContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MovieListPresenter : MovieListContract.Presenter {

    private lateinit var view: MovieListContract.View
    private var disposable: Disposable? = null
    private val webService by lazy {
        DataServiceFactory.create()
    }

    override fun start(view: MovieListContract.View) {
        this.view = view
    }

    override fun getPopularMovieList(pageNo: Long) {
        view.showProgressDialog()
        disposable = webService.getPopularMovies(pageNo = pageNo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->
                            kotlin.run {
                                view.dismissProgressDialog()
                                view.onMovieList(result.movieList)

                            }
                        },
                        { error ->
                            kotlin.run {
                                view.dismissProgressDialog()
                                view.showMessage("Unexpected Error")
                            }
                        }
                )
    }

    override fun filterMovieList(minYear: Int, maxYear: Int, unSortedList: List<MovieDetail>) {
        view.showProgressDialog()
        val thread = Thread {
            val filteredList = unSortedList.filter { it.releaseDate.year in ((minYear - 1900) + 1)..((maxYear - 1900) - 1) }
            view.dismissProgressDialog()
            view.onMovieList(filteredList)
        }
        thread.start()
    }


    override fun stop() {
    }
}
