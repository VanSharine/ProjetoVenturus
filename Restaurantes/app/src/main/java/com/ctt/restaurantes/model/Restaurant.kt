package com.ctt.restaurantes.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Restaurant(
    val id:Int,
    val imagem: String,
    val nome: String,
    val endereco: String,
    val horario: String
) : Parcelable