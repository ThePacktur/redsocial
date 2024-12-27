package com.example.rsocialapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class PostFragment : Fragment() {

    private lateinit var etPostText: EditText
    private lateinit var btnUploadImage: Button
    private lateinit var imgSelectedImage: ImageView
    private lateinit var btnPost: Button
    private var selectedImageUri: Uri? = null
    private val postViewModel: PostViewModel by activityViewModels()

    companion object {
        private const val REQUEST_IMAGE_PICK = 100
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_post, container, false)

        etPostText = view.findViewById(R.id.etPostText)
        btnUploadImage = view.findViewById(R.id.btnUploadImage)
        imgSelectedImage = view.findViewById(R.id.imgSelectedImage)
        btnPost = view.findViewById(R.id.btnPost)

        btnUploadImage.setOnClickListener {
            openGallery()
        }

        btnPost.setOnClickListener {
            handlePost()
        }

        return view
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_IMAGE_PICK)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_PICK && resultCode == Activity.RESULT_OK) {
            selectedImageUri = data?.data
            imgSelectedImage.setImageURI(selectedImageUri)
        }
    }

    private fun handlePost() {
        val postText = etPostText.text.toString()

        if (postText.isBlank() && selectedImageUri == null) {
            Toast.makeText(context, "Por favor, escribe un mensaje o selecciona una imagen", Toast.LENGTH_SHORT).show()
            return
        }

        val imageUriString = selectedImageUri?.toString()
        val newPost = Post(postText, imageUriString)
        postViewModel.addPost(newPost)

        Toast.makeText(context, "Post enviado con éxito", Toast.LENGTH_SHORT).show()

        etPostText.text.clear()
        imgSelectedImage.setImageURI(null)
    }
}