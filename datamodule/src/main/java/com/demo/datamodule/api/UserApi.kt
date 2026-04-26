package com.demo.data.api

import com.demo.data.model.User
import retrofit2.http.GET

interface UserApi {
    @GET("/users")
    suspend fun getUsers(): List<User>
}