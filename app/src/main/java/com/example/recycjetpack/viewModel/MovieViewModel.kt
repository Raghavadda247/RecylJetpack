package com.example.recycjetpack.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recycjetpack.model.Movie
import com.example.recycjetpack.network.ApiService
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {
    var movieList: List<Movie> by mutableStateOf(listOf())

    fun getMoviesList(){
        viewModelScope.launch {
            val apiService=ApiService.getInstance()
            movieList = apiService.getMovies()
        }
    }
}