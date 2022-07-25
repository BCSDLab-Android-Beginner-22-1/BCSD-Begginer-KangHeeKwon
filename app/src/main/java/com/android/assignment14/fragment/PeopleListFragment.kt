package com.android.assignment14.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.assignment14.R
import com.android.assignment14.adapter.PeopleRecyclerViewAdapter
import com.android.assignment14.models.PeopleRecyclerList
import com.android.assignment14.viewmodel.PeopleViewModel


class PeopleListFragment : Fragment() {

    private lateinit var recyclerAdapter : PeopleRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_people_list, container, false)

        initViewModel(view)
        initViewModel()
        return view

    }

    private fun initViewModel(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val decortion  = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decortion)

        recyclerAdapter = PeopleRecyclerViewAdapter()
        recyclerView.adapter = recyclerAdapter


    }

    private fun initViewModel() {
        val viewModel  = ViewModelProvider(this).get(PeopleViewModel::class.java)
        viewModel.getRecyclerListObserver().observe(viewLifecycleOwner, Observer<PeopleRecyclerList> {
            if(it != null) {
                recyclerAdapter.setUpdatedData(it.results)
            } else {
                Toast.makeText(activity, "Error in getting data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall()
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            PeopleListFragment()
    }
}