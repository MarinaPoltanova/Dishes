package com.example.rxtest.presentation.dog_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxtest.R
import com.example.rxtest.model.retrofit.DescriptionFact
import com.example.rxtest.model.retrofit.ImageDog
import kotlinx.android.synthetic.main.item_retrofit.view.*
import java.util.Collections.emptyList

class DogAdapter : RecyclerView.Adapter<DogAdapter.RetrofitHolder>() {

    var listImage = emptyList<ImageDog>()
    var listDescription = emptyList<DescriptionFact>()

    class RetrofitHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageDog = view.retrofit_image_item_id
        val descriptionFact = view.retrofit_description_preview_item_id
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
//        holder.itemView.retrofit_image_item_idge_item_id. =  listDescription[position].facts.toString()

        //description
        holder.itemView.retrofit_description_preview_item_id.text =
            listDescription[position].facts.toString()

    }

    override fun getItemCount(): Int {
        return listDescription.size
    }

    //function for set list

    fun setList( listDesc: List<DescriptionFact>) {
        listDescription = listDesc
        //if something change, Android notify us
        notifyDataSetChanged()

    }
}