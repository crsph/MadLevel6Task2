package com.example.madlevel6task2.api

import com.example.madlevel6task2.model.MovieList
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("/3/discover/movie?api_key=7d5da3c24f423bd79391d2219644b64f&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    suspend fun getMovies(
        @Query("primary_release_year") year: String
    ): MovieList
}

