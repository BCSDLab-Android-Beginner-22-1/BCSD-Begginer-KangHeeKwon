package com.example.assignment7

import ZoomOutPageTransformer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jwsoft.kotlinproject.MyViewPagerAdapter
import com.jwsoft.kotlinproject.MyViewPagerBdapter
import com.jwsoft.kotlinproject.MyViewPagerCdapter

class MainActivity : AppCompatActivity(){
    var state = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMain = findViewById<BottomNavigationView>(R.id.bottomNavigationview)
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        val adapterA = MyViewPagerAdapter(this)
        val adapterB = MyViewPagerBdapter(this)
        val adapterC = MyViewPagerCdapter(this)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager2.setPageTransformer(ZoomOutPageTransformer())

        if(savedInstanceState != null){
            state = savedInstanceState.getInt("STATE")
            when(state){
                0 -> viewPager2.adapter = adapterA
                1 -> viewPager2.adapter = adapterB
                2 -> viewPager2.adapter = adapterC
            }
        }
        else
            viewPager2.adapter = adapterA
        btnMain.run {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.pageA -> {
                        viewPager2.adapter = adapterA
                        state = 0
                    }
                    R.id.pageB -> {
                        viewPager2.adapter = adapterB
                        state = 1
                    }
                    R.id.pageC -> {
                        viewPager2.adapter = adapterC
                        state = 2
                    }
                }
                true
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("STATE", state)
        super.onSaveInstanceState(outState)
    }
}
