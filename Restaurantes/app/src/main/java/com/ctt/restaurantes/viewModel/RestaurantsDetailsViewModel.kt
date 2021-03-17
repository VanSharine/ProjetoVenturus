package com.ctt.restaurantes.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ctt.restaurantes.model.RestaurantsDetails
import com.ctt.restaurantes.model.restaurantsDetails.RestaurantsDetailsBusiness

class RestaurantsDetailsViewModel : ViewModel() {
    val restaurantsDetailsLiveData: MutableLiveData<RestaurantsDetails> = MutableLiveData()
    private val restaurantsDetailsBusiness = RestaurantsDetailsBusiness()

    fun getRestaurantsDetails() {
        restaurantsDetailsLiveData.postValue(
            restaurantsDetailsBusiness.getRestaurantsDetails()
        )
    }
}