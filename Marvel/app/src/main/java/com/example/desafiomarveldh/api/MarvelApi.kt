package com.example.desafiomarveldh.api

import com.example.desafiomarveldh.model.Comics
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {
    @GET("comics")
    suspend fun getComics(
        @Query("offset") offsetNumber: Int
    ): Response<Comics>
}