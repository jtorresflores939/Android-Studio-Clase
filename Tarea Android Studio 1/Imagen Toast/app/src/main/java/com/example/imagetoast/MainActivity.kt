package com.example.imagetoast//nota mental, no borrar esta linea

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView: ImageView = findViewById(R.id.imageView)
        imageView.setOnClickListener {
            // Muestra el msj personalizado cuando se da click en la imagen
            Toast.makeText(this, "NO ME TOQUES", Toast.LENGTH_SHORT).show()
        }
    }
}