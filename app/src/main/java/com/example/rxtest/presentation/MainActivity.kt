package com.example.rxtest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.rxtest.R
import com.example.rxtest.presentation.detail_food_screen.DetailRecipeFragment
import com.example.rxtest.presentation.list_food_screen.ComplexSearchAdapter
import com.example.rxtest.presentation.list_food_screen.ComplexSearchFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, ComplexSearchFragment())
            .addToBackStack("RecipeList")  //положила в стек
            .commit()

    }
}
