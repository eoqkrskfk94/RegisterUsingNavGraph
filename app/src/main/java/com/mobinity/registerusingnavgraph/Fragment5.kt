package com.mobinity.registerusingnavgraph

import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.mobinity.registerusingnavgraph.databinding.Fragment5Binding
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class Fragment5 : Fragment() {

    private var _binding: Fragment5Binding? = null
    private val binding get() = _binding!!
    private val REQUEST_IMAGE_CAPTURE = 1
    private val CROP_FROM_CAMERA = 2

    private lateinit var currentCameraUri: Uri
    private lateinit var currentPhotoPath: String
    var photoFile: File? = null


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

            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                // Ensure that there's a camera activity to handle the intent
                takePictureIntent.resolveActivity(requireContext().packageManager)?.also {
                    // Create the File where the photo should go
                    photoFile = try {
                        createImageFile()
                    } catch (ex: IOException) {
                        // Error occurred while creating the File
                        null
                    }
                    // Continue only if the File was successfully created
                    photoFile?.also {
                        val photoURI: Uri = FileProvider.getUriForFile(
                                requireContext(),
                                "com.example.android.fileprovider",
                                it
                        )
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                    }
                }
            }

        }

    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File? = context?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
                "JPEG_${timeStamp}_", /* prefix */
                ".jpg", /* suffix */
                storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = absolutePath
        }
    }

    /**
     * 카메라에서 촬영한 이미지를 프로필 아이콘에 사용할 크기로 자른다.
     */
    private fun cropImageFromCamera() {
//        val uri = Uri.fromFile(profileIconFile)

        //Android 7.0 이상부터 변경
        val uri = photoFile?.let {
            FileProvider.getUriForFile(
                    requireContext(),
                    "com.example.android.fileprovider",
                    it) }

        val intent = uri?.let { getCropIntent(it, uri) }
        startActivityForResult(intent, CROP_FROM_CAMERA)
    }

    /**
     * 이미지를 자르기 위한 Intent를 생성해서 반환한다.
     * @param inputUri 이미지를 자르기전 Uri
     * @param outputUri 이미지를 자른 결과 파일 Uri
     * @return 이미지를 자르기 위한 인텐트
     */
    private fun getCropIntent(inputUri: Uri, outputUri: Uri): Intent {
        val intent = Intent("com.android.camera.action.CROP")
        intent.setDataAndType(inputUri, "image/*")
        intent.putExtra("aspectX", 10)
        intent.putExtra("aspectY", 7)
//        intent.putExtra("outputX", 250)
//        intent.putExtra("outputY", 200)
        intent.putExtra("scale", true)

//        intent.putExtra("crop", true)
        intent.putExtra("return-data", false)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)

        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri)
        intent.putExtra("outputFormat", Bitmap.CompressFormat.PNG.toString())

        return intent
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            cropImageFromCamera()

        }

        else if (requestCode == CROP_FROM_CAMERA && resultCode == RESULT_OK){

            Glide.with(this).load(photoFile).into(binding.ivIdentificationCard)
        }
    }




}