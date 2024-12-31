package com.aaron.skinsecret.ui.feature.user.userInfo.introduce

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.TabVM

const val INTRODUCE_NAVIGATION_ROUTE = "introduce"

fun getIntroduceNavigationRoute() = INTRODUCE_NAVIGATION_ROUTE

fun NavGraphBuilder.introduceScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = INTRODUCE_NAVIGATION_ROUTE,
    ) {
        IntroduceScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
