package com.example.moviesapp.ui.actors.repository

import com.example.moviesapp.model.State
import com.example.moviesapp.networking.API
import com.example.moviesapp.utils.Constant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class PersonRepository {


    fun getPoster()= wrapWithFlow{ API.apiServiPhoto.getPopular(Constant.api_key)}






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
