package com.aaron.skinsecret.ui.feature.login

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aaron.skinsecret.R

enum class LoginMainPage(@StringRes val title: Int) {
    Login(title = R.string.login),              // 登入畫面
    Register(title = R.string.register),           // 註冊畫面
    ForgetPassword(title = R.string.forget_pw)    // 忘記密碼
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginMainScreen(
    navController: NavHostController = rememberNavController(),
    loginVM: LoginVM
) {
    // 取得儲存在back stack最上層的頁面
    val backStackEntry by navController.currentBackStackEntryAsState()
    // 取得當前頁面的名稱
    val currentScreen = LoginMainPage.valueOf(
        // destination是目前顯示的頁面，若為null則設定BookList這頁為目前顯示的頁面
        backStackEntry?.destination?.route ?: LoginMainPage.Login.name
    )
    // 設定內容向上捲動時，TopAppBar自動收起來；呼叫pinnedScrollBehavior()則不會收起來
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        // 設定則可追蹤捲動狀態，藉此調整畫面(例如內容向上捲動時，TopAppBar自動收起來)
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MainAppBar(
                navController = navController,
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = LoginMainPage.Login.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)

        ) {
            composable(route = LoginMainPage.Login.name) {
                /* 在composable階層架構中，上層建立的物件傳給下一層，基本上是安全的。
                所以可將navController或ViewModel物件傳給下一個Composable。
                但若不將navController與ViewModel物件傳給BookListScreen，就需要靠callback函式。 */
                LoginScreen(
                    navController = navController,
                    loginVM = loginVM,
                )
            }
            // 設定指定的路徑(route)會到指定的畫面(screen)
            composable(route = LoginMainPage.Register.name) {
                RegisterScreen(
                    navController = navController,
                    loginVM = loginVM,
                )
            }
            composable(route = LoginMainPage.ForgetPassword.name) {
                ForgetPasswordScreen(
                    navController = navController,
                    loginVM = loginVM,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar(
    navController: NavHostController,
    currentScreen: LoginMainPage,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior
) {
    TopAppBar(
        // 設定頁面標題
        title = { Text(stringResource(currentScreen.title)) },
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
