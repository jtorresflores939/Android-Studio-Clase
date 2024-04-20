package com.example.imagetoast20


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var imageSpinner: Spinner
    private lateinit var nextButton: Button
    private lateinit var imageView: ImageView
    private lateinit var backButton: Button
    private var selectedImageIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar el Spinner y el Button de MainActivity
        imageSpinner = findViewById(R.id.imageSpinner)
        nextButton = findViewById(R.id.nextButton)
        imageView = findViewById(R.id.imageView)
        backButton = findViewById(R.id.backButton)

        // Configuracion de spinner
        val imageNames = arrayOf("image1", "image2", "image3")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, imageNames)
        imageSpinner.adapter = adapter

        // Restaurar la selección del Spinner
        savedInstanceState?.let {
            selectedImageIndex = it.getInt("selectedImageIndex")
            imageSpinner.setSelection(selectedImageIndex)
        }

        // Configurar el botón Siguiente
        nextButton.setOnClickListener {
            // Oculta el Spinner y el botón "Siguiente" de MainActivity
            imageSpinner.visibility = View.GONE
            nextButton.visibility = View.GONE

            // Mostrar la sección de ImageActivity
            imageView.visibility = View.VISIBLE
            backButton.visibility = View.VISIBLE

            // Obtener el nombre de la imagen seleccionada
            val selectedImage = imageSpinner.selectedItem as String
            // Configurar ImageView para mostrar la imagen seleccionada
            val resourceId = resources.getIdentifier(selectedImage, "drawable", packageName)
            imageView.setImageResource(resourceId)
        }

        // Configurar el botón Volver
        backButton.setOnClickListener {
            // Ocultar la sección de ImageActivity
            imageView.visibility = View.GONE
            backButton.visibility = View.GONE

            // Mostrar el Spinner y el botón Siguiente de MainActivity
            imageSpinner.visibility = View.VISIBLE
            nextButton.visibility = View.VISIBLE
        }
    }

    // Guardar el estado de la selección del Spinner
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        selectedImageIndex = imageSpinner.selectedItemPosition
        outState.putInt("selectedImageIndex", selectedImageIndex)
    }
}
