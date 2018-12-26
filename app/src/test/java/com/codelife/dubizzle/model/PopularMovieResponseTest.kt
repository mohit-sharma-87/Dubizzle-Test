package com.codelife.dubizzle.model

import com.codelife.dubizzle.model.MovieDetail
import com.codelife.dubizzle.model.PopularMovieResponse
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class PopularMovieResponseTest {

    private lateinit var movieResponseTest: PopularMovieResponse

    @Before
    fun setup() {
        val movieDetail = MovieDetail(1, 2L, 4.2f, "TestMovie",
                coverImage = "coverageImage", imagePath = "imagePath", overview = "overView",
                releaseDate = Date(99, 10, 15))

        val movieList  = listOf(movieDetail)
        movieResponseTest = PopularMovieResponse(1, 2, movieList)
    }


    @Test
    fun testDefaultValue() {
        Assert.assertEquals(1,movieResponseTest.pageNumber)
        Assert.assertEquals(2,movieResponseTest.totalPages)
    }

}