package com.example.desafiomarveldh.model.home

import com.example.desafiomarveldh.api.ApiService
import com.example.desafiomarveldh.api.ResponseAPI
import java.lang.Exception

class HomeRepository() {
    suspend fun getComics(offset: Int): ResponseAPI {
        return try {
            val response = ApiService.marvelApi.getComics(offset)
            if (response.isSuccessful) {
                ResponseAPI.Success(response.body())
            } else {
                if (response.code() == 404) {
                    ResponseAPI.Error("Dado não encontrado")
                } else {
                    ResponseAPI.Error("Erro ao carregar os dados")
                }
            }
        } catch (exception: Exception) {
            ResponseAPI.Error("Erro ao carregar os dados")
        }
    }
}