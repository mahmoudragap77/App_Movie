package com.example.moviesapp.ui.home.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.moviesapp.ui.home.repository.MoviesRepository

class HomeViewModel : ViewModel() {
  //  val joke = MutableLiveData<VideoResponse>
    private val repository = MoviesRepository()
    val popularMovies =repository.getPopular().asLiveData()
    val topMovies =repository.getTop().asLiveData()
    val up =repository.getUp().asLiveData()
  //  val video=repository.getVideo().asLiveData()




}