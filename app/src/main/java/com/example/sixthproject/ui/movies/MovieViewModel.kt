package com.example.sixthproject.ui.movies

import androidx.lifecycle.ViewModel
import com.example.sixthproject.data.MoviesEntity
import com.example.sixthproject.utils.NotDataDummy

class MovieViewModel: ViewModel() {
    fun getMovies():ArrayList<MoviesEntity> = NotDataDummy.generateMovies()
}