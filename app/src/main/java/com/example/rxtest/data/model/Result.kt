package com.example.rxtest.data.model

import com.google.gson.annotations.SerializedName

 class Result(
    @SerializedName("id") val id: Int?,
    @SerializedName("image") val image: String?,
    @SerializedName("imageType") val imageType: String?,
    @SerializedName("title") val title: String?
)