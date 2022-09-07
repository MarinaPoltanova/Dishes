package com.example.rxtest.data.model

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("id") val id: Int?,
    @SerializedName("image") val image: String?,
    val imageType: String?,
    @SerializedName("title") val title: String?
)