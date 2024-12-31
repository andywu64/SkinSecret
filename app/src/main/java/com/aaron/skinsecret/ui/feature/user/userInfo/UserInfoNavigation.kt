package com.aaron.skinsecret.ui.feature.user.userInfo

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.TabVM

const val USER_INFO_NAVIGATION_ROUTE = "user_info"

fun getUserInfoNavigationRoute() = USER_INFO_NAVIGATION_ROUTE

fun NavGraphBuilder.userInfoScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = USER_INFO_NAVIGATION_ROUTE,
    ) {
        UserInfoScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
