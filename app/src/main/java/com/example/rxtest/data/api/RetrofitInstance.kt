package com.example.rxtest.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.create

object RetrofitInstance {

    private val complexSearchInstance =
        Retrofit.Builder().baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

    val apiComplexSearch: ApiServiceComplexSearch = complexSearchInstance.create<ApiServiceComplexSearch>()
}




