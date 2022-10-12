package com.example.rxtest.presentation.detail_food_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rxtest.R
import com.example.rxtest.data.model.model_detail_fragment.RecipeInfo

class DetailFoodFragment : Fragment() {

    lateinit var currentRecipe: RecipeInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_food, container, false)
    }
}