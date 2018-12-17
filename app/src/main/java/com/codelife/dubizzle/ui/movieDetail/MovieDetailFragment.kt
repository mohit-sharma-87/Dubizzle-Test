package com.codelife.dubizzle.ui.movieDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.codelife.dubizzle.R
import com.codelife.dubizzle.databinding.LayoutMovieDetailBinding
import com.codelife.dubizzle.model.MovieDetail
import com.codelife.dubizzle.ui.home.HomeActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.layout_movie_detail.*

/**
 * Created by mohitsharma on 22/05/18.
 */
class MovieDetailFragment : androidx.fragment.app.Fragment() {

    object Constant {
        const val MOVIE_DETAIL_KEY: String = "movieDetail"
    }

    companion object {
        fun newInstance(movieDetail: MovieDetail): MovieDetailFragment {
            val fragment = MovieDetailFragment()
            val bundle = Bundle()
            bundle.putString(Constant.MOVIE_DETAIL_KEY, Gson().toJson(movieDetail))
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val payload = arguments!!.getString(Constant.MOVIE_DETAIL_KEY, null)
        val movieDetail = Gson().fromJson(payload, MovieDetail::class.java)

        val binding = DataBindingUtil.inflate(layoutInflater, R.layout.layout_movie_detail, container, false) as LayoutMovieDetailBinding
        binding.detail = movieDetail
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setCoverImage()
    }

    private fun setCoverImage() {
        activity?.let {
            val payload = arguments!!.getString(Constant.MOVIE_DETAIL_KEY, null)
            val movieDetail = Gson().fromJson(payload, MovieDetail::class.java)
            Glide.with(it).load(movieDetail.getMovieCoverImageUrl()).into(iv_movie_detail_poster_image)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val activity = activity as HomeActivity
        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        val activity = activity as HomeActivity
        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(false)
    }

}