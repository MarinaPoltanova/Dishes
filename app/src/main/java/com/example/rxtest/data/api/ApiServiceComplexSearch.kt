package com.example.rxtest.data.api

import com.example.rxtest.data.model.ComplexSearch


import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceComplexSearch {

    @GET("recipes/complexSearch")
    fun getComplexSearch(@Query("apiKey") apiKey: String): Single<ComplexSearch>
}