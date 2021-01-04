package com.example.madlevel6task2.vm

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.madlevel6task2.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel(application: Application) : AndroidViewModel(application) {
    private val movieRepository = MovieRepository()
    private var _selectedMovie = 0

    val movie = movieRepository.movie

    private val _errorText: MutableLiveData<String> = MutableLiveData()

    val errorText: LiveData<String> get() = _errorText

    val getSelectedMovie get() = _selectedMovie

    fun getMovies(year: String) {
        viewModelScope.launch {
            try {
                movieRepository.getMovies(year)
            } catch (error: MovieRepository.MovieError) {
                _errorText.value = error.message
                Log.e("Movie error", error.cause.toString())
            }
        }
    }

    fun setSelectedMovie(selectedMovie: Int) {
        _selectedMovie = selectedMovie
    }
}