package com.example.rxtest.presentation.list_food_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxtest.data.model.model_search_fragment.ComplexSearch
import com.example.rxtest.data.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

//маркерный интерфейс - почитать
//для UI слоя https://github.com/sockeqwe/AdapterDelegates
//interface UIAction
//
//class UIClick(): UIAction

public class ComplexSearchViewModel : ViewModel(){
     var repository= Repository()

    var searchList: MutableLiveData<ComplexSearch> = MutableLiveData()

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
