package com.mobinity.registerusingnavgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.Navigation
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

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.edBirthday.setOnClickListener {

            val builder = MaterialDatePicker.Builder.datePicker()
            val picker = builder.build()
            val dateFormat = SimpleDateFormat("yyyy년 MM월 dd일")

            picker.show(activity?.supportFragmentManager!!, picker.toString())

            picker.addOnPositiveButtonClickListener {

                binding.edBirthday.setText(dateFormat.format(it))

            }
        }

        binding.btnNext.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragment4_to_fragment5)
        }

        setGenderEditText()
    }

    private fun setGenderEditText(){
        val genders = listOf("남성", "여성")
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_list, genders)
        binding.actvGender.setAdapter(adapter)

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}