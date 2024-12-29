package com.aaron.skinsecret.ui.feature.activity.activitylist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aaron.skinsecret.ui.feature.TabVM
import com.aaron.skinsecret.ui.feature.activity.activitydetail.getActivityDetailNavigationRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityListScreen(
    navController: NavHostController,
    tabVM: TabVM
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    LazyColumn(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        items(25) { number ->
            Text(
                text = "Item ${number + 1}", modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        navController.navigate(getActivityDetailNavigationRoute())
                    }
            )
        }
    }
}

@Preview
@Composable
fun ActivityListScreenPreview() {
    ActivityListScreen(
        navController = rememberNavController(),
        tabVM = viewModel()
    )
}
