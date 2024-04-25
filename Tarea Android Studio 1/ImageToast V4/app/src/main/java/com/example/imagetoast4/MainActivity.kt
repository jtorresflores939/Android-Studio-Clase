package com.example.imagetoast4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            // Show ImageSelectionFragment when activity is first created
            showImageSelectionFragment()
        }
    }

    // Method to show ImageSelectionFragment
    fun showImageSelectionFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = ImageSelectionFragment()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.commit()
    }

    // Method to show ImageDisplayFragment
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
