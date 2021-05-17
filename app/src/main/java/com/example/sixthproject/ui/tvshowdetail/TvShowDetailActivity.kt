package com.example.sixthproject.ui.tvshowdetail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.sixthproject.R
import com.example.sixthproject.data.source.local.entity.TvShowsEntity
import com.example.sixthproject.databinding.ActivityTvShowDetailBinding
import com.example.sixthproject.viewmodel.ViewModelFactory

class TvShowDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private lateinit var tvShowDetailBinding: ActivityTvShowDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tvShowDetailBinding = ActivityTvShowDetailBinding.inflate(layoutInflater)
        setContentView(tvShowDetailBinding.root)
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this,factory)[TvShowsDetailViewModel::class.java]

        val actionbar = supportActionBar
        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getString(EXTRA_TV_SHOW)
            if (tvShowId != null) {
                viewModel.setSelectedTvShow(tvShowId)
                actionbar?.title=null

                tvShowDetailBinding.tvShowDetailPoster.visibility=View.INVISIBLE
                tvShowDetailBinding.progressBar.visibility=View.VISIBLE
                 viewModel.getTvShow().observe(this,{tvShowDetail->
                     tvShowDetailBinding.tvShowDetailPoster.visibility=View.VISIBLE
                     tvShowDetailBinding.progressBar.visibility=View.INVISIBLE
                    populateTvShow(tvShowDetail)
                     actionbar?.title=tvShowDetail.title

                 })
            }
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun populateTvShow(tvShowEntity: TvShowsEntity) {

        tvShowDetailBinding.tvShowTitle.text = tvShowEntity.title
        tvShowDetailBinding.tvShowSynopsis.text = tvShowEntity.synopsis
        tvShowDetailBinding.tvShowFirstEpisode.text = resources.getString(R.string.first_episode,tvShowEntity.firstEpisode)
        tvShowDetailBinding.tvShowLastEpisode.text = resources.getString(R.string.last_episode,tvShowEntity.lastEpisode)
        tvShowDetailBinding.tvShowTotalEpisode.text = resources.getString(R.string.total_episode,tvShowEntity.totalEpisode)
        tvShowDetailBinding.tvShowTotalSeason.text = resources.getString(R.string.total_season,tvShowEntity.totalSeason)
        tvShowDetailBinding.tvShowScore.text = resources.getString(R.string.score,tvShowEntity.score)


        Glide.with(this)
            .load(tvShowEntity.image)
            .transform(RoundedCorners(120))
            .into(tvShowDetailBinding.tvShowDetailPoster)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
