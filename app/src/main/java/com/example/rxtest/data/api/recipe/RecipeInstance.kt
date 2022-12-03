package com.example.rxtest.data.api.recipe

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.create

object RecipeInstance {

    //чтобы увидеть вызов в логах
    val interceptor : HttpLoggingInterceptor =  HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val client:OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(interceptor)
    .build();


    private val complexSearchInstance =
        Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/").client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()


    val apiComplexSearch: ApiServiceComplexSearch =
        complexSearchInstance.create<ApiServiceComplexSearch>()
}




