package com.example.madlevel6task2.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.madlevel6task2.api.MovieApi
import com.example.madlevel6task2.api.MovieApiService
import com.example.madlevel6task2.model.Movie
import kotlinx.coroutines.withTimeout

class MovieRepository {
    private val movieApiService: MovieApiService = MovieApi.createApi()
    private val _movie: MutableLiveData<List<Movie>> = MutableLiveData()
    val movie: LiveData<List<Movie>> get() = _movie

    suspend fun getMovies(year: String) {
        try {
            //timeout the request after 5 seconds
            val result = withTimeout(5_000) {
                movieApiService.getMovies(year)
            }

            _movie.value = result.movieList
        } catch (error: Throwable) {
            throw MovieError("Unable to retrieve movies from the year $year", error)
        }
    }

    class MovieError(message: String, cause: Throwable) : Throwable(message, cause)
}