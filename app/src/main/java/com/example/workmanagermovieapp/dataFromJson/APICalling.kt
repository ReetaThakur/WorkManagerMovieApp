package com.example.workmanagermovieapp.dataFromJson

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APICalling {
    @GET("3/movie/popular")
    fun getInstance(@Query("api_key") key: String):Call<ResponseDTO>
}