package com.example.rxtest.presentation.music_list_screen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rxtest.R
import com.example.rxtest.data.model.model_music_list_fragment.Track
import com.example.rxtest.data.model.model_search_fragment.Result
import com.example.rxtest.presentation.Listener


class MusicListAdapter(
) : RecyclerView.Adapter<MusicListAdapter.RetrofitHolder>() {

    lateinit var mlistener: Listener
    var listMusicSearch = emptyList<Track>()

    fun setOnItemClickListener(listener: Listener) {
        mlistener = listener
    }

    class RetrofitHolder(view: View) : RecyclerView.ViewHolder(view) {
        var titleMusic = view.findViewById<TextView>(R.id.name_song_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_music,
            parent, false
        )
        return MusicListAdapter.RetrofitHolder(view)
    }

    override fun onBindViewHolder(holder: RetrofitHolder, position: Int) {
        //title
        holder.titleMusic.text =
            listMusicSearch[position].title
    }

    override fun getItemCount(): Int {
        return listMusicSearch.size
    }

    //function for set list
    @SuppressLint("NotifyDataSetChanged")
    fun setList(listResult: List<Track>) {
        listMusicSearch = listResult
        //if something change, Android notify us
        notifyDataSetChanged()

    }
}