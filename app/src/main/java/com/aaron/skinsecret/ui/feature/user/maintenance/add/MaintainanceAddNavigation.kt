package com.aaron.skinsecret.ui.feature.user.maintenance.add

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.feature.TabVM

const val MAINTENANCE_ADD_NAVIGATION_ROUTE = "maintenance_add"

fun getMaintenanceAddNavigationRoute() = MAINTENANCE_ADD_NAVIGATION_ROUTE

fun NavGraphBuilder.maintenanceAddScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = MAINTENANCE_ADD_NAVIGATION_ROUTE,
    ) {
        MaintenanceAddRoute(
            navController = navController,
            tabVM = tabVM
        )
    }
}
