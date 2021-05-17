package com.example.sixthproject.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sixthproject.data.MovieRepository
import com.example.sixthproject.di.Injection
import com.example.sixthproject.ui.moviedetail.MovieDetailViewModel
import com.example.sixthproject.ui.movies.MovieViewModel
import com.example.sixthproject.ui.tvshowdetail.TvShowsDetailViewModel
import com.example.sixthproject.ui.tvshows.TvShowsViewModel

class ViewModelFactory private constructor(private val mMovieRepository: MovieRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(MovieDetailViewModel::class.java) -> {
                return MovieDetailViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(TvShowsViewModel::class.java) -> {
                return TvShowsViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(TvShowsDetailViewModel::class.java) -> {
                return TvShowsDetailViewModel(mMovieRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}







