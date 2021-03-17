package com.ctt.restaurantes.model.restaurantsDetails

import com.ctt.restaurantes.model.RestaurantsDetails

class RestaurantsDetailsBusiness {

    private val repository: RestaurantsDetailsRepository by lazy {
        RestaurantsDetailsRepository()
    }

    fun getRestaurantsDetails(): RestaurantsDetails {
        return repository.getRestaurantsDetails()
    }
}