package com.example.moviesapp.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {

        private val BASE_URL ="https://api.themoviedb.org/3/"
        private val retrofite = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiServi = retrofite.create(MovieService::class.java)
    val apiServiPhoto = retrofite.create(PersonsService::class.java)
    }
