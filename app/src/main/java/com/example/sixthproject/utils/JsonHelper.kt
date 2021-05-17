package com.example.sixthproject.utils

import android.content.Context
import com.example.sixthproject.data.source.remote.response.MoviesResponse
import com.example.sixthproject.data.source.remote.response.TvShowsResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MoviesResponse> {
        val list = ArrayList<MoviesResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("movies.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("movieId")
                val title = movie.getString("title")
                val image = movie.getString("image")
                val synopsis = movie.getString("synopsis")
                val releaseDate = movie.getString("releaseDate")
                val score = movie.getString("score")

                val movieResponse = MoviesResponse(id, title, image, synopsis, releaseDate,score)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadTvShows(): List<TvShowsResponse> {
        val list = ArrayList<TvShowsResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("tvshows.json").toString())
            val listArray = responseObject.getJSONArray("tvshows")
            for (i in 0 until listArray.length()) {
                val tvshow = listArray.getJSONObject(i)

                val id = tvshow.getString("tvShowId")
                val title = tvshow.getString("title")
                val image = tvshow.getString("image")
                val synopsis = tvshow.getString("synopsis")
                val firstEpisode = tvshow.getString("firstEpisode")
                val lastEpisode = tvshow.getString("lastEpisode")
                val totalEpisode = tvshow.getString("totalEpisode")
                val totalSeason = tvshow.getString("totalSeason")
                val score = tvshow.getString("score")

                val tvShowResponse = TvShowsResponse(id, title, image, synopsis,firstEpisode,
                    lastEpisode,totalEpisode,totalSeason,score)
                list.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }




}