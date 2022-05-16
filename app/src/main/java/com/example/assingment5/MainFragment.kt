package com.example.assingment5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.R


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)

        requireActivity().supportFragmentManager.setFragmentResultListener(
            "num",
            viewLifecycleOwner
        ) { requestKey, bundle ->
            val result = bundle.getInt("num")
            val countNumber = rootView.findViewById<TextView>(R.id.Count_number)
            countNumber.setText(result.toString())
            (activity as MainActivity).count = result
        }
        return (rootView)
    }
}

