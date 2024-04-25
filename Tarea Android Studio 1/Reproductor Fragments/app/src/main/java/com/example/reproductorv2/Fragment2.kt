package com.example.reproductorv2

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class Fragment2 : Fragment() {

    lateinit var playButton: Button
    lateinit var stopButton: Button
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView( // Método llamado cuando se crea la vista del fragmento
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_2, container, false)

        playButton = view.findViewById(R.id.play_button_fragment2)
        stopButton = view.findViewById(R.id.stop_button_fragment2)

        mediaPlayer = MediaPlayer.create(requireActivity(), R.raw.audio2)
// Configura un listener para el botón de reproducción
        playButton.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            }
        }
// Configura un listener para el botón de detención
        stopButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
                mediaPlayer.prepare()
            }
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}