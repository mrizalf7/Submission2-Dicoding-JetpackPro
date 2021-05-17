package com.example.sixthproject.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MoviesEntity(
    var movieId: String,
    var title: String,
    var image:String,
    var synopsis:String,
    var releaseDate:String,
    var score : String
): Parcelable