package com.example.assignment7

import ZoomOutPageTransformer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.jwsoft.kotlinproject.MyViewPagerAdapter
import com.jwsoft.kotlinproject.MyViewPagerBdapter
import com.jwsoft.kotlinproject.MyViewPagerCdapter

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMain = findViewById<BottomNavigationView>(R.id.bottomNavigationview)

        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        val adapterA = MyViewPagerAdapter(this)
        val adapterB = MyViewPagerBdapter(this)
        val adapterC = MyViewPagerCdapter(this)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager2.adapter = adapterA
        viewPager2.setPageTransformer(ZoomOutPageTransformer())


        btnMain.run {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.pageA -> {
                        viewPager2.adapter = adapterA
                    }
                    R.id.pageB -> {
                        viewPager2.adapter = adapterB
                    }
                    R.id.pageC -> {
                        viewPager2.adapter = adapterC
                    }
                }
                true
            }
            selectedItemId = R.id.pageA
        }
    }
}