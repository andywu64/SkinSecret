package com.aaron.skinsecret.ui.feature.community.detail

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
import com.aaron.skinsecret.ui.feature.community.post.getCommunityPostNavigationRoute
import com.aaron.skinsecret.ui.widget.ButtonRound

@Composable
fun CommunityDetailScreen(
    navController: NavHostController,
    tabVM: TabVM
) {
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        ButtonRound(
            onClick = {
                navController.navigate(getCommunityPostNavigationRoute())
            }
        ) {
            Text(stringResource(R.string.post))
        }
    }
}

@Preview
@Composable
fun CommunityDetailScreenPreview() {
    CommunityDetailScreen(
        navController = rememberNavController(),
        tabVM = viewModel()
    )
}
