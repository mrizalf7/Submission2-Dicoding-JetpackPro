package com.example.sixthproject.di

import android.content.Context
import com.example.sixthproject.data.MovieRepository
import com.example.sixthproject.data.source.remote.RemoteDataSource
import com.example.sixthproject.data.source.remote.response.TvShowsResponse
import com.example.sixthproject.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return MovieRepository.getInstance(remoteDataSource)
    }
}
