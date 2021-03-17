package com.ctt.restaurantes.model.restaurants

import com.ctt.restaurantes.model.Restaurant
import com.ctt.restaurantes.model.Restaurants


class RestaurantsRepository {
    fun getRestaurants(): Restaurants {
        val restaurants01 = Restaurant(
            1001,
            "https://cdn.pixabay.com/photo/2017/03/23/19/57/asparagus-2169305_960_720.jpg",
            "Tony Roma's",
            "Av. Lavandisca, 717 - Indianópolis, São Paulo",
            "Fecha às 22:00"
        )
        val restaurants02 = Restaurant(
            1002,
            "https://cdn.pixabay.com/photo/2014/10/19/20/59/hamburger-494706_960_720.jpg",
            "Ayoma - Moema",
            "Alamada dos Arapanés, 532 - Moema",
            "Fecha às 00:00"
        )
        val restaurants03 = Restaurant(
            1003,
            "https://cdn.pixabay.com/photo/2015/08/21/18/19/sparerips-899306_960_720.jpg",
            "Outback - Moema",
            "Av. Moaci, 187 - Moema, São Paulo",
            "Fecha às 00:00"
        )
        val restaurants04 = Restaurant(
            1004,
            "https://cdn.pixabay.com/photo/2015/09/27/16/50/spaghetti-960978_960_720.jpg",
            "Sí Señor!",
            "Alameda Jauaperi. 626 - Moema",
            "Fecha às 01:00"
        )

        return Restaurants(
            restaurantsList =  listOf(restaurants01, restaurants02, restaurants03, restaurants04)
        )
    }
}