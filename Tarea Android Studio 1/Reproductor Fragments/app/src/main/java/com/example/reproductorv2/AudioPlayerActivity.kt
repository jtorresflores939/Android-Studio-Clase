package com.example.reproductorv2

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AudioPlayerActivity : AppCompatActivity() {

    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // No se necesita el setContentView ya que no hay interfaz de usuario

        val audioResourceId = when(intent.getStringExtra("audio_name")) {
            "Audio 1" -> R.raw.audio1
            "Audio 2" -> R.raw.audio2
            "Audio 3" -> R.raw.audio3
            else -> R.raw.audio1 // Definir un valor predeterminado
        }

        mediaPlayer = MediaPlayer.create(this, audioResourceId)
        mediaPlayer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}



