package com.demo.feature_user.view.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.demo.feature_user.view.compose.UserDetailScreen
import com.demo.feature_user.view.compose.UserListScreen
import com.demo.feature_user.viewmodel.UserListViewModel

object UserRoutes {
    const val LIST = "user_list"
    const val DETAIL = "user_detail"
}

fun NavGraphBuilder.userNavGraph(
    navController: NavController,
    sharedViewModel: UserListViewModel
) {

    composable(UserRoutes.LIST) {
        UserListScreen(
            onUserClick = {
                sharedViewModel.selectUser(it)
                navController.navigate(UserRoutes.DETAIL)
            }
        )
    }

    composable(UserRoutes.DETAIL) {
        UserDetailScreen(sharedViewModel)
    }
}