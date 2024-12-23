package com.aaron.skinsecret.ui.feature.user.maintenance

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.feature.TabVM

const val MAINTENANCE_NAVIGATION_ROUTE = "maintenance"

fun getMaintenanceNavigationRoute() = MAINTENANCE_NAVIGATION_ROUTE

fun NavGraphBuilder.maintenanceScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = MAINTENANCE_NAVIGATION_ROUTE,
    ) {
        MaintenanceScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
