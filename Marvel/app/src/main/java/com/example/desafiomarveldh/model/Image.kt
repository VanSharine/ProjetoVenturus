package com.example.desafiomarveldh.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Image(
    val extension: String?,
    var path: String?
): Parcelable