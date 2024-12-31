package com.aaron.skinsecret.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aaron.skinsecret.R

// TabRow 樣式
@Composable
fun BottomTabRow(
    navController: NavController //需要導航到各頁面
) {
    var tabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf(
        stringResource(id = R.string.home),
        stringResource(id = R.string.product),
        stringResource(id = R.string.comm),
        stringResource(id = R.string.act),
        stringResource(id = R.string.account)
    )
    TabRow(
        selectedTabIndex = tabIndex,
        containerColor = colorResource(R.color.green_main)
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                text = { Text(title) },
                selected = index == tabIndex,
                onClick = {
                    tabIndex = index
//                    這裡要等各頁面名稱確定、訂好各頁的 VM 時才能運作
//                    when (index) {
//                        0 -> home
//                        1 -> product
//                        2 -> comm
//                        3 -> act
//                        4 -> account
//                    }
                },
                selectedContentColor = colorResource(R.color.white),
                unselectedContentColor = colorResource(R.color.green_pale),
                icon = {
                    when (index) {
                        0 -> Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home"
                        )

                        1 -> Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Product"
                        )

                        2 -> Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Community"
                        )

                        3 -> Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Activity"
                        )

                        4 -> Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "Account"
                        )
                    }
                }

            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    BottomTabRow(navController)
}