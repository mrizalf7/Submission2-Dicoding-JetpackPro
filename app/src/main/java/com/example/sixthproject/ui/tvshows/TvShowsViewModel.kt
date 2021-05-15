package com.example.sixthproject.ui.tvshows

import androidx.lifecycle.ViewModel
import com.example.sixthproject.data.TvShowsEntity
import com.example.sixthproject.utils.NotDataDummy

class TvShowsViewModel: ViewModel() {

    fun getTvShows():ArrayList<TvShowsEntity> = NotDataDummy.generateTvShows()

}