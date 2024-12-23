package com.aaron.skinsecret.ui.feature.activity.activityclass

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.feature.TabVM

const val ACTIVITY_CLASS_NAVIGATION_ROUTE = "activity_class"

fun getActivityClassNavigationRoute() = ACTIVITY_CLASS_NAVIGATION_ROUTE

fun NavGraphBuilder.activityClassScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = ACTIVITY_CLASS_NAVIGATION_ROUTE,
    ) {
        ActivityClassScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
