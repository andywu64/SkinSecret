package com.aaron.skinsecret.ui.feature.user.feedback.add

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aaron.skinsecret.ui.feature.TabVM
import com.aaron.skinsecret.ui.widget.ButtonRound

@Composable
fun FeedbackAddScreen(
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
                navController.navigate(getFeedbackAddNavigationRoute())
            }
        ) {
            Image(
                imageVector = Icons.Default.Add,
                contentDescription = "Add"
            )
        }
    }
}

@Preview
@Composable
fun FeedbackAddScreenPreview() {
    FeedbackAddScreen(
        navController = rememberNavController(),
        tabVM = viewModel()
    )
}
