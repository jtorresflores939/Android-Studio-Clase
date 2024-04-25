package com.example.imagetoast4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            //Muestra el fragment de ImageSelection
            showImageSelectionFragment()
        }
    }

    //Metodo para mostrar el fragmento de ImageSelection
    fun showImageSelectionFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = ImageSelectionFragment()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.commit()
    }

    //Metodo para mostrar el fragmento de ImageDisplay
    fun showImageDisplayFragment(selectedImage: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = ImageDisplayFragment()
        val args = Bundle()
        args.putString("selectedImage", selectedImage)
        fragment.arguments = args
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
