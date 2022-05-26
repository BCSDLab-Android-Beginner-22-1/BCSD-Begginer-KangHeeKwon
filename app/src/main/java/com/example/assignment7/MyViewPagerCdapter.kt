package com.jwsoft.kotlinproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.assignment7.NaviCFragment

class MyViewPagerCdapter(fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        val fragmentC = NaviCFragment()
        val bundle = Bundle()
        bundle.putInt("positionC", position)
        fragmentC.arguments = bundle
        return fragmentC
    }
    override fun getItemCount(): Int {
        return 26
    }
}