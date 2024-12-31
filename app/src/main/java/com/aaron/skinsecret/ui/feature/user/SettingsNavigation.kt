package com.aaron.skinsecret.ui.feature.user

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.TabVM
import com.aaron.skinsecret.ui.feature.login.LoginVM

const val SETTINGS_NAVIGATION_ROUTE = "settings"

fun getSettingsNavigationRoute() = SETTINGS_NAVIGATION_ROUTE

fun NavGraphBuilder.settingsScreenRoute(
    navController: NavHostController,
    tabVM: TabVM,
    loginVM: LoginVM,
) {
    composable(
        route = SETTINGS_NAVIGATION_ROUTE,
    ) {
        SettingsScreen(
            navController = navController,
            tabVM = tabVM,
            loginVM = loginVM
        )
    }
}
