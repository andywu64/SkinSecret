package com.aaron.skinsecret.ui.feature.columnskincare.latestnews

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.TabVM

const val LATEST_NEWS_NAVIGATION_ROUTE = "latest_news"
fun getLatestNewsNavigationRoute() = LATEST_NEWS_NAVIGATION_ROUTE

fun NavGraphBuilder.latestNewsScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = LATEST_NEWS_NAVIGATION_ROUTE,
    ) {
        LatestNewsScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
