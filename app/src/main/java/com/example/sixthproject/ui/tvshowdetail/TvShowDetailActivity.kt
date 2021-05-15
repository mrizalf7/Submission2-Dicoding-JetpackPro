package com.example.sixthproject.ui.tvshowdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.sixthproject.R
import com.example.sixthproject.data.TvShowsEntity
import com.example.sixthproject.databinding.ActivityTvShowDetailBinding
import com.example.sixthproject.utils.NotDataDummy

class TvShowDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private lateinit var tvShowDetailBinding: ActivityTvShowDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tvShowDetailBinding = ActivityTvShowDetailBinding.inflate(layoutInflater)
        setContentView(tvShowDetailBinding.root)
        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowsDetailViewModel::class.java]

        val actionbar = supportActionBar
        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getString(EXTRA_TV_SHOW)
            if (tvShowId != null) {
                viewModel.setSelectedTvShow(tvShowId)

                populateTvShow(viewModel.getTvShow())
                for (tvShow in NotDataDummy.generateTvShows()) {
                    if (tvShow.tvShowId == tvShowId) {
                        populateTvShow(tvShow)
                        actionbar?.title =tvShow.title
                    }
                }
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
