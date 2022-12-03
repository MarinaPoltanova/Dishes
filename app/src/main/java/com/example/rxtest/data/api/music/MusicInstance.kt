package com.example.rxtest.data.api.music

import com.example.rxtest.data.api.recipe.ApiServiceComplexSearch
import com.example.rxtest.data.api.recipe.RecipeInstance
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object MusicInstance {
    //чтобы увидеть вызов в логах
    val interceptor : HttpLoggingInterceptor =  HttpLoggingInterceptor().setLevel(
        HttpLoggingInterceptor.Level.BODY)
    val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build();

    private val musicSearchInstance =
        Retrofit.Builder()
            .baseUrl("https://shazam.p.rapidapi.com/").client(MusicInstance.client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()


    val apiMusicSearch: ApiServiceMusicSearch =
        musicSearchInstance.create<ApiServiceMusicSearch>()

}