package com.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInit {

    private var retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}