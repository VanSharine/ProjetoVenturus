package com.example.desafiomarveldh.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharactersItem(
    val name: String?,
    val resourceURI: String?,
    val type: String?,
    val role: String?
): Parcelable