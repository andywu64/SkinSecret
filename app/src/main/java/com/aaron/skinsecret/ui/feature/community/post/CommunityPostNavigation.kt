package com.aaron.skinsecret.ui.feature.community.post

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.feature.TabVM

const val COMMUNITY_POST_NAVIGATION_ROUTE = "community_post"

fun getCommunityPostNavigationRoute() = COMMUNITY_POST_NAVIGATION_ROUTE

fun NavGraphBuilder.communityPostScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = COMMUNITY_POST_NAVIGATION_ROUTE,
    ) {
        CommunityPostScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
