package com.example.rxtest.presentation.dog_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxtest.data.model.ComplexSearch
import com.example.rxtest.data.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class DogViewModel : ViewModel() {
    lateinit var repository: Repository

    val searchList: MutableLiveData<ComplexSearch> = MutableLiveData()

    fun getSearchListObserver(): MutableLiveData<ComplexSearch> {
        return searchList
    }

    fun makeApiSearchObservable() {

        val apiInterfaceComplexSearch = repository.getComplexSearch()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getSearchListObserverRx())
    }

    private fun getSearchListObserverRx(): SingleObserver<ComplexSearch> {
        return object : SingleObserver<ComplexSearch> {

            override fun onError(e: Throwable) {
                searchList.postValue(null)
            }

            override fun onSuccess(t: ComplexSearch) {
                searchList.postValue(t)
            }

            override fun onSubscribe(d: Disposable) {
            }
        }
    }
}
