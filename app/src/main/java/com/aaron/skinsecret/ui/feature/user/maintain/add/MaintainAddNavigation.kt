package com.aaron.skinsecret.ui.feature.user.maintain.add

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.feature.TabVM
import com.aaron.skinsecret.viewmodel.user.maintain.MaintainViewModel

const val MAINTAIN_ADD_NAVIGATION_ROUTE = "maintain_add"

fun getMaintainAddNavigationRoute() = MAINTAIN_ADD_NAVIGATION_ROUTE

fun NavGraphBuilder.maintainAddScreenRoute(
    navController: NavHostController,
    maintainVM: MaintainViewModel,
    tabVM: TabVM
) {
    composable(
        route = MAINTAIN_ADD_NAVIGATION_ROUTE,
    ) {
        MaintainAddScreen(
            navController = navController,
            maintainVM = maintainVM,
            tabVM = tabVM
        )
    }
}
