package com.ctt.restaurantes.model.restaurants

import com.ctt.restaurantes.model.Restaurants

class RestaurantsBusiness {

    private val repository:RestaurantsRepository by lazy {
        RestaurantsRepository()
    }
    fun getRestaurants(): Restaurants {
        return repository.getRestaurants()
    }
}