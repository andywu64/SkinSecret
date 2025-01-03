package com.aaron.skinsecret.ui.feature.user.maintain

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aaron.skinsecret.ui.TabVM
import com.aaron.skinsecret.ui.feature.user.maintain.add.getMaintainAddNavigationRoute
import com.aaron.skinsecret.ui.widget.ItemSkinCareNotify
import com.aaron.skinsecret.dataclass.user.maintain.Maintain
import com.aaron.skinsecret.viewmodel.user.maintain.MaintainViewModel
import kotlinx.coroutines.launch

@Composable
fun MaintainScreen(
    navController: NavHostController,
    maintainVM: MaintainViewModel = viewModel(),
    tabVM: TabVM
) {
    tabVM.updateTabState(false)
    val maintains = maintainVM.maintainsState.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        maintainVM.getMaintains()
    }

    Box {
        MaintainLists(
            maintains.value,
            onItemClick = {
                maintainVM.updateMaintainState(it)
                navController.navigate(getMaintainAddNavigationRoute())
            },
            onDeleteClick = {
                coroutineScope.launch {
                    if (maintainVM.deleteItem(it.id)) {
                        maintainVM.getMaintains()
                    }
                }
            }
        )
        FloatingActionButton(
            onClick = {
                maintainVM.addNewMaintain()
                navController.navigate(getMaintainAddNavigationRoute())
            },
            modifier = Modifier
                .padding(15.dp)
                .align(Alignment.BottomEnd)
        ) {
            Image(
                imageVector = Icons.Default.Add,
                contentDescription = "Add"
            )
        }
    }
}

@Composable
fun MaintainLists(
    maintains: List<Maintain>,
    onItemClick: (Maintain) -> Unit,
    onDeleteClick: (Maintain) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
            .fillMaxSize()
    ) {
        items(maintains) { maintain ->
            ItemSkinCareNotify(
                maintain = maintain,
                onItemClick = { onItemClick(maintain) },
                onDeleteClick = { onDeleteClick(maintain) },
            )
            HorizontalDivider(
                thickness = 2.dp,
                color = Gray
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = Color.LTGRAY.toLong()
)
@Composable
fun MaintainScreenPreview() {
    MaintainScreen(
        navController = rememberNavController(),
        tabVM = viewModel()
    )
}
