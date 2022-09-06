package com.example.rxtest.data.repository

import com.example.rxtest.data.api.RetrofitInstance
import com.example.rxtest.model.retrofit.DescriptionFact
import com.example.rxtest.model.retrofit.ImageDog
import io.reactivex.rxjava3.core.Observable

class Repository() {
     fun getImage(): Observable<ImageDog> {
        return RetrofitInstance.apiImageDog.getDogImage()
    }

     fun getDescription(): Observable<DescriptionFact>{
        return RetrofitInstance.apiDescriptionDog.getDogInformation()
    }
}