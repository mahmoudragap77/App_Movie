package com.example.moviesapp.ui.actors.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.moviesapp.ui.actors.repository.PersonRepository

class PersonViewModel : ViewModel() {
    private val repository = PersonRepository()
    val getPoster =repository.getPoster().asLiveData()



}