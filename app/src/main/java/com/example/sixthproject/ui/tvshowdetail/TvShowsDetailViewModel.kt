package com.example.sixthproject.ui.tvshowdetail

import androidx.lifecycle.ViewModel
import com.example.sixthproject.data.TvShowsEntity
import com.example.sixthproject.utils.NotDataDummy

class TvShowsDetailViewModel: ViewModel() {

    private lateinit var tvShowId: String

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getTvShow(): TvShowsEntity {
        lateinit var tvShow: TvShowsEntity
        val tvShowsEntities = NotDataDummy.generateTvShows()
        for (tvShowsEntity in tvShowsEntities) {
            if (tvShowsEntity.tvShowId == tvShowId) {
                tvShow = tvShowsEntity
            }
        }
        return tvShow
    }

}