package com.example.desafiomarveldh.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.desafiomarveldh.utils.Constants
import java.security.NoSuchAlgorithmException

fun String.getFullImagePath(): String {
    return "${this}${Constants.Api.BASE_URL_ORIGINAL_IMAGE}"
}

fun String.md5(): String {
    try {
        val digest = java.security.MessageDigest.getInstance("MD5")
        digest.update(toByteArray())
        val messageDigest = digest.digest()
        val hexString = StringBuilder()
        for (aMessageDigest in messageDigest) {
            var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
            while (h.length < 2)
                h = "0$h"
            hexString.append(h)
        }
        return hexString.toString()

    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }
    return ""
}


fun ImageView.load(url:String){
    Glide.with(context)
        .load(url)
        .into(this)
}