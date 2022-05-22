package com.jwsoft.kotlinproject

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.assignment7.NaviAFragment
import com.example.assignment7.NaviBFragment
import com.example.assignment7.NaviCFragment

class MyViewPagerCdapter(fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return NaviCFragment(position)
    }
    override fun getItemCount(): Int {
        return 26
    }
}