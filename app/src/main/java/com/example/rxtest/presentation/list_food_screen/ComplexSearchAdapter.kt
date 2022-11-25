package com.example.rxtest.presentation.list_food_screen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rxtest.R
import com.example.rxtest.data.model.model_search_fragment.Result
import com.example.rxtest.presentation.Listener
import java.util.Collections.emptyList

// как работает viewHolder ? (ListView vs RecyclerView (пересоздает и переиспользует))
class ComplexSearchAdapter(
) : RecyclerView.Adapter<ComplexSearchAdapter.RetrofitHolder>() {

    lateinit var mlistener: Listener
    var listComplexSearch = emptyList<Result>()

    fun setOnItemClickListener(listener: Listener){
        mlistener = listener
    }
    class RetrofitHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageCuisine = view.findViewById<ImageView>(R.id.retrofit_image_item_id)
        var titleCuisine = view.findViewById<TextView>(R.id.retrofit_title_item_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitHolder {

        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_recipe,
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

        holder.itemView.setOnClickListener {
            listComplexSearch[position].id?.let { it1 -> mlistener.onClickListener(it1) }
        }
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

