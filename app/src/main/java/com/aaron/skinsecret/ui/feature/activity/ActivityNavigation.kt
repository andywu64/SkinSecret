package com.aaron.skinsecret.ui.feature.activity

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.feature.TabVM

const val ACTIVITY_NAVIGATION_ROUTE = "activity"

fun getActivityNavigationRoute() = ACTIVITY_NAVIGATION_ROUTE

fun NavGraphBuilder.activityScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = ACTIVITY_NAVIGATION_ROUTE,
    ) {
        ActivityScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
