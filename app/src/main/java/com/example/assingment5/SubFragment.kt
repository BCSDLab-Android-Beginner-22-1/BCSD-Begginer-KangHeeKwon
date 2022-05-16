package com.example.assingment5

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.myapplication.R

import java.util.*


class SubFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sub, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val random = Random()
        val countNumber = arguments?.getInt("num")
        val randomNumber = random.nextInt(countNumber!!+1)
        val text_waldo = view.findViewById<TextView>(R.id.Talk_text)
        val random_Count = view.findViewById<TextView>(R.id.Random_number)
        val bundle = Bundle()
        bundle.putInt("num", randomNumber)
        text_waldo.text = "있다 여기 무작위 숫자 사이 0 과 " + "$countNumber"
        random_Count.text = "$randomNumber"
        getActivity()?.getSupportFragmentManager()?.setFragmentResult("num", bundle);

    }
}