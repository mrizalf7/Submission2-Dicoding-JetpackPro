package com.example.sixthproject.ui.tvshowdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.sixthproject.data.source.local.entity.TvShowsEntity
import com.example.sixthproject.data.MovieRepository

class TvShowsDetailViewModel(private val tvShowDetail: MovieRepository): ViewModel() {

    private lateinit var tvShowId: String

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }


    fun getTvShow(): LiveData<TvShowsEntity> = tvShowDetail.getTvShowById(tvShowId)

}