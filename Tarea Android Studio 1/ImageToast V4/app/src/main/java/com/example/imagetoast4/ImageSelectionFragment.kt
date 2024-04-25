package com.example.imagetoast4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment

class ImageSelectionFragment : Fragment() {

    private lateinit var imageSpinner: Spinner
    private lateinit var nextButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_image_selection, container, false)

        // Initialize views
        imageSpinner = view.findViewById(R.id.imageSpinner)
        nextButton = view.findViewById(R.id.nextButton)

        // Configure image spinner
        val imageNames = arrayOf("image1", "image2", "image3")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, imageNames)
        imageSpinner.adapter = adapter

        // Configure Next button click listener
        nextButton.setOnClickListener {
            // Notify MainActivity to switch to ImageDisplayFragment
            (requireActivity() as MainActivity).showImageDisplayFragment(imageSpinner.selectedItem as String)
        }

        return view
    }
}
