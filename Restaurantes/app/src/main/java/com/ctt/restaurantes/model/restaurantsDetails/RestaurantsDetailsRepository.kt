package com.ctt.restaurantes.model.restaurantsDetails

import com.ctt.restaurantes.model.RestaurantDetails
import com.ctt.restaurantes.model.RestaurantsDetails

class RestaurantsDetailsRepository {
    fun getRestaurantsDetails(): RestaurantsDetails {
        val restaurantsDetails1 = RestaurantDetails(
            1001,
            "https://cdn.pixabay.com/photo/2016/04/04/17/22/asparagus-1307604_960_720.jpg",
            "Salada com molho de Gengibre",
            "Acelga, o repolho, a cenoura, a maçã, sal e o suco de limão em uma tigela grande. Com cebola picada em 1 colher de sopa de azeite, gengibre, vinagre de mel e arroz. "
        )
        val restaurantsDetails2 = RestaurantDetails(
            1002,
            "https://cdn.pixabay.com/photo/2016/11/22/18/52/cake-1850011_960_720.jpg",
            "Bolo à Francesa",
            "Bolo de chocolate, recheio de brigadeiro e cocada, cobertura de mousse de chocolate, raspas de chocolate, calda de chocolate e cerejas (decorativas)."
        )
        val restaurantsDetails3 = RestaurantDetails(
            1003,
            "https://cdn.pixabay.com/photo/2017/09/18/16/53/burger-2762371_960_720.jpg",
            "Clássico Americano",
            "Pão selado na manteiga, hambúrguer artesanal de blend bovina 160g, queijo prato, bacon em tiras, picles artesanal, molho barbecue de bacon da casa, alface americana, tomate e molho especial"
        )
        val restaurantsDetails4 = RestaurantDetails(
            1004,
            "https://cdn.pixabay.com/photo/2016/06/28/17/32/salmon-1485014_960_720.jpg",
            "Tilápia Grelhada",
            "Acompanha: Arroz, Batata Frita ou Purê e Salada"
        )
        val restaurantsDetails5 = RestaurantDetails(
            1005,
            "https://cdn.pixabay.com/photo/2016/11/06/23/31/breakfast-1804457_960_720.jpg",
            "Prato 5",
            "Descricao do prato 5"
        )
        val restaurantsDetails6 = RestaurantDetails(
            1006,
            "https://cdn.pixabay.com/photo/2017/01/11/11/33/cake-1971552_960_720.jpg",
            "Prato 6",
            "Descricao do prato 6"
        )
        val restaurantsDetails7 = RestaurantDetails(
            1007,
            "https://cdn.pixabay.com/photo/2016/11/22/19/31/dessert-1850216_960_720.jpg",
            "Prato 7",
            "Descricao do prato 7"
        )
        val restaurantsDetails8 = RestaurantDetails(
            1008,
            "https://cdn.pixabay.com/photo/2015/03/26/09/39/cupcakes-690040_960_720.jpg",
            "Prato 8",
            "Descricao do prato 8"
        )
        val restaurantsDetails9 = RestaurantDetails(
            1009,
            "https://cdn.pixabay.com/photo/2015/04/10/00/41/food-715542_960_720.jpg",
            "Prato 9",
            "Descricao do prato 9"
        )
        val restaurantsDetails10 = RestaurantDetails(
            1010,
            "https://cdn.pixabay.com/photo/2015/07/11/23/00/coffee-841425_960_720.jpg",
            "Prato 10",
            "Descricao do prato 10"
        )

        return RestaurantsDetails(
            restaurantsDetailsList =  listOf(restaurantsDetails1, restaurantsDetails2, restaurantsDetails3, restaurantsDetails4,restaurantsDetails5,restaurantsDetails6,restaurantsDetails7,restaurantsDetails8,restaurantsDetails9,restaurantsDetails10)
        )
    }
}