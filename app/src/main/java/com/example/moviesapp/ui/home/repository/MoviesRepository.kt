package com.example.moviesapp.ui.home.repository

import com.example.moviesapp.model.State
import com.example.moviesapp.networking.API
import com.example.moviesapp.utils.Constant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MoviesRepository {

     fun getPopular()= wrapWithFlow{ API.apiServi.getPopularMovies(Constant.api_key)}
    fun getTop()= wrapWithFlow{ API.apiServi.getTopRated(Constant.api_key)}
    fun getUp()= wrapWithFlow{ API.apiServi.getUpComing(Constant.api_key)}
//    fun getVideo(id:Int):Flow<State<VideoResponse?>> {
//        return flow {
//            emit(State.Loading)
//            try {
//                val result = API.apiServi.getTrailer(id,Constant.api_key)
//                if (result.isSuccessful) {
//                    emit(State.Success(result.body()))
//                } else {
//                    emit(State.Error(result.message()))
//
//                }
//            } catch (e: Exception) {
//                emit(State.Error(e.message.toString()))
//            }
//        }
//    }





    private fun <T> wrapWithFlow(function : suspend () -> Response<T>): Flow<State<T?>>{
        return flow {
            emit(State.Loading)
            try {
                val result = function()
                if (result.isSuccessful) {
                    emit(State.Success(result.body()))
                } else {
                    emit(State.Error(result.message()))
                }
            }catch (e : Exception){
                emit(State.Error(e.message.toString()))
            }
        }
    }
}
