package com.aaron.skinsecret.ui.feature

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aaron.skinsecret.ui.feature.home.HomeMainScreen
import com.aaron.skinsecret.ui.feature.login.LoginMainScreen
import com.aaron.skinsecret.ui.feature.login.LoginVM

enum class MainScreenPage {
    Login,          // 登入
    Main,           // 首頁
}

@Composable
fun MainScreen(
    loginVM: LoginVM = viewModel()
) {
    val screenPage by loginVM.loginState.collectAsState()
    if (screenPage == MainScreenPage.Login) {
        LoginMainScreen(
            loginVM = loginVM
        )
    } else {
        HomeMainScreen(
            loginVM = loginVM
        )
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}