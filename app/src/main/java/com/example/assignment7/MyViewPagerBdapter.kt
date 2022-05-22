package com.jwsoft.kotlinproject

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.assignment7.NaviAFragment
import com.example.assignment7.NaviBFragment

class MyViewPagerBdapter(fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return NaviBFragment(position)
    }
    override fun getItemCount(): Int {
        return 11
    }
}