package com.example.sixthproject.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sixthproject.data.MovieDataSource
import com.example.sixthproject.data.source.local.entity.MoviesEntity
import com.example.sixthproject.data.source.local.entity.TvShowsEntity
import com.example.sixthproject.data.source.remote.RemoteDataSource
import com.example.sixthproject.data.source.remote.response.MoviesResponse
import com.example.sixthproject.data.source.remote.response.TvShowsResponse

class FakeMovieRepository(private val remoteDataSource: RemoteDataSource) :MovieDataSource {


    override fun getAllMovies(): LiveData<List<MoviesEntity>> {
        val movieResults = MutableLiveData<List<MoviesEntity>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponses: List<MoviesResponse>) {

                val movieList = ArrayList<MoviesEntity>()
                for (response in movieResponses) {
                    val movie = MoviesEntity(
                        response.movieId,
                        response.title,
                        response.image,
                        response.synopsis,
                        response.releaseDate,
                        response.score
                    )
                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }
        })
        return movieResults

    }


    override fun getAllTvShows(): LiveData<List<TvShowsEntity>> {
        val tvShowsResults = MutableLiveData<List<TvShowsEntity>>()
        val tvList = ArrayList<TvShowsEntity>()
        remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onAllTvShowsReceived(tvShowResponses: List<TvShowsResponse>) {
                for (response in tvShowResponses) {
                    val tvShow = TvShowsEntity(
                        response.tvShowId,
                        response.title,
                        response.image,
                        response.synopsis,
                        response.firstEpisode,
                        response.lastEpisode,
                        response.totalEpisode,
                        response.totalSeason,
                        response.score
                    )
                    tvList.add(tvShow)
                }
                tvShowsResults.postValue((tvList))
            }
        })
        return tvShowsResults
    }


    override fun getMovieById(movieId: String): LiveData<MoviesEntity> {
        val movieResults = MutableLiveData<MoviesEntity>()
        remoteDataSource.getAllMovies(object:RemoteDataSource.LoadMoviesCallback
        {
            override fun onAllMoviesReceived(movieResponses: List<MoviesResponse>) {
                lateinit var movie: MoviesEntity
                for (response in movieResponses) {
                    if (response.movieId == movieId) {
                        movie = MoviesEntity(
                            response.movieId,
                            response.title,
                            response.image,
                            response.synopsis,
                            response.releaseDate,
                            response.score
                        )
                        movieResults.postValue(movie)
                    }
                }
            }
        })

        return movieResults
    }

    override fun getTvShowById(tvShowId: String): LiveData<TvShowsEntity> {
        val tvShowsResults = MutableLiveData<TvShowsEntity>()
        lateinit var tvShow: TvShowsEntity
        remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onAllTvShowsReceived(tvShowResponses: List<TvShowsResponse>) {
                for (response in tvShowResponses) {
                    if (response.tvShowId == tvShowId) {
                        tvShow = TvShowsEntity(
                            response.tvShowId,
                            response.title,
                            response.image,
                            response.synopsis,
                            response.firstEpisode,
                            response.lastEpisode,
                            response.totalEpisode,
                            response.totalSeason,
                            response.score
                        )
                        tvShowsResults.postValue(tvShow)
                    }
                }

            }
        })
        return tvShowsResults
    }
}
