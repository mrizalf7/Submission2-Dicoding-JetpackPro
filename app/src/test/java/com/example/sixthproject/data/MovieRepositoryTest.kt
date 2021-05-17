package com.example.sixthproject.data

import com.example.sixthproject.data.source.remote.RemoteDataSource
import com.example.sixthproject.utils.NotDataDummy
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class MovieRepositoryTest {


    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)

    private val movieResponses = NotDataDummy.generateRemoteMovies()
    private val tvShowsResponse = NotDataDummy.generateRemoteTvShows()
    private val movieId = movieResponses[0].movieId
    private val tvShowId = tvShowsResponse[0].tvShowId


    @Test
    fun getAllMovies() {
        `when`(remote.getAllMovies()).thenReturn(movieResponses)
        val movieEntities = movieRepository.getAllMovies()
        verify(remote).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllTvShows() {
        `when`(remote.getAllTvShows()).thenReturn(tvShowsResponse)
        val tvShowEntities = movieRepository.getAllTvShows()
        verify(remote).getAllTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(tvShowsResponse.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getMovieById() {
        `when`(remote.getAllMovies()).thenReturn(movieResponses)
        val resultMovie = movieRepository.getMovieById(movieId)
        verify(remote).getAllMovies()
        assertNotNull(resultMovie)
        assertEquals(movieResponses[0].title, resultMovie.title)
    }

    @Test
    fun getTvShowById() {
        `when`(remote.getAllTvShows()).thenReturn(tvShowsResponse)
        val resultTvShow = movieRepository.getTvShowById(tvShowId)
        verify(remote).getAllTvShows()
        assertNotNull(resultTvShow)
        assertEquals(tvShowsResponse[0].title, resultTvShow.title)
    }
}