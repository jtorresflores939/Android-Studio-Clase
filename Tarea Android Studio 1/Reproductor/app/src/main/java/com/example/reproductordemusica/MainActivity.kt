package com.example.reproductordemusica

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var playButton: Button
    private lateinit var pauseButton: Button
    private lateinit var stopButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playButton = findViewById(R.id.playButton) // Inicialización de botones
        pauseButton = findViewById(R.id.pauseButton)
        stopButton = findViewById(R.id.stopButton)

        playButton.setOnClickListener(this)
        pauseButton.setOnClickListener(this)
        stopButton.setOnClickListener(this)
// Se crea el mediaplayer, antes crear la carpeta raw donde tiene que estar el audio1
        mediaPlayer = MediaPlayer.create(this, R.raw.audio1) // audio1 debe estar en la carpeta raw
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.playButton -> {//iniciar el audio
                if (!mediaPlayer.isPlaying) {
                    mediaPlayer.start()
                }
            }//pausar el audio
            R.id.pauseButton -> {
                if (mediaPlayer.isPlaying) {
                    mediaPlayer.pause()
                }
            } //detener el audio
            R.id.stopButton -> {
                mediaPlayer.stop()
                mediaPlayer.prepare()
            }
        }
    }
    // Para evitar fugas de memoria
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}