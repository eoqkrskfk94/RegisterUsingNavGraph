package com.mobinity.registerusingnavgraph

import android.app.UiModeManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.Navigation
import com.mobinity.registerusingnavgraph.databinding.Fragment1Binding

class Fragment1 : Fragment() {

    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment1Binding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.cb1.setOnCheckedChangeListener { _, isChecked ->

            if(isChecked){

                binding.cb2.isChecked = true
                binding.cb3.isChecked = true
                binding.cb4.isChecked = true
            }

//            else{
//
//                checkBox2.isChecked = false
//                checkBox3.isChecked = false
//                checkBox4.isChecked = false
//            }

            btnCheck(view, binding.btn, binding.cb2, binding.cb3, binding.cb4)

        }

        binding.cb2.setOnCheckedChangeListener { _, _ ->
            btnCheck(view, binding.btn, binding.cb2, binding.cb3, binding.cb4)
            btnCheckAll(view, binding.cb1, binding.cb2, binding.cb3, binding.cb4)
        }
        binding.cb3.setOnCheckedChangeListener { _, _ ->
            btnCheck(view, binding.btn, binding.cb2, binding.cb3, binding.cb4)
            btnCheckAll(view, binding.cb1, binding.cb2, binding.cb3, binding.cb4)
        }
        binding.cb4.setOnCheckedChangeListener { _, _ ->
            btnCheck(view, binding.btn, binding.cb2, binding.cb3, binding.cb4)
            btnCheckAll(view, binding.cb1, binding.cb2, binding.cb3, binding.cb4)
        }

        checkBoxDetailBtnClick(view, binding.tv2, binding.tv3, binding.tv4)
    }

    private fun checkBoxDetailBtnClick(view: View, tv2: TextView, tv3: TextView, tv4: TextView){

        tv2.setOnClickListener {
            val action = Fragment1Directions.actionFragment1ToFragment11("1")
            Navigation.findNavController(view).navigate(action)
        }

        tv3.setOnClickListener {
            val action = Fragment1Directions.actionFragment1ToFragment11("2")
            Navigation.findNavController(view).navigate(action)
        }

        tv4.setOnClickListener {
            val action = Fragment1Directions.actionFragment1ToFragment11("3")
            Navigation.findNavController(view).navigate(action)
        }


    }


    private fun btnCheck(view: View, btn: Button, checkBox2: CheckBox, checkBox3: CheckBox, checkBox4: CheckBox){

        if(checkBox2.isChecked && checkBox3.isChecked && checkBox4.isChecked){

            btn.setBackgroundColor(requireContext().getColor(R.color.black))

            btn.setOnClickListener {
                val action = Fragment1Directions.actionFragment1ToFragment2(123456)
                Navigation.findNavController(view).navigate(action)
            }

        }

        else {

            btn.setOnClickListener {
                Toast.makeText(requireContext(), "no", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun btnCheckAll(view: View, checkBox1: CheckBox, checkBox2: CheckBox, checkBox3: CheckBox, checkBox4: CheckBox){

//        if(checkBox2.isChecked && checkBox3.isChecked && checkBox4.isChecked) checkBox1.isChecked = true
//        else checkBox1.isChecked = false

        checkBox1.isChecked = checkBox2.isChecked && checkBox3.isChecked && checkBox4.isChecked

    }

}