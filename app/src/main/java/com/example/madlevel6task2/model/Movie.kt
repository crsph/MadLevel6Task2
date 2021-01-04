package com.example.madlevel6task2.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("backdrop_path") val backdropImg: String,
    @SerializedName("poster_path") val posterImg: String,
    @SerializedName("title") val title: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("vote_average") val rating: String,
    @SerializedName("overview") val overview: String
) {
    fun getBackdropImageUrl() = "https://image.tmdb.org/t/p/original/$backdropImg"
    fun getPosterImageUrl() = "https://image.tmdb.org/t/p/original/$posterImg"
}