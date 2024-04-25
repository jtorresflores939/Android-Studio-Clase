package com.example.reproductorv2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {

    lateinit var audioSpinner: Spinner
    lateinit var selectButton: Button
    lateinit var fragmentContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        audioSpinner = findViewById(R.id.audio_spinner)
        selectButton = findViewById(R.id.select_button)
        fragmentContainer = findViewById(R.id.fragment_container)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.audio_names,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        audioSpinner.adapter = adapter

        selectButton.setOnClickListener {
            val selectedAudio = audioSpinner.selectedItem.toString()
            val fragment = when(selectedAudio) {
                "Audio 1" -> Fragment1()
                "Audio 2" -> Fragment2()
                "Audio 3" -> Fragment3()
                else -> Fragment1() // Fragmento predeterminado
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }
    }
}

