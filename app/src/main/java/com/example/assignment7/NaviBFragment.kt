package com.example.assignment7
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class NaviBFragment(position: Int) : Fragment(){

    private var position = position

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_navi_b, container, false)
        val txtCount: TextView = view.findViewById(R.id.txtCount2)
        txtCount.text = position.toString()
        return view
    }

}