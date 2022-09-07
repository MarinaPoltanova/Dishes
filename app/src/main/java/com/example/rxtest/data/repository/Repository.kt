package com.example.rxtest.data.repository

import com.example.rxtest.data.api.RetrofitInstance
import com.example.rxtest.data.model.ComplexSearch
import io.reactivex.rxjava3.core.Single

class Repository() {

    fun getComplexSearch(): Single<ComplexSearch> {
        return RetrofitInstance.apiComplexSearch.getComplexSearch(apiKey = "eec7094b57a64e7c80e707cddea0fda8")
    }
}