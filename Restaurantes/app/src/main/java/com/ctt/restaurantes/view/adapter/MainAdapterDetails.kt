package com.ctt.restaurantes.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ctt.restaurantes.R
import com.ctt.restaurantes.model.RestaurantDetails
import kotlinx.android.synthetic.main.template_card_details_restaurants.view.*


class MainAdapterDetails(
    private val MenuList: List<RestaurantDetails>,
    private val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<MainAdapterDetails.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.template_card_details_restaurants, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(MenuList[position], onItemClicked)
    }

    override fun getItemCount(): Int {
        return MenuList.size

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(restaurantsDetails: RestaurantDetails, onItemClicked: (Int) -> Unit) = with(itemView) {

            Glide.with(itemView.context).load(restaurantsDetails.imagemMenu).into(ivDetailsMainImage)

            tvDetailsRestaurantName.text = restaurantsDetails.nomeMenu

            cvDetailsRestaurants.setOnClickListener {
                onItemClicked(this@ViewHolder.adapterPosition)
            }
        }

    }


}