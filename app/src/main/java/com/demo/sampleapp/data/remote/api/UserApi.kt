package com.demo.sampleapp.data.remote.api

import com.demo.sampleapp.data.model.User
import retrofit2.http.GET

interface UserApi {
    @GET("/users")
    suspend fun getUsers(): List<User>
}