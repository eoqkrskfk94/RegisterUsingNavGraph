package com.mobinity.registerusingnavgraph

import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.FileProvider
import com.mobinity.registerusingnavgraph.databinding.Fragment5Binding
import java.io.File

class Fragment5 : Fragment() {

    private var _binding: Fragment5Binding? = null
    private val binding get() = _binding!!
    private val REQUEST_IMAGE_CAPTURE = 1

    private lateinit var imageFile: File


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment5Binding.inflate(inflater, container, false)
        val view = binding.root

        cameraBtnClick()

        return view
    }

    private fun cameraBtnClick(){

        binding.cvIdentificationCard.setOnClickListener {

            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            try {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            } catch (e: ActivityNotFoundException) {
                // display error state to the user
                Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
            }

        }



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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            binding.ivIdentificationCard.setImageBitmap(imageBitmap)
        }
    }

//    fun getImageFile(context: Context, name: String): File {
//        return File(getFileDir(context), "$name.png")
//    }

}