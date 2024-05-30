package com.example.recyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int = 0,
    val name: String,
    val email: String,
    val imageResId: Int
) : Parcelable
