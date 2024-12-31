package com.aaron.skinsecret.ui.feature.community

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.TabVM

const val COMMUNITY_NAVIGATION_ROUTE = "community"

fun getCommunityNavigationRoute() = COMMUNITY_NAVIGATION_ROUTE

fun NavGraphBuilder.communityScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = COMMUNITY_NAVIGATION_ROUTE,
    ) {
        CommunityScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
