package com.mobinity.registerusingnavgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobinity.registerusingnavgraph.databinding.Fragment7Binding


class Fragment7 : Fragment() {

    private var _binding: Fragment7Binding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = Fragment7Binding.inflate(inflater, container, false)

        val view = binding.root

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tv2.text = "홍길동님의 계정은 현재"
    }

}