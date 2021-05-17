package com.example.sixthproject.ui.tvshowdetail

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
class TvShowsDetailViewModelTest {

    private lateinit var viewModel: TvShowsDetailViewModel
    private val notDummyTvShow = NotDataDummy.generateTvShows()[0]
    private val tvShowId = notDummyTvShow.tvShowId


    @Before
    fun setUp(){

        viewModel = TvShowsDetailViewModel(movieRepository)
        viewModel.setSelectedTvShow(tvShowId)
    }
    @Mock
    private lateinit var movieRepository: MovieRepository

    @Test
    fun getTvShow() {
        `when`(movieRepository.getTvShowById(tvShowId)).thenReturn(notDummyTvShow)
        val tvShowEntity = viewModel.getTvShow()
        verify(movieRepository).getTvShowById(tvShowId)
        assertNotNull(tvShowEntity) // the value we want to test
        assertEquals(notDummyTvShow.tvShowId, tvShowEntity.tvShowId)
        assertEquals(notDummyTvShow.title, tvShowEntity.title)
        assertEquals(notDummyTvShow.synopsis, tvShowEntity.synopsis)
        assertEquals(notDummyTvShow.image, tvShowEntity.image)
        assertEquals(notDummyTvShow.firstEpisode, tvShowEntity.firstEpisode)
        assertEquals(notDummyTvShow.lastEpisode, tvShowEntity.lastEpisode)
        assertEquals(notDummyTvShow.totalEpisode, tvShowEntity.totalEpisode)
        assertEquals(notDummyTvShow.totalSeason, tvShowEntity.totalSeason)
        assertEquals(notDummyTvShow.score, tvShowEntity.score)
    }
}