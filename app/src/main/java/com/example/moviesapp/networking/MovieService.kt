package com.example.moviesapp.networking

import com.example.moviesapp.model.Movies
import com.example.moviesapp.model.VideoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {


    @GET("movie/{id}}/videos?")
    suspend fun getTrailer(@Path("id") id:Int,@Query("api_key") key:String): Response<VideoResponse>

//    @GET("movie/{id}?")
//    suspend fun getMoviesDetails(@Path("id") page:Int,@Query("api_key") key:String): Response<MoviesDetailsResponse>

    @GET("movie/popular?")
    suspend fun getPopularMovies(@Query ("api_key") apiKey :String): Response<Movies>

    @GET("movie/top_rated?")
    suspend fun getTopRated(@Query("api_key") apiKey :String): Response<Movies>

    @GET("movie/upcoming?")
    suspend fun getUpComing(@Query("api_key") apiKey :String): Response<Movies>

}