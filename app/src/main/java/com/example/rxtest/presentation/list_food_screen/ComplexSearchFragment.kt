package com.example.rxtest.presentation.list_food_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.rxtest.R
import com.example.rxtest.presentation.DataModel
import com.example.rxtest.presentation.Listener
import com.example.rxtest.presentation.detail_food_screen.DetailRecipeFragment
import kotlin.properties.Delegates

//бэкстек
//передача данных между фрагментами через аргументы (bundels)

//сильные слабые ссылки
class ComplexSearchFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ComplexSearchAdapter

    //    private val dataModel: DataModel by activityViewModels()
    var cusineId by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_recipe_list, container, false)
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

        adapter.setOnItemClickListener(object : Listener {
            override fun onClickListener(position: Int) {
//создали бандл
                cusineId = position
                val bundle = Bundle()
                bundle.putInt("cusineId", cusineId)
                println("--------------")
                println(cusineId)

//создаем второй фрагмент и устанавливаем бандл
                val detailFragment = DetailRecipeFragment()
                detailFragment.arguments = bundle
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.container, detailFragment)
                    ?.addToBackStack("Recipe") //положила в стек
                    ?.commit()

            }

        })
    }

}