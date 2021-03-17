package com.ctt.restaurantes.view.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.restaurantes.R
import com.ctt.restaurantes.view.adapter.MainAdapter
import com.ctt.restaurantes.viewModel.RestaurantsViewModel


class RestaurantsActivity : AppCompatActivity() {

    private lateinit var viewModel: RestaurantsViewModel

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.rvListRestaurants)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Restaurantes)
        setContentView(R.layout.activity_restaurants)

        viewModel = ViewModelProvider(this).get(RestaurantsViewModel::class.java)
        viewModel.getRestaurants()

        setupObservables()

    }

    private fun setupObservables() {
        viewModel.restaurantsLiveData.observe(this, {
            it?.let { restaurants ->
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(this@RestaurantsActivity)
                    adapter = MainAdapter(restaurants.restaurantsList) { position ->
                        val intent =
                            Intent(this@RestaurantsActivity, RestaurantsDetailsActivity::class.java)
                        intent.putExtra(KEY_INTENT_RESTAURANT, restaurants.restaurantsList[position])
                        startActivity(intent)
                    }
                }
            }
        })
    }

    companion object {
        const val KEY_INTENT_RESTAURANT = "restaurant"
    }
}