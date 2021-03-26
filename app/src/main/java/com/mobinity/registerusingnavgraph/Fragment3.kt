package com.mobinity.registerusingnavgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.mobinity.registerusingnavgraph.databinding.Fragment3Binding

class Fragment3 : Fragment() {

    private var _binding: Fragment3Binding? = null
    private val args: Fragment3Args by navArgs()
    private var phoneNumber: String? = null

    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = Fragment3Binding.inflate(inflater, container, false)
        val view = binding.root

        phoneNumber = args.phoneNumber
        binding.edPhoneNumber.setText(phoneNumber)

        binding.btnNext.setOnClickListener {
            if(binding.edPassword.text.toString() == binding.edPasswordVerify.text.toString()) Navigation.findNavController(view).navigate(R.id.finishActivity)
            else Toast.makeText(requireContext(), "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
        }


        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}