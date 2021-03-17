package com.ctt.restaurantes.view.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.ctt.restaurantes.R
import com.ctt.restaurantes.model.RestaurantDetails
import com.ctt.restaurantes.view.activity.RestaurantsDetailsActivity.Companion.KEY_INTENT_RESTAURANT_DETAILS
import kotlinx.android.synthetic.main.activity_plate.*


class PlateActivity : AppCompatActivity() {

    private var restaurantsDetails: RestaurantDetails? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Restaurantes)

        setContentView(R.layout.activity_plate)
        supportActionBar?.hide()
        restaurantsDetails = intent.getParcelableExtra(KEY_INTENT_RESTAURANT_DETAILS)
        setupUser()
        initComponent()
    }

    private fun initComponent() {
        ibBack.setOnClickListener {
            finish()
        }
    }

    private fun setupUser() {
        Glide.with(this).load(restaurantsDetails?.imagemMenu).into(ivPlateImage)
        tvPlateName.text = restaurantsDetails?.nomeMenu
        tvPlateDescription.text = restaurantsDetails?.descricaoMenu
    }
}