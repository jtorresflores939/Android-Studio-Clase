package com.example.recyclerview

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.recyclerview.databinding.FragmentAddUserBinding

class AddUserFragment : Fragment() {
    private lateinit var binding: FragmentAddUserBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.buttonSave.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val email = binding.editTextEmail.text.toString()

            if (validateInput(name, email)) {
                val newUser = User(name, email, R.drawable.imagen_1)
                userViewModel.addUser(newUser)
                findNavController().navigateUp()
            } else {
                Toast.makeText(requireContext(), "Por favor llene todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInput(name: String, email: String): Boolean {
        return !(TextUtils.isEmpty(name) || TextUtils.isEmpty(email))
    }
}
