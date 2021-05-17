package com.example.sixthproject.data

import com.example.sixthproject.data.MovieDataSource
import com.example.sixthproject.data.source.local.entity.MoviesEntity
import com.example.sixthproject.data.source.local.entity.TvShowsEntity
import com.example.sixthproject.data.source.remote.RemoteDataSource

class FakeMovieRepository(private val remoteDataSource: RemoteDataSource) :MovieDataSource {


    override fun getAllMovies(): ArrayList<MoviesEntity> {

        val movieResponses = remoteDataSource.getAllMovies()
        val movieList = ArrayList<MoviesEntity>()
        for (response in movieResponses) {
            val movie = MoviesEntity(response.movieId,
                response.title,
                response.image,
                response.synopsis,
                response.releaseDate,
                response.score)
            movieList.add(movie)
        }
        return movieList
    }

    override fun getAllTvShows(): ArrayList<TvShowsEntity> {
        val tvshowResponses = remoteDataSource.getAllTvShows()
        val tvList = ArrayList<TvShowsEntity>()
        for(response in tvshowResponses){
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
        return tvList
    }

    override fun getMovieById(movieId: String): MoviesEntity {
        val movieResponse = remoteDataSource.getAllMovies()
        lateinit var movie: MoviesEntity
        for (response in movieResponse) {
            if (response.movieId == movieId) {
                movie = MoviesEntity(response.movieId,
                    response.title,
                    response.image,
                    response.synopsis,
                    response.releaseDate,
                    response.score)
            }
        }
        return movie
    }

    override fun getTvShowById(tvShowId: String): TvShowsEntity {
        val tvShowResponse = remoteDataSource.getAllTvShows()
        lateinit var tvShow: TvShowsEntity
        for (response in tvShowResponse) {
            if (response.tvShowId == tvShowId) {
                tvShow = TvShowsEntity(response.tvShowId,
                    response.title,
                    response.image,
                    response.synopsis,
                    response.firstEpisode,
                    response.lastEpisode,
                    response.totalEpisode,
                    response.totalSeason,
                    response.score)
            }
        }
        return tvShow
    }

}