package com.example.reproductorv2
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AudioPlayerActivity : AppCompatActivity() {

    lateinit var audioImage: ImageView
    lateinit var audioName: TextView
    lateinit var playButton: Button
    lateinit var pauseButton: Button
    lateinit var stopButton: Button
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)

        audioImage = findViewById(R.id.audio_image)
        audioName = findViewById(R.id.audio_name)
        playButton = findViewById(R.id.play_button)
        pauseButton = findViewById(R.id.pause_button)
        stopButton = findViewById(R.id.stop_button)

        val audioNameStr = intent.getStringExtra("audio_name")
        audioName.text = audioNameStr

        mediaPlayer = MediaPlayer.create(this, R.raw.audio1)

        playButton.setOnClickListener {
            mediaPlayer.start()
        }

        pauseButton.setOnClickListener {
            mediaPlayer.pause()
        }

        stopButton.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer = MediaPlayer.create(this, R.raw.audio1)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}

