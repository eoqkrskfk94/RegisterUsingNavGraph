package com.mobinity.registerusingnavgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.datepicker.MaterialDatePicker
import com.mobinity.registerusingnavgraph.databinding.Fragment4Binding
import java.text.SimpleDateFormat

class Fragment4 : Fragment() {

    private var _binding: Fragment4Binding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment4Binding.inflate(inflater, container, false)
        val view = binding.root

        binding.edBirthday.setOnClickListener {

            val builder = MaterialDatePicker.Builder.datePicker()
            val picker = builder.build()
            val dateFormat = SimpleDateFormat("yyyy.MM.dd")

            picker.show(activity?.supportFragmentManager!!, picker.toString())
        }



        return view
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}