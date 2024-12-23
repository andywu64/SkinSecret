package com.aaron.skinsecret.ui.feature.login

import androidx.lifecycle.ViewModel
import com.aaron.skinsecret.ui.feature.MainScreenPage
import com.aaron.skinsecret.viewmodel.user.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.updateAndGet

class LoginVM: ViewModel() {
    private val _loginState = MutableStateFlow(MainScreenPage.Login)
    val loginState: StateFlow<MainScreenPage> = _loginState.asStateFlow()
    fun setLogin(isLogin: MainScreenPage) {
        _loginState.updateAndGet {
            isLogin
        }
    }

    private val _userState = MutableStateFlow(User())
    val userState: StateFlow<User> = _userState.asStateFlow()
    fun setUser(user: User) {
        _userState.updateAndGet {
            user
        }
    }

}