package com.demo.domain.model

data class UserData(
    val id: Int, val name: String, val email: String,
    val image: String,
    val address: String,
    val zip: String,
    val state: String,
    val country: String
)