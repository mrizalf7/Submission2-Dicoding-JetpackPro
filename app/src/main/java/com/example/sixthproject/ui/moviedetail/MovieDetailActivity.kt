package com.example.sixthproject.ui.moviedetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.sixthproject.R
import com.example.sixthproject.data.source.local.entity.MoviesEntity
import com.example.sixthproject.databinding.ActivityMovieDetailBinding
import com.example.sixthproject.viewmodel.ViewModelFactory

class MovieDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var movieDetailBinding:ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieDetailBinding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(movieDetailBinding.root)
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this,factory)[MovieDetailViewModel::class.java]

        val actionbar = supportActionBar
        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                actionbar?.title=null
                movieDetailBinding.progressBar.visibility= View.VISIBLE
                movieDetailBinding.movieDetailPoster.visibility=View.INVISIBLE
                viewModel.getMovie().observe(this,{movieDetail->
                    populateMovie(movieDetail)
                    actionbar?.title=movieDetail.title
                    movieDetailBinding.progressBar.visibility=View.INVISIBLE
                    movieDetailBinding.movieDetailPoster.visibility=View.VISIBLE
                })
            }
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun populateMovie(moviesEntity: MoviesEntity) {

        movieDetailBinding.movieTitle.text = moviesEntity.title
        movieDetailBinding.movieSynopsis.text = moviesEntity.synopsis
        movieDetailBinding.movieReleaseDate.text = resources.getString(R.string.release_date,moviesEntity.releaseDate)
        movieDetailBinding.movieScore.text = resources.getString(R.string.score,moviesEntity.score)


        Glide.with(this)
            .load(moviesEntity.image)
            .transform(RoundedCorners(120))
            .into(movieDetailBinding.movieDetailPoster)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}