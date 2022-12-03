package com.example.rxtest.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.rxtest.presentation.list_food_screen.ComplexSearchFragment
import com.example.rxtest.presentation.music_list_screen.MusicListFragment

class ViewPager2Adapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {


    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 ->
                ComplexSearchFragment()

            1 ->
                MusicListFragment()

            else ->
                ComplexSearchFragment()
        }
    }
}