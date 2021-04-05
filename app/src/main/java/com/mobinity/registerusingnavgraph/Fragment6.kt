package com.mobinity.registerusingnavgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.Navigation
import com.mobinity.registerusingnavgraph.databinding.Fragment6Binding


class Fragment6 : Fragment() {

    private var _binding: Fragment6Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = Fragment6Binding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBankEditText()


        binding.btnNext.setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.action_fragment6_to_fragment7)

        }

    }


    private fun setBankEditText(){
        val items = listOf("기업은행", "국민은행", "신한은행", "우리은행", "농협은행" , "외환은행" , "수협은행", "SC제일은행",
            "부산은행", "광주은행" , "우체국", "KEB하나은행", "대구은행", "경남은행", "HSBC", "산업은행", "새마을금고", "신협", "씨티은행", "전북은행", "제주은행", "케이뱅크", "카카오뱅크")
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_list, items)
        binding.actvBankName.setAdapter(adapter)

    }

}