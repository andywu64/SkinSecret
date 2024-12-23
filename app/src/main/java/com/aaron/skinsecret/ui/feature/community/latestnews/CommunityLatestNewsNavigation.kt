package com.aaron.skinsecret.ui.feature.community.latestnews

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.feature.TabVM


const val COMMUNITY_LATEST_NEWS_NAVIGATION_ROUTE = "community_latest_news"

fun getCommunityLatestNewsNavigationRoute() = COMMUNITY_LATEST_NEWS_NAVIGATION_ROUTE

fun NavGraphBuilder.communityLatestNewsScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = COMMUNITY_LATEST_NEWS_NAVIGATION_ROUTE,
    ) {
        CommunityLatestNewsScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
