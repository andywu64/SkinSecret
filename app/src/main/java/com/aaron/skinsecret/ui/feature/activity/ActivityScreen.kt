package com.aaron.skinsecret.ui.feature.activity

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aaron.skinsecret.R
import com.aaron.skinsecret.ui.TabVM
import com.aaron.skinsecret.ui.feature.activity.activityclass.ActivityClassScreen
import com.aaron.skinsecret.ui.feature.activity.activitylist.ActivityListScreen

@Composable
fun ActivityScreen(
    navController: NavHostController = rememberNavController(),
    tabVM: TabVM
){
    tabVM.updateTabState(true)
    var tabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf(
        stringResource(id = R.string.activity),
        stringResource(id = R.string.activity_class),
    )

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(
            selectedTabIndex = tabIndex,
            containerColor = colorResource(id = R.color.green_main)
        ) {
            /* 判斷首頁是否顯示tabs:
                如果進入BookDetailScreen就要隱藏，將tabVisibility設為false。
                如果回到BookListScreen就要顯示，將tabVisibility設為true。
                因為需跨頁設定，要將tabVisibility存放在ViewModel */
            /*if (tabVisibility.value) {
            }*/
            // 改用ScrollableTabRow，當頁籤數量過多時可以滑動
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    // 判斷此頁籤是否為選取頁籤
                    selected = index == tabIndex,
                    // 點擊此頁籤後將選取索引改為此頁籤的索引
                    onClick = { tabIndex = index },
                    // 設定選取顏色
                    selectedContentColor = colorResource(id = R.color.peach_pale),
                    // 設定未選取顏色
                    unselectedContentColor = Color.Gray,
                    /*icon = {
                        when (index) {
                            0 -> Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = tabs[0]
                            )

                            1 -> Icon(
                                imageVector = Icons.Default.Face,
                                contentDescription = tabs[1]
                            )

                            2 -> Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = tabs[2]
                            )

                            3 -> Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = tabs[3]
                            )

                            4 -> Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = tabs[4]
                            )
                        }
                    }*/
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                // Take remaining vertical space
                .weight(1f)
        ) {
            when (tabIndex) {
                // 將tabVM傳至下頁，以便於控制TabRow的隱藏與顯示
                0 -> ActivityListScreen(
                    navController = navController,
                    tabVM = tabVM
                )
                1 -> ActivityClassScreen(
                    navController = navController,
                    tabVM = tabVM
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActivityScreenPreview() {
    ActivityScreen(tabVM = viewModel())
}
