package com.ctt.restaurantes.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ctt.restaurantes.model.Restaurants
import com.ctt.restaurantes.model.restaurants.RestaurantsBusiness

class RestaurantsViewModel : ViewModel() {
    val restaurantsLiveData: MutableLiveData<Restaurants> = MutableLiveData()
    private val restaurantsBusiness = RestaurantsBusiness()

    fun getRestaurants() {
        restaurantsLiveData.postValue(
            restaurantsBusiness.getRestaurants()
        )
    }
}