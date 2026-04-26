package com.demo.sampleapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.sampleapp.data.model.User
import com.demo.sampleapp.data.repository.UserRepository
import com.demo.sampleapp.data.wrapper.ResponseWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(private val userRepository: UserRepository) :
    ViewModel() {
    private val _uiState = MutableStateFlow<ResponseWrapper<List<User>>>(ResponseWrapper.Loading)
    val uiState: StateFlow<ResponseWrapper<List<User>>> = _uiState
    private val _selectedUser = MutableStateFlow<User?>(null)
    val selectedUser: StateFlow<User?> = _selectedUser

    init {
        loadUsers()
    }

    fun loadUsers() {
        viewModelScope.launch {
            _uiState.value = ResponseWrapper.Loading
            _uiState.value = userRepository.getUsers()
        }
    }

    fun selectUser(user: User) {
        _selectedUser.value = user
    }
}