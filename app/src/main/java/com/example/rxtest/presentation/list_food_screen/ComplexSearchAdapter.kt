package com.example.rxtest.presentation.dog_screen

import android.annotation.SuppressLint
import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rxtest.R
import com.example.rxtest.data.model.Result
import com.example.rxtest.presentation.MainActivity
import kotlinx.coroutines.NonDisposableHandle.parent
import java.util.Collections.emptyList

class ComplexSearchAdapter : RecyclerView.Adapter<ComplexSearchAdapter.RetrofitHolder>() {

    var listComplexSearch = emptyList<Result>()

    class RetrofitHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageCuisine = view.findViewById<ImageView>(R.id.retrofit_image_item_id)
        var titleCuisine = view.findViewById<TextView>(R.id.retrofit_title_item_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_retrofit,
            parent, false
        )
        return RetrofitHolder(view)
    }

    override fun onBindViewHolder(holder: RetrofitHolder, position: Int) {
        //image
        Glide.with(holder.imageCuisine)
            .load(listComplexSearch[position].image)
            .placeholder(R.drawable.loading_image)
            .into(holder.imageCuisine)

        //description
        holder.titleCuisine.text =
            listComplexSearch[position].title

    }

    override fun getItemCount(): Int {
        return listComplexSearch.size
    }

    //function for set list
    @SuppressLint("NotifyDataSetChanged")
    fun setList(listResult: List<Result>) {
        listComplexSearch = listResult
        //if something change, Android notify us
        notifyDataSetChanged()

    }
}

