package com.example.sixthproject.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.sixthproject.data.source.local.entity.MoviesEntity
import com.example.sixthproject.data.MovieRepository

class MovieViewModel(private val movieRepository: MovieRepository): ViewModel() {

    fun getMovies(): LiveData<List<MoviesEntity>> = movieRepository.getAllMovies()

}