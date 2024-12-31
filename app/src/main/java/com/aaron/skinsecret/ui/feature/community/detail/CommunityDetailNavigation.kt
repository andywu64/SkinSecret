package com.aaron.skinsecret.ui.feature.community.detail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.TabVM

const val COMMUNITY_DETAIL_NAVIGATION_ROUTE = "community_detail"

fun getCommunityDetailNavigationRoute() = COMMUNITY_DETAIL_NAVIGATION_ROUTE

fun NavGraphBuilder.communityDetailScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = COMMUNITY_DETAIL_NAVIGATION_ROUTE,
    ) {
        CommunityDetailScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
