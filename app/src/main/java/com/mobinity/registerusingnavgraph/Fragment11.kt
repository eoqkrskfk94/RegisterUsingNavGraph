package com.mobinity.registerusingnavgraph

import android.os.Bundle
import android.system.Os.close
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.mobinity.registerusingnavgraph.databinding.Fragment11Binding


class Fragment11 : Fragment() {

    private val args: Fragment11Args by navArgs()
    private var _binding: Fragment11Binding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = Fragment11Binding.inflate(inflater, container, false)
        val view = binding.root


        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val type = args.agreementType
        setWebView(type)

    }

    private fun setWebView(type: String){

        binding.wb1.settings.builtInZoomControls = true
        binding.wb1.settings.domStorageEnabled = true
        binding.wb1.scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_INSET
        binding.wb1.settings.javaScriptEnabled = true
        binding.wb1.settings.allowFileAccess = true

        when(type){
            "1" -> binding.wb1.loadUrl("https://naver.com")
            "2" -> binding.wb1.loadUrl("https://google.com")
            "3" -> binding.wb1.loadUrl("https://facebook.com")
        }

        binding.wb1.webViewClient = WebViewClient()

    }

}