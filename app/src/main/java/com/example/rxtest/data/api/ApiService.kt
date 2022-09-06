package com.example.rxtest.data.api

import com.example.rxtest.model.retrofit.DescriptionFact
import com.example.rxtest.model.retrofit.ImageDog


import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET


// GET запросы

interface ApiService {

    @GET("api/breeds/image/random")
    fun getDogImage(): Observable<ImageDog>

    @GET("api/facts")
    fun getDogInformation(): Observable<DescriptionFact>
}