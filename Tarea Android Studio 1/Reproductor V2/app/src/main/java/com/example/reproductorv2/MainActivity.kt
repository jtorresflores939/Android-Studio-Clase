package com.example.reproductorv2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var audioSpinner: Spinner
    lateinit var selectButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        audioSpinner = findViewById(R.id.audio_spinner)
        selectButton = findViewById(R.id.select_button)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.audio_names,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        audioSpinner.adapter = adapter

        selectButton.setOnClickListener {
            val selectedAudio = audioSpinner.selectedItem.toString()
            val intent = Intent(this, AudioPlayerActivity::class.java).apply {
                putExtra("audio_name", selectedAudio)
            }
            startActivity(intent)
        }
    }
}
