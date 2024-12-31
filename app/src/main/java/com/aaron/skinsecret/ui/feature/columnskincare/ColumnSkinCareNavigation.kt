package com.aaron.skinsecret.ui.feature.columnskincare

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.TabVM

const val COLUMN_SKIN_CARE_NAVIGATION_ROUTE = "column_skin_care"

fun getColumnSkinCareNavigationRoute() = COLUMN_SKIN_CARE_NAVIGATION_ROUTE

fun NavGraphBuilder.columnSkinCareScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = COLUMN_SKIN_CARE_NAVIGATION_ROUTE,
    ) {
        ColumnSkinCareScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
