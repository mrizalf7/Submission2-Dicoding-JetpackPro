package com.example.sixthproject.ui.tvshows

import com.example.sixthproject.data.MovieRepository
import com.example.sixthproject.utils.NotDataDummy
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowsViewModelTest {

    private lateinit var viewModel: TvShowsViewModel

    @Before
    fun setUp() {
        viewModel = TvShowsViewModel(movieRepository)
    }
    @Mock
    private lateinit var movieRepository: MovieRepository

    @Test
    fun getMovies() {
        `when`(movieRepository.getAllTvShows()).thenReturn(NotDataDummy.generateTvShows())
        val tvShowEntities = viewModel.getTvShows()
        verify(movieRepository).getAllTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(12, tvShowEntities.size)
    }
}