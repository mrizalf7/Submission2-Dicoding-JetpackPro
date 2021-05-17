package com.example.sixthproject.ui.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.sixthproject.data.source.local.entity.MoviesEntity
import com.example.sixthproject.data.MovieRepository

class MovieDetailViewModel(private val movieDetail: MovieRepository): ViewModel() {

    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }
    fun getMovie(): LiveData<MoviesEntity> = movieDetail.getMovieById(movieId)


}