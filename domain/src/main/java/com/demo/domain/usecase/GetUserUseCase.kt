package com.demo.domain.usecase

import com.demo.domain.model.UserData
import com.demo.domain.repository.UserRepository
import com.demo.domain.wrapper.ResultState
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(): ResultState<List<UserData>> {
        val response = repository.getUsers()
        return response
    }
}
