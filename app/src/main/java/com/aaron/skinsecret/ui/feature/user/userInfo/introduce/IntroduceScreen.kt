package com.aaron.skinsecret.ui.feature.user.userInfo.introduce

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

@Composable
fun IntroduceScreen(
    navController: NavHostController,
    tabVM: TabVM
) {
    tabVM.updateTabState(false)
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(stringResource(R.string.introduce))
    }
}

@Preview
@Composable
fun IntroduceScreenPreview() {
    IntroduceScreen(
        navController = rememberNavController(),
        tabVM = viewModel()
    )
}
