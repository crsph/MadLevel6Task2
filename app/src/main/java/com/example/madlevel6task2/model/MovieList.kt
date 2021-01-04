package com.example.madlevel6task2.model

import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    var movieList: List<Movie>
)