package com.mobinity.registerusingnavgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class Fragment1 : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_1, container, false)

        val btn = view.findViewById<Button>(R.id.btn)

        btn.setOnClickListener {
            val action = Fragment1Directions.actionFragment1ToFragment2(123456)
            Navigation.findNavController(view).navigate(action)
        }

        return view
    }

}