package com.aaron.skinsecret.ui.feature.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aaron.skinsecret.R

@Composable
fun ForgetPasswordScreen(
    navController: NavHostController = rememberNavController(),
    loginVM: LoginVM
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(stringResource(R.string.forget_pw))
    }
}