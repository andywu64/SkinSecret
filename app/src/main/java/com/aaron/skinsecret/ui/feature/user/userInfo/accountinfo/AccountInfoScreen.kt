package com.aaron.skinsecret.ui.feature.user.userInfo.accountinfo

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
import com.aaron.skinsecret.ui.feature.TabVM

@Composable
fun AccountInfoScreen(
    navController: NavHostController,
    tabVM: TabVM
) {
    tabVM.updateTabState(false)
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(stringResource(R.string.account_info))
    }
}

@Preview
@Composable
fun AccountInfoScreenPreview() {
    AccountInfoScreen(
        navController = rememberNavController(),
        tabVM = viewModel()
    )
}
