package com.ctt.restaurantes.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ctt.restaurantes.R
import com.ctt.restaurantes.model.Restaurant
import kotlinx.android.synthetic.main.template_card_restaurants.view.*

class MainAdapter(
    private val restaurantsList: List<Restaurant>,
    private val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.template_card_restaurants, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(restaurantsList[position], onItemClicked)
    }

    override fun getItemCount(): Int {
        return restaurantsList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(restaurants: Restaurant, onItemClicked: (Int) -> Unit) = with(itemView) {

            Glide.with(itemView.context).load(restaurants.imagem).into(ivImage)

            tvRestaurantName.text = restaurants.nome
            tvRestaurantAddress.text = restaurants.endereco
            tvRestaurantHour.text = restaurants.horario

            cvRestaurants.setOnClickListener {
                onItemClicked(this@ViewHolder.adapterPosition)
            }
        }

    }


}