package com.codelife.dubizzle

import com.codelife.dubizzle.model.MovieDetail
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class MovieDetailsUnitTest {

    private lateinit var movieDetail: MovieDetail


    @Before
    fun setup() {
        movieDetail = MovieDetail(1, 2L, 4.2f, "TestMovie",
                coverImage = "coverageImage", imagePath = "imagePath", overview = "overView",
                releaseDate = Date(99 ,10 ,15))
    }

    @Test
    fun test_default_values() {

        Assert.assertEquals(1,movieDetail.voteCount)
        Assert.assertEquals(4.2f,movieDetail.rating)
        Assert.assertEquals(2L,movieDetail.movieId)
        Assert.assertEquals("TestMovie",movieDetail.title)
        Assert.assertEquals("overView",movieDetail.overview)
        Assert.assertEquals(Date(99 ,10 ,15),movieDetail.releaseDate)


        val posterImageUrl = BuildConfig.IMAGE_BASE_URL + "imagePath"
        Assert.assertEquals(posterImageUrl, movieDetail.getMoviePosterImageUrl())

        val coverImageUrl = BuildConfig.IMAGE_BASE_URL + "coverageImage"
        Assert.assertEquals(coverImageUrl, movieDetail.getMovieCoverImageUrl())

        val releaseDate = "15-Nov-1999"
        Assert.assertEquals(releaseDate, movieDetail.getFormatedReleaseDate())
    }


}