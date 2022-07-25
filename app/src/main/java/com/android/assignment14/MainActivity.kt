package com.android.assignment14

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.android.assignment14.R
import com.android.assignment14.fragment.FilmListFragment
import com.android.assignment14.fragment.PeopleListFragment
import com.android.assignment14.fragment.PlanetsListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val film by lazy { FilmListFragment() }
    private val plant by lazy { PlanetsListFragment() }
    private val people by lazy { PeopleListFragment() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupFragment()
    }

    private fun setupFragment() {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bnv_main)
        bottomNavigation.run{
            setOnItemSelectedListener { item ->
                when(item.itemId){
                    R.id.first -> {
                        changeFragment(film)
                    }
                    R.id.second -> {
                        changeFragment(plant)
                    }
                    R.id.third -> {
                        changeFragment(people)
                    }
                }
                true
            }
            selectedItemId = R.id.first
        }

    }

    private fun changeFragment(fragment : Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_container, fragment)
            .commit()
    }
}

















