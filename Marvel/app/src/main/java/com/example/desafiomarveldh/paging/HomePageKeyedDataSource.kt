package com.example.desafiomarveldh.paging

import androidx.paging.PageKeyedDataSource
import com.example.desafiomarveldh.api.ResponseAPI
import com.example.desafiomarveldh.extensions.getFullImagePath
import com.example.desafiomarveldh.model.Comics
import com.example.desafiomarveldh.model.home.HomeRepository
import com.example.desafiomarveldh.utils.Constants.Paging.FIRST_PAGE
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.desafiomarveldh.model.Result


class HomePageKeyedDataSource(): PageKeyedDataSource<Int, Result>() {
    private val repository by lazy {
        HomeRepository()
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Result>
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            when(val response = repository.getComics(FIRST_PAGE)) {
                is ResponseAPI.Success -> {
                    val data = response.data as Comics
                    data.data?.results?.forEach {
                        it.thumbnail?.path = it.thumbnail?.path?.getFullImagePath()
                        it.images?.forEach {
                            it.path = it.path?.getFullImagePath()
                        }
                        if(it.description == null) {
                            it.description = "Nenhuma descrição encontrada!\n" +
                                    "Descrição Padrão:\n" +
                                    "Looking for the one superhero comic you just have to read? You've found it! Amazing Spider-Man is the cornerstone" +
                                    " of the Marvel Universe. This is where you'll find all the big-time action, major storylines and iconic Spider-Man" +
                                    " magic you'd come to expect from the Wall-Crawler"
                        }
                    }
                    data.data?.results?.let { callback.onResult(it, null, FIRST_PAGE + 1) }
                }
                is ResponseAPI.Error -> {
                    callback.onResult(mutableListOf(), null, FIRST_PAGE + 1)
                }
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Result>) {
        val page = params.key
        CoroutineScope(Dispatchers.IO).launch {
            when(val response = repository.getComics(page)) {
                is ResponseAPI.Success -> {
                    val data = response.data as Comics
                    data.data?.results?.forEach {
                        it.images?.forEach {
                            it.path = it.path?.getFullImagePath()
                        }
                        if(it.description == null) {
                            it.description = "Nenhuma descrição encontrada!\n" +
                                    "Descrição Padrão:\n" +
                                    "Looking for the one superhero comic you just have to read? You've found it! Amazing Spider-Man is the cornerstone" +
                                    " of the Marvel Universe. This is where you'll find all the big-time action, major storylines and iconic Spider-Man" +
                                    " magic you'd come to expect from the Wall-Crawler"
                        }
                        it.thumbnail?.path = it.thumbnail?.path?.getFullImagePath()
                    }
                    data.data?.results?.let { callback.onResult(it,  page + 1) }
                }
                is ResponseAPI.Error -> {
                    callback.onResult(mutableListOf(), page + 1)
                }
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Result>) {
        val page = params.key
        CoroutineScope(Dispatchers.IO).launch {
            when(val response = repository.getComics(page)) {
                is ResponseAPI.Success -> {
                    val data = response.data as Comics
                    data.data?.results?.forEach {
                        it.images?.forEach {
                            it.path = it.path?.getFullImagePath()
                        }
                        if(it.description == null) {
                            it.description = "Nenhuma descrição encontrada!\n" +
                                    "Descrição Padrão:\n" +
                                    "Looking for the one superhero comic you just have to read? You've found it! Amazing Spider-Man is the cornerstone" +
                                    " of the Marvel Universe. This is where you'll find all the big-time action, major storylines and iconic Spider-Man" +
                                    " magic you'd come to expect from the Wall-Crawler"
                        }
                        it.thumbnail?.path = it.thumbnail?.path?.getFullImagePath()
                    }
                    data.data?.results?.let { callback.onResult(it,  page - 1) }
                }
                is ResponseAPI.Error -> {
                    callback.onResult(mutableListOf(), page - 1)
                }
            }
        }
    }
}