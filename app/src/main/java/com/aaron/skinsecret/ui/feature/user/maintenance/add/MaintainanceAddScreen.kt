package com.aaron.skinsecret.ui.feature.user.maintenance.add

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.aaron.skinsecret.ui.feature.TabVM

@Composable
fun MaintenanceAddRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    tabVM.updateTabState(false)
    MaintenanceAddScreen()
}

@Composable
fun MaintenanceAddScreen() {

}

@Preview
@Composable
fun MaintenanceAddScreenPreview() {
    MaintenanceAddScreen()
}
