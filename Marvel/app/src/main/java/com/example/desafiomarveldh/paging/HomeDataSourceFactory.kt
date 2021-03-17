package com.example.desafiomarveldh.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.example.desafiomarveldh.model.Result

class HomeDataSourceFactory(): DataSource.Factory<Int, Result>(){
    private val homeLiveDataSource = MutableLiveData<PageKeyedDataSource<Int, Result>>()

    override fun create(): DataSource<Int, Result> {

        val homeDataSource = HomePageKeyedDataSource()

        homeLiveDataSource.postValue(homeDataSource)

        return homeDataSource
    }

    fun getComicsLiveDataSource(): MutableLiveData<PageKeyedDataSource<Int, Result>> {
        return homeLiveDataSource
    }
}