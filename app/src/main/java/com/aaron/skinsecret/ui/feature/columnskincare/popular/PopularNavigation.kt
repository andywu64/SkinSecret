package com.aaron.skinsecret.ui.feature.columnskincare.popular

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.feature.TabVM

const val POPULAR_NAVIGATION_ROUTE = "popular"

fun getPopularNavigationRoute() = POPULAR_NAVIGATION_ROUTE

fun NavGraphBuilder.popularScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = POPULAR_NAVIGATION_ROUTE,
    ) {
        PopularScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
