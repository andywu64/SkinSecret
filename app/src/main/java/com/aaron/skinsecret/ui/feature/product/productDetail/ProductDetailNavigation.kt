package com.aaron.skinsecret.ui.feature.product.productDetail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.feature.TabVM

const val PRODUCT_DETAIL_NAVIGATION_ROUTE = "product_detail"

fun getProductDetailNavigationRoute() = PRODUCT_DETAIL_NAVIGATION_ROUTE

fun NavGraphBuilder.productDetailScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = PRODUCT_DETAIL_NAVIGATION_ROUTE,
    ) {
        ProductDetailScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}


