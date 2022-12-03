package com.example.rxtest.data.repository

import com.example.rxtest.BuildConfig
import com.example.rxtest.data.api.recipe.RecipeInstance
import com.example.rxtest.data.model.model_detail_fragment.RecipeInfo
import com.example.rxtest.data.model.model_search_fragment.ComplexSearch
import io.reactivex.rxjava3.core.Single

class RepositoryRecipe() {

    //apiKey = "eec7094b57a64e7c80e707cddea0fda8"

    fun getComplexSearch(): Single<ComplexSearch> {
        return RecipeInstance.apiComplexSearch.getComplexSearch(apiKey = BuildConfig.API_KEY)
    }

    fun getRecipeInfo(recipeId: Int): Single<RecipeInfo> {
        return RecipeInstance.apiComplexSearch.getRecipesInformation(
            recipeId = recipeId,
            apiKey = BuildConfig.API_KEY
        )
    }
}