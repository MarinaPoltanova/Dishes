package com.example.rxtest.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.create

object RetrofitInstance {
    private val imageDogInstance =
        Retrofit.Builder().baseUrl("https://dog.ceo/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val descriptionDogInstance =
        Retrofit.Builder().baseUrl("https://dog-api.kinduff.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()


    val apiImageDog: ApiService = imageDogInstance.create<ApiService>()

    val apiDescriptionDog: ApiService =
        descriptionDogInstance.create<ApiService>()
}




