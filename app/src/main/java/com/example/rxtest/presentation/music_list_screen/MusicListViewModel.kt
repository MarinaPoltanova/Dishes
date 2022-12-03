package com.example.rxtest.presentation.music_list_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxtest.data.model.model_music_list_fragment.TracksResult
import com.example.rxtest.data.repository.RepocitoryMusic
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MusicListViewModel:ViewModel() {

    var repository= RepocitoryMusic()

    var musicList: MutableLiveData<TracksResult> = MutableLiveData()

    fun getMusichListObserver(): MutableLiveData<TracksResult> {
        return musicList
    }

    fun makeApiMusicListObservable() {

        val apiInterfaceMusicList = repository.getMusicSearch()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getMusicListObserverRx())
    }

    private fun getMusicListObserverRx(): SingleObserver<TracksResult> {
        return object : SingleObserver<TracksResult> {

            override fun onError(e: Throwable) {
                musicList.postValue(null)
            }

            override fun onSuccess(t: TracksResult) {
                musicList.postValue(t)
            }

            override fun onSubscribe(d: Disposable) {
            }
        }
    }
}