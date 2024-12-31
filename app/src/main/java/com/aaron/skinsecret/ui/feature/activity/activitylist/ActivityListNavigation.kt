package com.aaron.skinsecret.ui.feature.activity.activitylist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.TabVM


const val ACTIVITY_LIST_NAVIGATION_ROUTE = "activity_list"

fun getActivityListNavigationRoute() = ACTIVITY_LIST_NAVIGATION_ROUTE

fun NavGraphBuilder.activityListScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = ACTIVITY_LIST_NAVIGATION_ROUTE,
    ) {
        ActivityListScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
