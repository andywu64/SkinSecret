package com.aaron.skinsecret.ui.feature.user.userInfo.skintestinfo

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.TabVM

const val SKIN_TEST_INFO_NAVIGATION_ROUTE = "skin_test_info"

fun getSkinTestInfoNavigationRoute() = SKIN_TEST_INFO_NAVIGATION_ROUTE

fun NavGraphBuilder.skinTestInfoScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = SKIN_TEST_INFO_NAVIGATION_ROUTE,
    ) {
        SkinTestInfoScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
