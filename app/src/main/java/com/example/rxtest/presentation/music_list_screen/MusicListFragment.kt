package com.example.rxtest.presentation.music_list_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.rxtest.R

class MusicListFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MusicListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[MusicListViewModel::class.java]
        recyclerView = view.findViewById(R.id.rv_music_list)
        adapter = MusicListAdapter()
        recyclerView.adapter = adapter

        viewModel.makeApiMusicListObservable()

        viewModel.getMusichListObserver().observe(viewLifecycleOwner) { list ->
            adapter.setList(list.tracks)
    }

}}