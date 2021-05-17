package com.example.sixthproject.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowsEntity(
    var tvShowId: String,
    var title: String,
    var image:String,
    var synopsis:String,
    var firstEpisode:String,
    var lastEpisode:String,
    var totalEpisode:String,
    var totalSeason:String,
    var score : String
): Parcelable

