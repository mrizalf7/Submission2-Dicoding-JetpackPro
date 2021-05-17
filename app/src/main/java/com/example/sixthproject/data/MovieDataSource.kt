package com.example.sixthproject.data

import androidx.lifecycle.LiveData
import com.example.sixthproject.data.source.local.entity.MoviesEntity
import com.example.sixthproject.data.source.local.entity.TvShowsEntity

interface MovieDataSource {

    fun getAllMovies(): LiveData<List<MoviesEntity>>

    fun getAllTvShows(): LiveData<List<TvShowsEntity>>

    fun getMovieById(movieId: String): LiveData<MoviesEntity>

    fun getTvShowById(tvShowId: String): LiveData<TvShowsEntity>
}





