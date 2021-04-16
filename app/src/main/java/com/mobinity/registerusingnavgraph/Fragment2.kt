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
import com.mobinity.registerusingnavgraph.databinding.Fragment2Binding

class Fragment2 : Fragment() {

    private var _binding: Fragment2Binding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = Fragment2Binding.inflate(inflater, container, false)

        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnNext.setOnClickListener {
            if(binding.btnVerify.text == "인증번호 받기") Toast.makeText(requireContext(), "인증번호를 받고 입력주세요", Toast.LENGTH_SHORT).show()
            else if(binding.edVerificationCode.text.toString().length < 6) Toast.makeText(requireContext(), "인증번호 6자리를 입력해주세요", Toast.LENGTH_SHORT).show()
            else if(binding.edPhoneNumber.text.toString() != "" && binding.edVerificationCode.text.toString() != ""){
                val action = Fragment2Directions.actionFragment2ToFragment3(binding.edPhoneNumber.text.toString())
                Navigation.findNavController(view).navigate(action)
            }
        }

        binding.btnVerify.setOnClickListener {

            if(binding.edPhoneNumber.text.toString().length < 10) Toast.makeText(requireContext(), "휴대폰번호 10 ~ 11자리를 입력해주세요", Toast.LENGTH_SHORT).show()

            else{
                binding.btnVerify.text = "다시 받기"
                binding.tvPhoneNumber.visibility = View.VISIBLE
                binding.edVerificationCode.visibility = View.VISIBLE
            }

        }

    }


}
