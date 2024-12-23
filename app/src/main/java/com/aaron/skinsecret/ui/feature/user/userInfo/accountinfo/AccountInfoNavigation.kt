package com.aaron.skinsecret.ui.feature.user.userInfo.accountinfo

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.feature.TabVM

const val ACCOUNT_INFO_NAVIGATION_ROUTE = "account_info"

fun getAccountInfoNavigationRoute() = ACCOUNT_INFO_NAVIGATION_ROUTE

fun NavGraphBuilder.accountInfoScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = ACCOUNT_INFO_NAVIGATION_ROUTE,
    ) {
        AccountInfoScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
