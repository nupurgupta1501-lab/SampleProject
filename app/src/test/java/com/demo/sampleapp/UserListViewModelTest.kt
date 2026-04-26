
package com.demo.sampleapp.viewmodel

import com.demo.sampleapp.data.model.User
import com.demo.sampleapp.data.repository.UserRepository
import com.demo.sampleapp.data.wrapper.ResponseWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserListViewModelTest {
    private val testDispatcher = StandardTestDispatcher()

    @Mock
    lateinit var repository: UserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun test_LoadUsers() = runTest{
        Mockito.`when`(repository.getUsers()).thenReturn(ResponseWrapper.Success(emptyList()))
        val viewModel = UserListViewModel(repository)
        viewModel.loadUsers()
        testDispatcher.scheduler.advanceUntilIdle()
        val result = viewModel.uiState.value
        assertTrue(result is ResponseWrapper.Success)
        assertEquals(emptyList<User>(), (result as ResponseWrapper.Success).data)
    }

    @Test
    fun test_LoadUserss_Error() = runTest{
        Mockito.`when`(repository.getUsers()).thenReturn(ResponseWrapper.Error("Something Went Wrong"))
        val viewModel = UserListViewModel(repository)
        viewModel.loadUsers()
        testDispatcher.scheduler.advanceUntilIdle()
        val result = viewModel.uiState.value
        Assert.assertEquals(true, result is ResponseWrapper.Error)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}