package com.example.rxtest.data.repository

import com.example.rxtest.BuildConfig
import com.example.rxtest.data.api.music.MusicInstance
import com.example.rxtest.data.api.recipe.RecipeInstance
import com.example.rxtest.data.model.model_music_list_fragment.TracksResult
import com.example.rxtest.data.model.model_search_fragment.ComplexSearch
import io.reactivex.rxjava3.core.Single

class RepocitoryMusic {

    fun getMusicSearch(): Single<TracksResult> {
        return MusicInstance.apiMusicSearch.getMusicSearch()
    }
}