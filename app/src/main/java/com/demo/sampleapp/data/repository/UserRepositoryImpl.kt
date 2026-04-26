package com.demo.sampleapp.data.repository

import com.demo.sampleapp.data.model.User
import com.demo.sampleapp.data.remote.api.UserApi
import com.demo.sampleapp.data.wrapper.ResponseWrapper
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val api: UserApi) : UserRepository {
    override suspend fun getUsers(): ResponseWrapper<List<User>> {
        return try {
            val users = api.getUsers()
            ResponseWrapper.Success(users)
        } catch (e: Exception) {
            ResponseWrapper.Error("Failed to fetch users", e)
        }
    }
}