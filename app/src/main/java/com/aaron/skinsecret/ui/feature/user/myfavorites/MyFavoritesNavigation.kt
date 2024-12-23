package com.aaron.skinsecret.ui.feature.user.myfavorites

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.feature.TabVM

const val MY_FAVORITES_NAVIGATION_ROUTE = "my_favorites"

fun getMyFavoritesNavigationRoute() = MY_FAVORITES_NAVIGATION_ROUTE

fun NavGraphBuilder.myFavoritesScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = MY_FAVORITES_NAVIGATION_ROUTE,
    ) {
        MyFavoritesScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
