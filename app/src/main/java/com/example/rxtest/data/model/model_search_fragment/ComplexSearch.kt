package com.example.rxtest.data.model.model_search_fragment

import com.google.gson.annotations.SerializedName


class ComplexSearch(
    @SerializedName("number") val number: Int,
    @SerializedName("offset") val offset: Int,
    @SerializedName("results") val results: List<Result>,
    @SerializedName("totalResults") val totalResults: Int
)