package com.example.sixthproject.ui.tvshowdetail

import com.example.sixthproject.utils.NotDataDummy
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class TvShowsDetailViewModelTest {

    private lateinit var viewModel: TvShowsDetailViewModel
    private val notDummyTvShow = NotDataDummy.generateTvShows()[0]
    private val tvShowId = notDummyTvShow.tvShowId


    @Before
    fun setUp(){

        viewModel = TvShowsDetailViewModel()
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShow() {
        val tvShowEntity = viewModel.getTvShow()
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