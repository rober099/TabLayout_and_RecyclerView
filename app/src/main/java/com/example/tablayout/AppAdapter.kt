package com.example.tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class AppAdapter(fragManager: FragmentManager,
                 private var totalTabs: Int): FragmentPagerAdapter(fragManager) {
        override fun getCount(): Int{
            return totalTabs
        }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 ->{GamesFragment()}
            1 ->{AppFragment()}
            2 ->{MovieFragment()}
            3 ->{BookFragment()}
            else -> return GamesFragment()
        }
    }

}