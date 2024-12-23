package com.aaron.skinsecret.ui.feature.home

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aaron.skinsecret.R
import com.aaron.skinsecret.ui.feature.TabVM
import com.aaron.skinsecret.ui.feature.activity.ActivityMainScreen
import com.aaron.skinsecret.ui.feature.columnskincare.ColumnSkinCareMainScreen
import com.aaron.skinsecret.ui.feature.community.CommunityMainScreen
import com.aaron.skinsecret.ui.feature.login.LoginVM
import com.aaron.skinsecret.ui.feature.product.ProductMainScreen
import com.aaron.skinsecret.ui.feature.product.ProductScreen
import com.aaron.skinsecret.ui.feature.user.SettingsMainScreen

enum class HomeMainPage(@StringRes val title: Int) {
    Community(title = R.string.community_article),      // 社群文章晝面
    Product(title = R.string.product),                  // 產品畫面
    Activity(title = R.string.activity),                // 活動畫面
    Column(title = R.string.column_skin_care),          // 專欄保養畫面
    Setting(title = R.string.settings)                  // 用戶設定
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeMainScreen(
    navController: NavHostController = rememberNavController(),
    loginVM: LoginVM,
    tabVM: TabVM = viewModel()
) {
    val tabVisibility = tabVM.tabVisibility.collectAsState()
    // 儲存當前頁籤索引，一開始設定為0，代表要顯示BookMain頁面
    var tabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf(
        stringResource(id = R.string.community_article),
        stringResource(id = R.string.product),
        stringResource(id = R.string.activity),
        stringResource(id = R.string.column_skin_care),
        stringResource(id = R.string.settings)
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                // Take remaining vertical space
                .weight(1f)
        ) {
            when (tabIndex) {
                // 將tabVM傳至下頁，以便於控制TabRow的隱藏與顯示
                0 -> CommunityMainScreen(tabVM = tabVM)
                1 -> ProductMainScreen(tabVM = tabVM)
                2 -> ActivityMainScreen(tabVM = tabVM)
                3 -> ColumnSkinCareMainScreen(tabVM = tabVM)
                4 -> SettingsMainScreen(
                    tabVM = tabVM,
                    loginVM = loginVM
                )
            }
        }
        /* 判斷首頁是否顯示tabs:
            如果進入BookDetailScreen就要隱藏，將tabVisibility設為false。
            如果回到BookListScreen就要顯示，將tabVisibility設為true。
            因為需跨頁設定，要將tabVisibility存放在ViewModel */
        if (tabVisibility.value) {
            // 改用ScrollableTabRow，當頁籤數量過多時可以滑動
            TabRow(
                selectedTabIndex = tabIndex,
                containerColor = colorResource(id = R.color.green_main)
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        //text = { Text(title) },
                        // 判斷此頁籤是否為選取頁籤
                        selected = index == tabIndex,
                        // 點擊此頁籤後將選取索引改為此頁籤的索引
                        onClick = { tabIndex = index },
                        // 設定選取顏色
                        selectedContentColor = colorResource(id = R.color.peach_pale),
                        // 設定未選取顏色
                        unselectedContentColor = Color.Gray,
                        icon = {
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
                        }
                    )
                }
            }
        }
    }
}