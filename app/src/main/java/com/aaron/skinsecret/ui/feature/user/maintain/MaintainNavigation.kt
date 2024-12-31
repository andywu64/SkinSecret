package com.aaron.skinsecret.ui.feature.user.maintain

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.TabVM
import com.aaron.skinsecret.viewmodel.user.maintain.MaintainViewModel

const val MAINTAIN_NAVIGATION_ROUTE = "maintain"

fun getMaintainNavigationRoute() = MAINTAIN_NAVIGATION_ROUTE

fun NavGraphBuilder.maintainScreenRoute(
    navController: NavHostController,
    maintainVM: MaintainViewModel,
    tabVM: TabVM
) {
    composable(
        route = MAINTAIN_NAVIGATION_ROUTE,
    ) {
        MaintainScreen(
            navController = navController,
            maintainVM = maintainVM,
            tabVM = tabVM
        )
    }
}
