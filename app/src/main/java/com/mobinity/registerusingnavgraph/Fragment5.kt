package com.mobinity.registerusingnavgraph

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.FileProvider
import com.mobinity.registerusingnavgraph.databinding.Fragment5Binding
import java.io.File

class Fragment5 : Fragment() {

    private var _binding: Fragment5Binding? = null
    private val binding get() = _binding!!

    private lateinit var imageFile: File


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment5Binding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    private fun cameraBtnClick(){

//        val imageFileName = "sample" + System.currentTimeMillis().toString()
//        imageFile = FileLib.getInstance()!!.getImageFile(this, imageFileName)
//
//        binding.ivIdentificationCard.setOnClickListener {
//
//            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            //Android 7.0 이상부터 변경
//            val uri = FileProvider.getUriForFile(requireContext(), requireContext().packageName + ".share", imageFile)
//            //currentCameraUri = uri
//
//            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
//            startActivityForResult(intent, 0)
//
//
//
//        }

    }

//    fun getImageFile(context: Context, name: String): File {
//        return File(getFileDir(context), "$name.png")
//    }

}