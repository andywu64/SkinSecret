package com.aaron.skinsecret.ui.feature.product

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.feature.TabVM

const val PRODUCT_NAVIGATION_ROUTE = "product"

fun getProductNavigationRoute() = PRODUCT_NAVIGATION_ROUTE

fun NavGraphBuilder.productScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = PRODUCT_NAVIGATION_ROUTE,
    ) {
        ProductScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}


