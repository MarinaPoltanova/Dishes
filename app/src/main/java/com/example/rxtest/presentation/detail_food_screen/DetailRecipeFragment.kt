package com.example.rxtest.presentation.detail_food_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.bumptech.glide.Glide
import com.example.rxtest.R
import com.example.rxtest.data.model.model_detail_fragment.RecipeInfo
import java.util.*
import kotlin.properties.Delegates

//by lazy - отложить до первого вызова
//:-1 - для установления дефолтного значения == -1
// companion object - это статические методы, которые лучше не использовать
class DetailRecipeFragment() : Fragment() {

    lateinit var currentRecipe: RecipeInfo
    lateinit var detailImageView: ImageView
    lateinit var detailTitleTextView: TextView
    lateinit var detailDescriptionTextView: TextView
    val recipeId by lazy{ arguments?.getInt("cusineId")?:-1}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_recipe, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[DetailRecipeViewModel::class.java]
        detailImageView = view?.findViewById(R.id.imageView_detail_screen)!!
        detailTitleTextView = view?.findViewById(R.id.textView_title_detail_screen)!!
        detailDescriptionTextView =
            view?.findViewById(R.id.textView_description_detail_screen)!!
        viewModel.recipeId = recipeId

        viewModel.makeDetailRecipeObservable()

        viewModel.getDetailRecipeObserver().observe(viewLifecycleOwner) {
            currentRecipe = it
            Glide.with(detailImageView)
                .load(currentRecipe.image)
                .centerCrop()
                .placeholder(R.drawable.loading_image)
                .into(detailImageView)

            detailTitleTextView.text = currentRecipe.title
            detailDescriptionTextView.text = currentRecipe.instructions
        }

    }

}