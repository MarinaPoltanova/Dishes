package com.example.rxtest.presentation.dog_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.rxtest.R
import kotlinx.android.synthetic.main.fragment_retrofit.view.*

//отобразить интерфейс
//будут кликабельные карточки, ко ViewModel  передать эти клики
class RetrofitFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ComplexSearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this).get(DogViewModel::class.java)
        val v = inflater.inflate(R.layout.fragment_retrofit, container, false)
        recyclerView = v.retrofit_rv
        adapter = ComplexSearchAdapter()
        recyclerView.adapter = adapter
        viewModel.makeApiSearchObservable()

        return v
    }

}