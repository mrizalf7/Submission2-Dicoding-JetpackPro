package com.example.sixthproject.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.sixthproject.data.MovieRepository
import com.example.sixthproject.data.source.local.entity.MoviesEntity
import com.example.sixthproject.utils.NotDataDummy
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
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
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    private lateinit var observer: Observer<List<MoviesEntity>>
    @Mock
    private lateinit var movieRepository: MovieRepository

    @Test
    fun getMovies() {
        val notDummyMovies = NotDataDummy.generateMovies()
        val movies = MutableLiveData<List<MoviesEntity>>()
        movies.value = notDummyMovies

        `when`(movieRepository.getAllMovies()).thenReturn(movies)
        val movieEntities = viewModel.getMovies().value
        verify(movieRepository).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(13, movieEntities?.size)
        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(notDummyMovies)
    }
}