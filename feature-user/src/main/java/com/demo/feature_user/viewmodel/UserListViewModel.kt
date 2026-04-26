package com.demo.feature_user.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.domain.model.UserData
import com.demo.domain.usecase.GetUsersUseCase
import com.demo.domain.wrapper.ResultState
import com.demo.feature_user.view.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<List<UserData>>>(UiState.Loading)
    val uiState = _uiState
    private val _selectedUser = MutableStateFlow<UserData?>(null)
    val selectedUser: StateFlow<UserData?> = _selectedUser

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
                val result = getUsersUseCase()
                _uiState.value = when (result) {
                    is ResultState.Success -> UiState.Success(result.data)
                    is ResultState.Error -> UiState.Error(result.message)
                }
        }
    }

    fun selectUser(user: UserData) {
        _selectedUser.value = user
    }
}