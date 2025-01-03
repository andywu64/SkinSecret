package com.aaron.skinsecret.ui.feature.user.userInfo.skintestinfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aaron.skinsecret.R
import com.aaron.skinsecret.ui.TabVM

@Composable
fun SkinTestInfoScreen(
    navController: NavHostController,
    tabVM: TabVM
) {
    tabVM.updateTabState(false)
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(stringResource(R.string.skinTestInfo))
    }
}

@Preview
@Composable
fun SkinTestInfoScreenPreview() {
    SkinTestInfoScreen(
        navController = rememberNavController(),
        tabVM = viewModel()
    )
}
