package com.example.assignment7

import android.graphics.Color
import android.graphics.Color.RED
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class NaviAFragment(position: Int): Fragment(){

    private var position = position

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var colorList = listOf<String>("#FF0000", "#FF9900", "#FFCC00", "#00FF00", "#3700B3", "#000099", "#990099")
        val view: View = inflater.inflate(R.layout.fragment_navi_a, container, false)
        view.setBackgroundColor(Color.parseColor(colorList[position]))
        return view
    }
}