package com.demo.domain.repository

import com.demo.domain.model.UserData
import com.demo.domain.wrapper.ResultState

interface UserRepository {
    suspend fun getUsers(): ResultState<List<UserData>>
}