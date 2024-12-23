package com.aaron.skinsecret.ui.feature.community.popular

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.feature.TabVM


const val COMMUNITY_POPULAR_NAVIGATION_ROUTE = "community_popular"

fun getCommunityPopularNavigationRoute() = COMMUNITY_POPULAR_NAVIGATION_ROUTE

fun NavGraphBuilder.communityPopularScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = COMMUNITY_POPULAR_NAVIGATION_ROUTE,
    ) {
        CommunityPopularScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
