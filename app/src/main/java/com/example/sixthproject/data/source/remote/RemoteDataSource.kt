package com.example.sixthproject.data.source.remote

import android.os.Handler
import android.os.Looper
import com.example.sixthproject.data.source.remote.response.MoviesResponse
import com.example.sixthproject.data.source.remote.response.TvShowsResponse
import com.example.sixthproject.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())


    companion object {

        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies(callback: LoadMoviesCallback) {
        handler.postDelayed({ callback.onAllMoviesReceived(jsonHelper.loadMovies()) }, SERVICE_LATENCY_IN_MILLIS)
    }
    fun getAllTvShows(callback: LoadTvShowsCallback) {
        handler.postDelayed({ callback.onAllTvShowsReceived(jsonHelper.loadTvShows()) }, SERVICE_LATENCY_IN_MILLIS)
    }
    

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponses: List<MoviesResponse>)
    }
    interface LoadTvShowsCallback {
        fun onAllTvShowsReceived(tvShowResponses: List<TvShowsResponse>)
    }
}
