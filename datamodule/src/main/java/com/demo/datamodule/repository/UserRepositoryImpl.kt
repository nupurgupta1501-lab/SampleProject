package com.demo.datamodule.repository

import com.demo.data.api.UserApi
import com.demo.data.model.User
import com.demo.domain.model.UserData
import com.demo.domain.repository.UserRepository
import com.demo.domain.wrapper.ResultState
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val api: UserApi) : UserRepository {
    override suspend fun getUsers(): ResultState<List<UserData>> {
        return try {
            ResultState.Success(api.getUsers().map { it.toDomain() })
        } catch (e: Exception) {
            ResultState.Error("Something went wrong")
        }
    }
}

fun User.toDomain(): UserData {
    return UserData(
        id = id,
        name = name,
        email = email,
        image = image,
        address = address,
        zip = zip,
        state = state,
        country = country
    )
}