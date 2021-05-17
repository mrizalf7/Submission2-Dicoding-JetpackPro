package com.example.sixthproject.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MoviesResponse (
    var movieId: String,
    var title: String,
    var image:String,
    var synopsis:String,
    var releaseDate:String,
    var score : String
): Parcelable