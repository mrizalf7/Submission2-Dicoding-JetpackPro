package com.example.sixthproject.ui.tvshows

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class TvShowsViewModelTest {

    private lateinit var viewModel: TvShowsViewModel

    @Before
    fun setUp() {
        viewModel = TvShowsViewModel()
    }

    @Test
    fun getMovies() {
        val tvShowEntities = viewModel.getTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(12, tvShowEntities.size)
    }
}