package com.demo.feature_user

import com.demo.domain.model.UserData
import com.demo.domain.usecase.GetUsersUseCase
import com.demo.domain.wrapper.ResultState
import com.demo.feature_user.view.state.UiState
import com.demo.feature_user.viewmodel.UserListViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

@OptIn(ExperimentalCoroutinesApi::class)
class UserListViewModelTest {

    private lateinit var getUsersUseCase: GetUsersUseCase
    private lateinit var viewModel: UserListViewModel
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        getUsersUseCase = mockk()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun loadUsersSuccessTest() = runTest {
        val fakeUsers = listOf(
            UserData(
                id = 1,
                name = "Alice",
                email = "alice@test.com",
                image = "https://example.com/alice.jpg",
                address = "123 Main St",
                zip = "12345",
                state = "CA",
                country = "USA"
            ),
            UserData(
                id = 2,
                name = "Bob",
                email = "bob@test.com",
                image = "https://example.com/bob.jpg",
                address = "456 Oak Ave",
                zip = "67890",
                state = "NY",
                country = "USA"
            )
        )

        coEvery { getUsersUseCase.invoke() } returns ResultState.Success(fakeUsers)
        viewModel = UserListViewModel(getUsersUseCase)
        advanceUntilIdle()

        val state = viewModel.uiState.value
        assertIs<UiState.Success<*>>(state)
        val success = state as UiState.Success<List<UserData>>
        assertEquals(fakeUsers, success.data)
        assertEquals(2, success.data.size)
        assertEquals("Alice", success.data[0].name)
        assertEquals("Bob", success.data[1].name)
    }

    @Test
    fun loadUsersErrorTest() = runTest {
        val errorMessage = "Failed to fetch users"
        coEvery { getUsersUseCase.invoke() } returns ResultState.Error(errorMessage)
        viewModel = UserListViewModel(getUsersUseCase)
        advanceUntilIdle()
        val state = viewModel.uiState.value
        assertIs<UiState.Error>(state)
        assertEquals(errorMessage, state.message)
    }

    @Test
    fun loadUsersEmptyTest() = runTest {
        coEvery { getUsersUseCase.invoke() } returns ResultState.Success(emptyList())
        viewModel = UserListViewModel(getUsersUseCase)
        advanceUntilIdle()
        val state = viewModel.uiState.value
        assertIs<UiState.Success<*>>(state)
        val success = state as UiState.Success<List<UserData>>
        assertEquals(emptyList(), success.data)
        assertEquals(0, success.data.size)
    }

    @Test
    fun selectUserTest() = runTest {
        val testUser = UserData(
            id = 3,
            name = "Charlie",
            email = "charlie@test.com",
            image = "https://example.com/charlie.jpg",
            address = "789 Pine Rd",
            zip = "11111",
            state = "TX",
            country = "USA"
        )
        coEvery { getUsersUseCase.invoke() } returns ResultState.Success(listOf(testUser))
        viewModel = UserListViewModel(getUsersUseCase)
        advanceUntilIdle()
        viewModel.selectUser(testUser)
        assertEquals(testUser, viewModel.selectedUser.value)
        assertEquals("Charlie", viewModel.selectedUser.value?.name)
        assertEquals("charlie@test.com", viewModel.selectedUser.value?.email)
    }

    @Test
    fun loadingTest() = runTest {
        coEvery { getUsersUseCase.invoke() } returns ResultState.Success(emptyList())
        viewModel = UserListViewModel(getUsersUseCase)
        assertIs<UiState.Loading>(viewModel.uiState.value)
    }

    @Test
    fun selectedUserNullTest() = runTest {
        coEvery { getUsersUseCase.invoke() } returns ResultState.Success(emptyList())
        viewModel = UserListViewModel(getUsersUseCase)
        assertEquals(null, viewModel.selectedUser.value)
    }
}