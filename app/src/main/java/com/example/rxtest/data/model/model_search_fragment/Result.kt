package com.example.rxtest.data.model.model_search_fragment

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Result(
    @SerializedName("id") val id: Int?,
    @SerializedName("image") val image: String?,
    @SerializedName("imageType") val imageType: String?,
    @SerializedName("title") val title: String?
): Serializable