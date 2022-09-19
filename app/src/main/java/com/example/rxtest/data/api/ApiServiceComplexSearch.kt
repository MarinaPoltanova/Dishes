package com.example.rxtest.data.api

import com.example.rxtest.data.model.ComplexSearch


import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiServiceComplexSearch {

    // написать свой интерсептор, который будет проставлять свой apiKey
    //посмотреть, как можно хранить секьюрно этот ключ? (одно из решений - в локал пропертиес хранить этот токен (поправить buildGradle) )

    @Headers("Accept: application/json")
    @GET("recipes/complexSearch")
    fun getComplexSearch(@Query("apiKey") apiKey: String): Single<ComplexSearch>
}