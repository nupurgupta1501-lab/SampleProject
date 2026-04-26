package com.demo.sampleapp.data.repository

import com.demo.sampleapp.data.model.User
import com.demo.sampleapp.data.wrapper.ResponseWrapper
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUsers(): ResponseWrapper<List<User>>
}