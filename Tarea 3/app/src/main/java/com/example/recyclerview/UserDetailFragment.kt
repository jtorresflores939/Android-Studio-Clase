package com.example.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.recyclerview.databinding.FragmentUserDetailBinding

class UserDetailFragment : Fragment() {
    private lateinit var binding: FragmentUserDetailBinding
    private lateinit var userViewModel: UserViewModel
    private val args: UserDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val user = args.user
        binding.editTextName.setText(user.name)
        binding.editTextEmail.setText(user.email)

        binding.buttonUpdate.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val email = binding.editTextEmail.text.toString()

            if (validateInput(name, email)) {
                val updatedUser = user.copy(name = name, email = email)
                userViewModel.updateUser(updatedUser)
                findNavController().navigateUp()
            } else {
                Toast.makeText(requireContext(), "Por favor llene todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonDelete.setOnClickListener {
            userViewModel.deleteUser(user)
            findNavController().navigateUp()
        }
    }

    private fun validateInput(name: String, email: String): Boolean {
        return !(TextUtils.isEmpty(name) || TextUtils.isEmpty(email))
    }
}
