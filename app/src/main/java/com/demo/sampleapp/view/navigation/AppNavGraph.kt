package com.demo.sampleapp.view.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.demo.feature_user.view.navigation.UserRoutes
import com.demo.feature_user.view.navigation.userNavGraph
import com.demo.feature_user.viewmodel.UserListViewModel

@Composable
fun AppNavGraph(navController: NavHostController) {
    val sharedViewModel: UserListViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = UserRoutes.LIST
    ) {
        userNavGraph(navController, sharedViewModel)
    }
}