package com.example.recycjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.recycjetpack.model.Movie
import com.example.recycjetpack.ui.theme.RecycJetPackTheme
import com.example.recycjetpack.viewModel.MovieViewModel

class MainActivity : ComponentActivity() {
    val movieViewModel by viewModels<MovieViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            RecycJetPackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MovieList(movieList = movieViewModel.movieList)
                    movieViewModel.getMoviesList()
                }
            }
        }
    }
}

@Composable
fun MovieList(movieList: List<Movie>) {
    LazyColumn{
        itemsIndexed(items = movieList){
            index, item ->
            ItemView(movie = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecycJetPackTheme {
        val movie= Movie("Developer", "","Description","category")
        ItemView(movie = movie)
    }
}