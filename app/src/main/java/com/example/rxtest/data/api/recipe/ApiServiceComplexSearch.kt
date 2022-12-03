package com.example.rxtest.data.api.recipe

import com.example.rxtest.data.model.model_detail_fragment.RecipeInfo
import com.example.rxtest.data.model.model_search_fragment.ComplexSearch


import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceComplexSearch {

    // написать свой интерсептор, который будет проставлять свой apiKey

    @Headers("Accept: application/json")
    @GET("recipes/complexSearch")
    fun getComplexSearch(@Query("apiKey") apiKey: String): Single<ComplexSearch>

    @Headers("Accept: application/json")
    @GET("recipes/{id}/information")
    fun getRecipesInformation(@Path("id") recipeId: Int, @Query("apiKey") apiKey: String): Single<RecipeInfo>
}