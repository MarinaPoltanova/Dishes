package com.example.rxtest.data.model.model_detail_fragment

import com.google.gson.annotations.SerializedName

data class Measures(
    @SerializedName("metric") val metric: Metric,
    @SerializedName("us") val us: Us
)