package com.example.rxtest.presentation.dog_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.rxtest.R

//будут кликабельные карточки, ко ViewModel  передать эти клики
class ComplexSearchFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ComplexSearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_retrofit, container, false)

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[ComplexSearchViewModel::class.java]
        recyclerView = view.findViewById(R.id.retrofit_rv)
        adapter = ComplexSearchAdapter()
        recyclerView.adapter = adapter

        viewModel.makeApiSearchObservable()

        viewModel.getSearchListObserver().observe(viewLifecycleOwner) { list ->
            adapter.setList(list.results)
        }
    }}