package com.example.rxtest.presentation.dog_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxtest.data.repository.Repository
import com.example.rxtest.model.retrofit.DescriptionFact
import com.example.rxtest.model.retrofit.ImageDog
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class DogViewModel : ViewModel() {
        lateinit var repository: Repository

    private val imageList: MutableLiveData<Observable<ImageDog>> = MutableLiveData()
    val descriptionList: MutableLiveData<Observable<DescriptionFact>> = MutableLiveData()

    fun getImageListObserver(): MutableLiveData<Observable<ImageDog>> {
        return imageList
    }

    fun getDescriptionListObserver(): MutableLiveData<Observable<DescriptionFact>> {
        return descriptionList
    }

    fun makeApiDescriptionObservable() {

        val apiInterfaceDescriptionDog = repository.getDescription()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getDescriptionListObserverRx())
    }

    private fun getDescriptionListObserverRx(): Observer<DescriptionFact> {
        return object : Observer<DescriptionFact> {
            override fun onNext(desc: DescriptionFact) {
                descriptionList.postValue(repository.getDescription())
            }

            override fun onError(e: Throwable) {
                descriptionList.postValue(null)
            }

            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
            }
        }
    }
}
