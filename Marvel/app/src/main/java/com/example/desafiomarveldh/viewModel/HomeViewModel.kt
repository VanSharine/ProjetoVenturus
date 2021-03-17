package com.example.desafiomarveldh.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.example.desafiomarveldh.paging.HomeDataSourceFactory
import com.example.desafiomarveldh.utils.Constants.Paging.PAGE_SIZE
import com.example.desafiomarveldh.model.Result

class HomeViewModel: ViewModel() {
    var homePagedList: LiveData<PagedList<Result>>? = null
    private var homeLiveDataSource: LiveData<PageKeyedDataSource<Int, Result>>? = null

    init {
        val marvelSourceFactory = HomeDataSourceFactory()
        homeLiveDataSource = marvelSourceFactory.getComicsLiveDataSource()

        val pagedListConfig = PagedList.Config.Builder()
               .setPrefetchDistance(10)
               .setInitialLoadSizeHint(PAGE_SIZE * 2)
               .setEnablePlaceholders(false)
               .setPageSize(PAGE_SIZE).build()

        homePagedList = LivePagedListBuilder(marvelSourceFactory, pagedListConfig).build()
    }
}