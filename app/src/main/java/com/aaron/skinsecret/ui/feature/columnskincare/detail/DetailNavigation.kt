package com.aaron.skinsecret.ui.feature.columnskincare.detail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.TabVM

const val DETAIL_NAVIGATION_ROUTE = "detail"

fun getDetailNavigationRoute() = DETAIL_NAVIGATION_ROUTE

fun NavGraphBuilder.detailScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = DETAIL_NAVIGATION_ROUTE,
    ) {
        DetailScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
