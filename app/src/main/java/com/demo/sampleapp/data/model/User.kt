package com.demo.sampleapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int, val name: String, val email: String,
    @SerializedName("photo")
    val image: String,
    val address: String,
    val zip: String,
    val state: String,
    val country: String
) : Parcelable