package com.example.sixthproject.ui.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.sixthproject.data.source.local.entity.TvShowsEntity
import com.example.sixthproject.data.MovieRepository

class TvShowsViewModel(private val tvShowRepository: MovieRepository): ViewModel() {

    fun getTvShows(): LiveData<List<TvShowsEntity>> = tvShowRepository.getAllTvShows()

}