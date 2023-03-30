package com.example.moviesapp.networking

import com.example.moviesapp.model.PersonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PersonsService {

    @GET("person/popular?")
    suspend fun getPopular(@Query("api_key") key:String): Response<PersonResponse>






}