package com.example.desafiomarveldh.api

import com.example.desafiomarveldh.extensions.md5
import com.example.desafiomarveldh.utils.Constants.Api.HASH_NAME
import com.example.desafiomarveldh.utils.Constants.Api.KEY_NAME
import com.example.desafiomarveldh.utils.Constants.Api.PUBLIC_KEY
import com.example.desafiomarveldh.utils.Constants.Api.PRIVATE_KEY
import com.example.desafiomarveldh.utils.Constants.Api.TS_NAME
import com.example.desafiomarveldh.utils.Constants.Api.BASE_URL
import com.example.desafiomarveldh.utils.Constants.Api.API_QUERY_CHARACTER_NAME
import com.example.desafiomarveldh.utils.Constants.Api.API_QUERY_CHARACTER_VALUE
import com.example.desafiomarveldh.utils.Constants.Api.API_QUERY_FORMAT_NAME
import com.example.desafiomarveldh.utils.Constants.Api.API_CONTENT_TYPE_NAME
import com.example.desafiomarveldh.utils.Constants.Api.API_CONTENT_TYPE_VALUE
import com.example.desafiomarveldh.utils.Constants.Api.API_QUERY_FORMAT_VALUE
import com.example.desafiomarveldh.utils.Constants.Api.API_QUERY_VARIANTS_NAME
import com.example.desafiomarveldh.utils.Constants.Api.API_QUERY_VARIANTS_VALUE
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ApiService {
    val marvelApi: MarvelApi = getMarvelApiClient().create(MarvelApi::class.java)

    private fun getMarvelApiClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getInterceptorClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getInterceptorClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val interceptor = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor {chain ->
                val newRequest = chain.request().newBuilder()
                    .build()
                chain.proceed(newRequest)
            }
            .addInterceptor { chain ->
                val ts =  System.currentTimeMillis().toString()

                val url = chain.request().url().newBuilder()
                    .addQueryParameter(HASH_NAME, "$ts$PRIVATE_KEY$PUBLIC_KEY".md5())
                    .addQueryParameter(TS_NAME, ts)
                    .addQueryParameter(API_QUERY_FORMAT_NAME, API_QUERY_FORMAT_VALUE)
                    .addQueryParameter(API_CONTENT_TYPE_NAME, API_CONTENT_TYPE_VALUE)
                    .addQueryParameter(API_QUERY_CHARACTER_NAME, API_QUERY_CHARACTER_VALUE)
                    .addQueryParameter(API_QUERY_VARIANTS_NAME, API_QUERY_VARIANTS_VALUE)
                    .addQueryParameter(KEY_NAME, PUBLIC_KEY)
                    .build()
                val newRequest = chain.request().newBuilder().url(url).build()
                chain.proceed(newRequest)
            }
        return  interceptor.build()
    }

}