package com.mobinity.registerusingnavgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.Navigation

class Fragment1 : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_1, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn = view.findViewById<Button>(R.id.btn)

        val checkBox1 = view.findViewById<CheckBox>(R.id.cb_1)
        val checkBox2 = view.findViewById<CheckBox>(R.id.cb_2)
        val checkBox3 = view.findViewById<CheckBox>(R.id.cb_3)
        val checkBox4 = view.findViewById<CheckBox>(R.id.cb_4)

        val arrow1 = view.findViewById<ImageView>(R.id.iv_arrow_1)
        val arrow2 = view.findViewById<ImageView>(R.id.iv_arrow_2)
        val arrow3 = view.findViewById<ImageView>(R.id.iv_arrow_3)


        checkBox1.setOnCheckedChangeListener { _, isChecked ->

            if(isChecked){
                checkBox2.isChecked = true
                checkBox3.isChecked = true
                checkBox4.isChecked = true
            }

//            else{
//
//                checkBox2.isChecked = false
//                checkBox3.isChecked = false
//                checkBox4.isChecked = false
//            }

            btnCheck(view, btn, checkBox2, checkBox3, checkBox4)

        }

        checkBox2.setOnCheckedChangeListener { _, _ ->
            btnCheck(view, btn, checkBox2, checkBox3, checkBox4)
            btnCheckAll(view, checkBox1, checkBox2, checkBox3, checkBox4)
        }
        checkBox3.setOnCheckedChangeListener { _, _ ->
            btnCheck(view, btn, checkBox2, checkBox3, checkBox4)
            btnCheckAll(view, checkBox1, checkBox2, checkBox3, checkBox4)
        }
        checkBox4.setOnCheckedChangeListener { _, _ ->
            btnCheck(view, btn, checkBox2, checkBox3, checkBox4)
            btnCheckAll(view, checkBox1, checkBox2, checkBox3, checkBox4)
        }

        checkBoxDetailBtnClick(view, arrow1, arrow2, arrow3)
    }

    private fun checkBoxDetailBtnClick(view: View, arrow1: ImageView, arrow2: ImageView, arrow3: ImageView){

        arrow1.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragment1_to_fragment11)
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