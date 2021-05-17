package com.example.sixthproject.ui.moviedetail

import com.example.sixthproject.data.MovieRepository
import com.example.sixthproject.utils.NotDataDummy
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieDetailViewModelTest {

    private lateinit var viewModel: MovieDetailViewModel
    private val notDummyMovie = NotDataDummy.generateMovies()[0]
    private val movieId = notDummyMovie.movieId

    @Before
    fun setUp(){

        viewModel = MovieDetailViewModel(movieRepository)
        viewModel.setSelectedMovie(movieId)
    }
    @Mock
    private lateinit var movieRepository: MovieRepository


    @Test
    fun getMovie() {
        `when`(movieRepository.getMovieById(movieId)).thenReturn(notDummyMovie)
        val movieEntity = viewModel.getMovie()
        verify(movieRepository).getMovieById(movieId)
        assertNotNull(movieEntity)
        assertEquals(notDummyMovie.movieId, movieEntity.movieId)
        assertEquals(notDummyMovie.title, movieEntity.title)
        assertEquals(notDummyMovie.synopsis, movieEntity.synopsis)
        assertEquals(notDummyMovie.image, movieEntity.image)
        assertEquals(notDummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(notDummyMovie.score, movieEntity.score)
    }
}