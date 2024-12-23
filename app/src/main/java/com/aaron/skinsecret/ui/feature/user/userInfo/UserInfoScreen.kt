package com.aaron.skinsecret.ui.feature.user.userInfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.aaron.skinsecret.ui.feature.user.userInfo.accountinfo.getAccountInfoNavigationRoute
import com.aaron.skinsecret.ui.feature.user.userInfo.introduce.getIntroduceNavigationRoute
import com.aaron.skinsecret.ui.feature.user.userInfo.skintestinfo.getSkinTestInfoNavigationRoute
import com.aaron.skinsecret.ui.widget.ButtonRound

@Composable
fun UserInfoScreen(
    navController: NavHostController,
    tabVM: TabVM
) {
    tabVM.updateTabState(false)
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        ButtonRound(
            onClick = {
                navController.navigate(getIntroduceNavigationRoute())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.introduce))
        }
        ButtonRound(
            onClick = {
                navController.navigate(getAccountInfoNavigationRoute())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.account_info))
        }
        ButtonRound(
            onClick = {
                navController.navigate(getSkinTestInfoNavigationRoute())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.skinTestInfo))
        }
    }
}

@Preview
@Composable
fun UserInfoScreenPreview() {
    UserInfoScreen(
        navController = rememberNavController(),
        tabVM = viewModel()
    )
}
