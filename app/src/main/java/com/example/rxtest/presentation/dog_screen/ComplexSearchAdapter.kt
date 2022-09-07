package com.example.rxtest.presentation.dog_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxtest.R
import com.example.rxtest.data.model.Result
import kotlinx.android.synthetic.main.item_retrofit.view.*
import java.util.Collections.emptyList

class ComplexSearchAdapter : RecyclerView.Adapter<ComplexSearchAdapter.RetrofitHolder>() {

    var listComplexSearch = emptyList<Result>()

    class RetrofitHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageCuisine = view.retrofit_image_item_id
        val titleCuisine = view.retrofit_description_preview_item_id
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
//        holder.itemView.retrofit_image_item_id.setImageURI(uri = ) =
//            listComplexSearch[position].image
        //description
        holder.itemView.retrofit_description_preview_item_id.text =
            listComplexSearch[position].title

    }

    override fun getItemCount(): Int {
        return listComplexSearch.size
    }

    //function for set list

    fun setList( listResult: List<Result>) {
        listComplexSearch = listResult
        //if something change, Android notify us
        notifyDataSetChanged()

    }
}