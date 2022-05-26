package com.jwsoft.kotlinproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.assignment7.NaviAFragment

class MyViewPagerAdapter(fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        val fragmentA = NaviAFragment()
        val bundle = Bundle()
        bundle.putInt("positionA", position)
        fragmentA.arguments = bundle
        return fragmentA
    }
    override fun getItemCount(): Int {
        return 7
    }
}

