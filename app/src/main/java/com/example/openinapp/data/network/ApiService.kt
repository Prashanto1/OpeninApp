package com.example.openinapp.data.network

import com.example.openinapp.data.ServerResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

interface ApiService {
    companion object{
        const val BASE_URL = "https://api.inopenapp.com/"
    }

    @GET("api/v1/dashboardNew")
    suspend fun getDetails():Response<ServerResponse>

}