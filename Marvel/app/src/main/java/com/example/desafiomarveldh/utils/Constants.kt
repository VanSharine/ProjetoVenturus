package com.example.desafiomarveldh.utils


class Constants {
    object Api {
        const val BASE_URL = "https://gateway.marvel.com:443/v1/public/"
        const val PUBLIC_KEY = "6eb7e8896ec5850c52515a8a23ee97f0"
        const val PRIVATE_KEY = "0dd0c16fedb8a02985977eafca66b49f5e6a526f"
//        const val PUBLIC_KEY = "df27ed96a0bffa555610ac7c0efd1261"
//        const val PRIVATE_KEY = "9a26b109d17637c805b1bbe47e448e3d25bcf377"
        const val BASE_URL_ORIGINAL_IMAGE = "/landscape_xlarge.jpg"
        const val API_QUERY_CHARACTER_VALUE = "1009610"
        const val TS_NAME = "ts"
        const val KEY_NAME = "apikey"
        const val HASH_NAME = "hash"
        const val API_QUERY_FORMAT_NAME = "format"
        const val API_QUERY_FORMAT_VALUE = "comic"
        const val API_CONTENT_TYPE_NAME = "formatType"
        const val API_CONTENT_TYPE_VALUE = "comic"
        const val API_QUERY_CHARACTER_NAME = "characters"
        const val API_QUERY_VARIANTS_NAME = "noVariants"
        const val API_QUERY_VARIANTS_VALUE = "true"
    }

    object Paging {
        const val PAGE_SIZE = 20
        const val FIRST_PAGE = 1
    }

    object ComicsDetail {
        const val KEY_INTENT_COMICS_ID = "comicsId"
    }
}