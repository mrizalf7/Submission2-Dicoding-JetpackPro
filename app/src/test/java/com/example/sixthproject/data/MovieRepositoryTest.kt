package com.example.sixthproject.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.sixthproject.data.source.remote.RemoteDataSource
import com.example.sixthproject.utils.LiveDataTestUtil
import com.example.sixthproject.utils.NotDataDummy
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mockito.*
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.doAnswer
import org.junit.Rule


class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)

    private val movieResponses = NotDataDummy.generateRemoteMovies()
    private val tvShowsResponse = NotDataDummy.generateRemoteTvShows()
    private val movieId = movieResponses[0].movieId
    private val tvShowId = tvShowsResponse[0].tvShowId


    @Test
    fun getAllMovies() {

        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getAllMovies(any())

        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getAllMovies())
        verify(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllTvShows() {

        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
                .onAllTvShowsReceived(tvShowsResponse)
            null
        }.`when`(remote).getAllTvShows(any())

        val tvShowEntities = LiveDataTestUtil.getValue(movieRepository.getAllTvShows())
        verify(remote).getAllTvShows(any())

        assertNotNull(tvShowEntities)
        assertEquals(tvShowsResponse.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getMovieById() {


        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponses)

            null
        }.`when`(remote).getAllMovies(any())


        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getMovieById(movieId))



        verify(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertNotNull(movieEntities.title)
        assertEquals(movieResponses[0].title, movieEntities.title)
    }

    @Test
    fun getTvShowById() {

        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
                .onAllTvShowsReceived(tvShowsResponse)

            null
        }.`when`(remote).getAllTvShows(any())


        val tvShowsEntities = LiveDataTestUtil.getValue(movieRepository.getTvShowById(tvShowId))

        verify(remote).getAllTvShows(any())
        assertNotNull(tvShowsEntities)
        assertEquals(tvShowsResponse[0].title, tvShowsEntities.title)
    }
}