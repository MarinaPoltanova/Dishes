package com.example.rxtest.data.model

import com.google.gson.annotations.SerializedName

data class ComplexSearch(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
)