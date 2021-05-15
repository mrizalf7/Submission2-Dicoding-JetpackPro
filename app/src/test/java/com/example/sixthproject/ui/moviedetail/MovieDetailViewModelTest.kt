package com.example.sixthproject.ui.moviedetail

import com.example.sixthproject.utils.NotDataDummy
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class MovieDetailViewModelTest {

    private lateinit var viewModel: MovieDetailViewModel
    private val notDummyMovie = NotDataDummy.generateMovies()[0]
    private val movieId = notDummyMovie.movieId

    @Before
    fun setUp(){

        viewModel = MovieDetailViewModel()
        viewModel.setSelectedMovie(movieId)
    }


    @Test
    fun getMovie() {
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(notDummyMovie.movieId, movieEntity.movieId)
        assertEquals(notDummyMovie.title, movieEntity.title)
        assertEquals(notDummyMovie.synopsis, movieEntity.synopsis)
        assertEquals(notDummyMovie.image, movieEntity.image)
        assertEquals(notDummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(notDummyMovie.score, movieEntity.score)
    }
}