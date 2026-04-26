package com.demo.sampleapp.view.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.demo.sampleapp.view.compose.UserDetailScreen
import com.demo.sampleapp.view.compose.UserListScreen
import com.demo.sampleapp.viewmodel.UserListViewModel

@Composable
fun AppNavGraph(navController: NavHostController) {
    val sharedViewModel: UserListViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = "userList"
    ) {
        composable("userList") {
            UserListScreen(
                onUserClick = { user ->
                    sharedViewModel.selectUser(user)
                    navController.navigate("userDetail")
                }
            )
        }
        composable(
            route = "userDetail",
        ) { backStackEntry ->
            UserDetailScreen(sharedViewModel)
        }
    }
}