package com.jwsoft.kotlinproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.assignment7.NaviBFragment

class MyViewPagerBdapter(fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        val fragmentB = NaviBFragment()
        val bundle = Bundle()
        bundle.putInt("positionB", position)
        fragmentB.arguments = bundle
        return fragmentB
    }
    override fun getItemCount(): Int {
        return 11
    }
}