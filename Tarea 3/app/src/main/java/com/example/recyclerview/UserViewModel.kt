package com.example.recyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private val _userList = MutableLiveData<List<User>>().apply {
        value = generateDummyUsers()
    }
    val userList: LiveData<List<User>> = _userList

    fun addUser(user: User) {
        val currentList = _userList.value?.toMutableList() ?: mutableListOf()
        currentList.add(user)
        _userList.value = currentList
    }

    fun updateUser(updatedUser: User) {
        val currentList = _userList.value?.toMutableList() ?: mutableListOf()
        val index = currentList.indexOfFirst { it.id == updatedUser.id }
        if (index != -1) {
            currentList[index] = updatedUser
            _userList.value = currentList
        }
    }

    fun deleteUser(user: User) {
        val currentList = _userList.value?.toMutableList() ?: mutableListOf()
        currentList.remove(user)
        _userList.value = currentList
    }

    private fun generateDummyUsers(): List<User> {
        return listOf(
            User(1, "Juan Alcachofa", "jalcachofa@gmail.com", R.drawable.imagen_1),
            User(2, "Big Billy", "BigBilly@gmail.com", R.drawable.imagen_1),
            User(3, "Cesar Mesia", "CesarMe@gmail.com", R.drawable.imagen_1),
            User(4, "Kratos Alberra", "KraAlberra@gmail.com", R.drawable.imagen_1),
            User(5, "Jason Ford", "jasonFrod@gmail.com", R.drawable.imagen_1),
            User(6, "Jane Smith", "janmith@gmail.com", R.drawable.imagen_1),


            // Agrega más usuarios aquí
        )
    }
}
