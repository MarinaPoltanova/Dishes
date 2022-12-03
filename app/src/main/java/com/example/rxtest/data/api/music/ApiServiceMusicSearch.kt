package com.example.rxtest.data.api.music

import com.example.rxtest.data.model.model_music_list_fragment.TracksResult
import com.example.rxtest.data.model.model_search_fragment.ComplexSearch
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiServiceMusicSearch {

//    @Headers("X-RapidAPI-Key", "5cdb978fc5mshf484e846b704ec1p19f0c7jsn6af6bf48bb1f")
    @Headers("X-RapidAPI-Host: shazam.p.rapidapi.com", "X-RapidAPI-Key: 5cdb978fc5mshf484e846b704ec1p19f0c7jsn6af6bf48bb1f")
    @GET("songs/list-recommendations?key=484129036&locale=en-US")
    fun getMusicSearch(): Single<TracksResult>
}