package com.aaron.skinsecret.ui.feature.activity.activitydetail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.TabVM


const val ACTIVITY_DETAIL_NAVIGATION_ROUTE = "activity_detail"

fun getActivityDetailNavigationRoute() = ACTIVITY_DETAIL_NAVIGATION_ROUTE

fun NavGraphBuilder.activityDetailScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = ACTIVITY_DETAIL_NAVIGATION_ROUTE,
    ) {
        ActivityDetailScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
