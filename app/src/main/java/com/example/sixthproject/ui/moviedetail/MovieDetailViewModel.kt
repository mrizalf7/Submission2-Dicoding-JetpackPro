package com.example.sixthproject.ui.moviedetail

import androidx.lifecycle.ViewModel
import com.example.sixthproject.data.MoviesEntity
import com.example.sixthproject.utils.NotDataDummy

class MovieDetailViewModel: ViewModel() {

    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovie(): MoviesEntity {
        lateinit var movie: MoviesEntity
        val moviesEntities = NotDataDummy.generateMovies()
        for (movieEntity in moviesEntities) {
            if (movieEntity.movieId == movieId) {
                movie = movieEntity
            }
        }
        return movie
    }

}