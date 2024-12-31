package com.aaron.skinsecret.ui.feature.columnskincare

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.aaron.skinsecret.R
import com.aaron.skinsecret.ui.TabVM
import com.aaron.skinsecret.ui.feature.columnskincare.detail.detailScreenRoute
import com.aaron.skinsecret.ui.feature.columnskincare.latestnews.latestNewsScreenRoute
import com.aaron.skinsecret.ui.feature.columnskincare.popular.popularScreenRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnSkinCareMainScreen(
    navController: NavHostController = rememberNavController(),
    appState: ColumnSkinCareAppState = remember { ColumnSkinCareAppState(navController) },
    tabVM: TabVM
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        topBar = {
            ColumnSkinCareAppTopBar(
                navController = navController,
                currentScreen = appState.currentTipTopLevelDestination,
                canNavigateBack = navController.previousBackStackEntry != null,
                scrollBehavior = scrollBehavior
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            // todo 1-3 將 NavHost 放在 Scaffold Content 裡
            ColumnSkinCareNavHost(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                navController = navController,
                tabVM = tabVM
            )
        }
    }
}

/**
 * 建立topBar與回上頁按鈕
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnSkinCareAppTopBar(
    navController: NavHostController,
    currentScreen: TipTopLevelDestination?,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior
) {
    TopAppBar(
        // 設定頁面標題
        title = {
            currentScreen?.let {
                Text(stringResource(it.title))
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            // 如果可回上頁，就顯示Back按鈕
            if (canNavigateBack) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@Composable
fun ColumnSkinCareNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    tabVM: TabVM
) {
    // todo 2-1 這裡是將所有的畫面路徑都列出來
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = getColumnSkinCareNavigationRoute()
    ) {
        // todo 2-2 置入所有的畫面路徑
        columnSkinCareScreenRoute(
            navController = navController,
            tabVM = tabVM
        )
        popularScreenRoute(
            navController = navController,
            tabVM = tabVM
        )
        latestNewsScreenRoute(
            navController = navController,
            tabVM = tabVM
        )
        detailScreenRoute(
            navController = navController,
            tabVM = tabVM
        )
    }

}

@Preview
@Composable
fun ColumnSkinCareMainScreenPreview() {
    ColumnSkinCareMainScreen(tabVM = viewModel())
}
