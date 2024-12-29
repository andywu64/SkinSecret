package com.aaron.skinsecret.ui.feature.user

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aaron.skinsecret.R
import com.aaron.skinsecret.ui.feature.MainScreenPage
import com.aaron.skinsecret.ui.feature.TabVM
import com.aaron.skinsecret.ui.feature.login.LoginVM
import com.aaron.skinsecret.ui.feature.user.feedback.getFeedbackNavigationRoute
import com.aaron.skinsecret.ui.feature.user.maintain.getMaintainNavigationRoute
import com.aaron.skinsecret.ui.feature.user.myfavorites.getMyFavoritesNavigationRoute
import com.aaron.skinsecret.ui.feature.user.userInfo.getUserInfoNavigationRoute
import com.aaron.skinsecret.ui.widget.ButtonRound

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingsScreen(
    navController: NavHostController,
    tabVM: TabVM,
    loginVM: LoginVM,
) {
    tabVM.updateTabState(true)
    Column (
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                //.background(color = Color.Green)
                .padding(top = 50.dp)
                .fillMaxWidth()
        ) {
            Image(
                imageVector = Icons.Default.Person,
                contentDescription = stringResource(R.string.nike_name),
                modifier = Modifier.size(100.dp),
            )
            Text(
                stringResource(R.string.nike_name),
                fontSize = 24.sp
            )
        }
        Column (
            //verticalArrangement = Arrangement.SpaceEvenly,
            //modifier = Modifier.background(color = Color.Blue)
            //.fillMaxSize()
            //.padding(20.dp)
        ){
            ButtonRound(
                onClick = {
                    navController.navigate(getUserInfoNavigationRoute())
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.user_info))
            }
            ButtonRound(
                onClick = {
                    navController.navigate(getMyFavoritesNavigationRoute())
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.my_favorites))
            }
            ButtonRound(
                onClick = {
                    navController.navigate(getMaintainNavigationRoute())
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.maintain_notify))
            }
            ButtonRound(
                onClick = {
                    navController.navigate(getFeedbackNavigationRoute())
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.feedback))
            }
        }
        Column (
            //verticalArrangement = Arrangement.Bottom,
            //modifier = Modifier.background(color = Color.Red)
        ) {
            ButtonRound(
                onClick = {
                    loginVM.setLogin(MainScreenPage.Login)
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.logout))
            }
        }
    }
}

@Preview
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(
        navController = rememberNavController(),
        tabVM = viewModel(),
        loginVM = LoginVM()
    )
}