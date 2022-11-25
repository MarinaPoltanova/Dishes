package com.example.rxtest.presentation.detail_food_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxtest.data.model.model_detail_fragment.RecipeInfo
import com.example.rxtest.data.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

// как пеермещаться между фрагментами? - аргументы/библиотека nav

class DetailRecipeViewModel(
) : ViewModel() {
    var repository = Repository()
    var recipeDetail: MutableLiveData<RecipeInfo> = MutableLiveData()
    var recipeId: Int = -1

    fun getDetailRecipeObserver(): MutableLiveData<RecipeInfo> {
        return recipeDetail
    }

    fun makeDetailRecipeObservable() {
        val apiDetailRecipeRequest =
//            fragmentDetailRecipe.arguments?.getInt("recipeId")?.let {
//            recipeId?.let {
                repository.getRecipeInfo(recipeId = recipeId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(getDetailRecipeObserverRx())
            }
//    }

//    }

    private fun getDetailRecipeObserverRx(): SingleObserver<RecipeInfo> {
        return object : SingleObserver<RecipeInfo> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onSuccess(t: RecipeInfo) {
                recipeDetail.postValue(t)
            }

            override fun onError(e: Throwable) {
                recipeDetail.postValue(null)
            }

        }
    }
}