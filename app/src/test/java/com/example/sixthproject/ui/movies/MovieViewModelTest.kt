package com.example.sixthproject.ui.movies

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
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel
    
    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieRepository)
    }

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Test
    fun getMovies() {
        `when`(movieRepository.getAllMovies()).thenReturn(NotDataDummy.generateMovies())
        val movieEntities = viewModel.getMovies()
        verify(movieRepository).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(13, movieEntities.size)
    }
}