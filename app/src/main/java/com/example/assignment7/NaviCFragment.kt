package com.example.assignment7
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class NaviCFragment() : Fragment(){



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val position = requireArguments().getInt("positionC")
        val ABC = ArrayList<Char>()
        for (i in 'A' .. 'Z'){ ABC.add(i) }
        val view: View = inflater.inflate(R.layout.fragment_navi_c, container, false)
        val txtCount: TextView = view.findViewById(R.id.txtCount3)
        txtCount.text = ABC[position].toString()

        return view
    }
}

