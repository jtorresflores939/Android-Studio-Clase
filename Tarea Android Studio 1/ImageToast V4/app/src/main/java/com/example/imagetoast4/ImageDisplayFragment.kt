package com.example.imagetoast4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class ImageDisplayFragment : Fragment() {

    private lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_image_display, container, false)

        //Inicializar las views
        imageView = view.findViewById(R.id.imageView)

        //Un get para las imagenes seleccionadas de los arguments
        val selectedImage = arguments?.getString("selectedImage")

        //Set selectedImage a ImageView
        val resourceId = resources.getIdentifier(selectedImage, "drawable", requireActivity().packageName)
        imageView.setImageResource(resourceId)

        return view
    }
}
