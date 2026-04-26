//package com.demo.feature_user
//
//import app.cash.turbine.test
//import com.demo.domain.model.UserData
//import com.demo.domain.repository.UserRepository
//import com.demo.domain.usecase.GetUsersUseCase
//import com.demo.domain.wrapper.ResultState
//import com.demo.feature_user.view.state.UiState
//import com.demo.feature_user.viewmodel.UserListViewModel
//import io.mockk.coEvery
//import io.mockk.mockk
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.test.StandardTestDispatcher
//import kotlinx.coroutines.test.runTest
//import kotlinx.coroutines.test.setMain
//import org.junit.After
//import org.junit.Assert
//import org.junit.Before
//import org.junit.Test
//import org.mockito.Mock
//import org.mockito.Mockito
//import org.mockito.MockitoAnnotations
//import kotlin.test.assertEquals
//import kotlin.test.assertNotEquals
//
//@OptIn(ExperimentalCoroutinesApi::class)
//class UserListViewModelTest {
//
//    private lateinit var getUsersUseCase: GetUsersUseCase
//    private lateinit var viewModel: UserListViewModel
//
//    private val testDispatcher = StandardTestDispatcher()
//
//    @Before
//    fun setUp() {
//        Dispatchers.setMain(testDispatcher)
//        getUsersUseCase = mockk()
//    }
//
//    @After
//    fun tearDown() {
//        Dispatchers.resetMain()
//    }
//
//    @Test
//    fun `loadUsers emits Success when usecase returns data`() = runTest {
//
//        val fakeUsers = listOf(
//            User(
//                id = 1,
//                name = "Alice",
//                email = "alice@test.com",
//                image = "https://example.com/alice.jpg"
//            )
//        )
//
//        // ✅ IMPORTANT: mock suspend function
//        coEvery { getUsersUseCase.invoke() } returns fakeUsers
//
//        viewModel = UserListViewModel(getUsersUseCase)
//
//        advanceUntilIdle() // run coroutines
//
//        viewModel.uiState.test {
//            val first = awaitItem()
//            assert(first is UiState.Loading)
//
//            val second = awaitItem()
//            assert(second is UiState.Success)
//
//            val success = second as UiState.Success
//            assertEquals(fakeUsers, success.data)
//
//            cancelAndIgnoreRemainingEvents()
//        }
//    }
//}
//
//   /* fun test_LoadUsers() = runTest{
//        Mockito.`when`(getUserUseCase()).thenReturn(ResultState.Success(emptyList()))
//        val viewModel = UserListViewModel(getUserUseCase)
//        viewModel.loadUsers()
//        testDispatcher.scheduler.advanceUntilIdle()
//        val result = viewModel.uiState.value
//        Assert.assertTrue(result is ResultState.Success)
//        assertEquals(emptyList<UserData>(), (result as ResultState.Success).data)
//    }*/
//
//    /*@Test
//    fun test_LoadUsers() = runTest{
//        Mockito.`when`(getUserUseCase.getUsers()).thenReturn(ResultState.Success(emptyList()))
//        val viewModel = UserListViewModel(getUserUseCase)
//        viewModel.loadUsers()
//        testDispatcher.scheduler.advanceUntilIdle()
//        val result = viewModel.uiState.value
//        Assert.assertTrue(result is ResultState.Success)
//        assertEquals(emptyList<UserData>(), (result as ResultState.Success).data)
//    }
//
//    @Test
//    fun test_LoadUserss_Error() = runTest{
//        Mockito.`when`(repository.getUsers()).thenReturn(ResponseWrapper.Error("Something Went Wrong"))
//        val viewModel = UserListViewModel(repository)
//        viewModel.loadUsers()
//        testDispatcher.scheduler.advanceUntilIdle()
//        val result = viewModel.uiState.value
//        Assert.assertEquals(true, result is ResponseWrapper.Error)
//    }
//
//    @After
//    fun tearDown() {
//        Dispatchers.resetMain()
//    }
//*/}