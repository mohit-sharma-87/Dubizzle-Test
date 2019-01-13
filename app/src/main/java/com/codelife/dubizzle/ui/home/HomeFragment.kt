package com.codelife.dubizzle.ui.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.codelife.dubizzle.R
import com.codelife.dubizzle.model.MovieDetail
import com.codelife.dubizzle.mvp.contracts.MovieListContract
import com.codelife.dubizzle.mvp.presenter.MovieListPresenter
import com.codelife.dubizzle.ui.movieDetail.MovieDetailFragment
import com.codelife.dubizzle.utils.ItemClickSupport
import com.codelife.dubizzle.utils.SpacesItemDecoration
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.layout_movie_list.*

class HomeFragment : androidx.fragment.app.Fragment(), MovieListContract.View {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val presenter by lazy {
        MovieListPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.layout_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_movie_list.layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 2)
        rv_movie_list.addItemDecoration(SpacesItemDecoration(2, 10, true))
        presenter.start(this)
        presenter.getPopularMovieList(1)
        ItemClickSupport.addTo(rv_movie_list).setOnItemClickListener(itemClickLister)

        fab_sort.setOnClickListener({
            showDialog()
        })
    }

    private fun showDialog() {
        val filterDialog = AlertDialog.Builder(context)
        val view = layoutInflater.inflate(R.layout.layout_filter_dialog, null);

        filterDialog
                .setView(view)
                .setPositiveButton("Ok", { dialog: DialogInterface?, which: Int ->
                    val minValue = view.findViewById<EditText>(R.id.et_min).text.toString().toInt()
                    val maxValue = view.findViewById<EditText>(R.id.et_max).text.toString().toInt()

                    if (maxValue > minValue) {
                        val dataSource = rv_movie_list.adapter as MovieListAdapter
                        presenter.filterMovieList(minValue, maxValue, dataSource.movieList);
                    } else {
                        Toast.makeText(context, getString(R.string.error_filter), Toast.LENGTH_LONG).show()
                    }
                })
                .setNegativeButton("Reset", { dialog: DialogInterface, i: Int ->
                    presenter.getPopularMovieList(1)
                }).show()
    }

    override fun onMovieList(movieList: List<MovieDetail>) {
        activity?.runOnUiThread { rv_movie_list.adapter = MovieListAdapter(movieList) }
    }

    override fun showProgressDialog() {
        pb_progress_bar.visibility = View.VISIBLE
    }

    override fun dismissProgressDialog() {
        activity?.runOnUiThread { pb_progress_bar.visibility = View.GONE }
    }

    override fun showMessage(message: String) {
        val view = activity!!.findViewById<View>(android.R.id.content)
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }

    private val itemClickLister = ItemClickSupport.OnItemClickListener { recyclerView, position, v ->
        run {
            val adapter = recyclerView.adapter as MovieListAdapter
            val fragment = MovieDetailFragment.newInstance(adapter.movieList[position])
            activity?.supportFragmentManager!!
                    .beginTransaction()
                    .add(R.id.container, fragment)
                    .hide(this)
                    .addToBackStack(null).commit()
        }
    }


}
