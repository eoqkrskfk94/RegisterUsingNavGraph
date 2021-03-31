package com.mobinity.registerusingnavgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs

class Fragment2 : Fragment() {

    val args: Fragment2Args by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_2, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnNext = view.findViewById<Button>(R.id.btn_next)
        val btnVerify = view.findViewById<Button>(R.id.btn_verify)

        val edPhoneNumber = view.findViewById<EditText>(R.id.ed_phone_number)
        val tvVerification = view.findViewById<TextView>(R.id.tv_verification)
        val edVerification = view.findViewById<EditText>(R.id.ed_verification_code)

        val myNumber = args.number

        btnNext.setOnClickListener {
            if(btnVerify.text == "인증번호 받기") Toast.makeText(requireContext(), "인증번호를 받고 입력주세요", Toast.LENGTH_SHORT).show()
            else if(edVerification.text.toString().length < 6) Toast.makeText(requireContext(), "인증번호 6자리를 입력해주세요", Toast.LENGTH_SHORT).show()
            else if(edPhoneNumber.text.toString() != "" && edVerification.text.toString() != ""){
                val action = Fragment2Directions.actionFragment2ToFragment3(edPhoneNumber.text.toString())
                Navigation.findNavController(view).navigate(action)
            }
        }

        btnVerify.setOnClickListener {

            if(edPhoneNumber.text.toString().length < 10) Toast.makeText(requireContext(), "휴대폰번호 10 ~ 11자리를 입력해주세요", Toast.LENGTH_SHORT).show()

            else{
                btnVerify.text = "다시 받기"
                tvVerification.visibility = View.VISIBLE
                edVerification.visibility = View.VISIBLE
            }

        }

    }


}
