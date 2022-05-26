package com.example.assignment7
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class NaviBFragment() : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val position = requireArguments().getInt("positionB")
        val view: View = inflater.inflate(R.layout.fragment_navi_b, container, false)
        val txtCount: TextView = view.findViewById(R.id.txtCount2)
        txtCount.text = position.toString()
        return view
    }

}