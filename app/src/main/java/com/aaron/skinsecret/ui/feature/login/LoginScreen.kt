package com.aaron.skinsecret.ui.feature.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aaron.skinsecret.R
import com.aaron.skinsecret.ui.feature.MainScreenPage
import com.aaron.skinsecret.ui.widget.ButtonRound
import com.aaron.skinsecret.ui.widget.TextFieldInput

@Composable
fun LoginScreen (
    navController: NavHostController,
    loginVM: LoginVM
) {
    val user by loginVM.userState.collectAsState()
    var account by remember { mutableStateOf(user.account) }
    var password by remember { mutableStateOf(user.password) }

    Column (
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
            //modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_image_60),
                    contentDescription = "image",
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    stringResource(R.string.app_name),
                    fontSize = 36.sp,
                )
            }
            Column(
                modifier = Modifier.padding(25.dp)
            ) {
                TextFieldInput(
                    stringResource(R.string.account),
                    input = account,
                    label = {
                        Text(stringResource(R.string.account_hint))
                    },
                    onValueChange = {
                        account = it
                    }
                )
                Spacer(modifier = Modifier.height(15.dp))
                TextFieldInput(
                    stringResource(R.string.password),
                    input = password,
                    label = {
                        Text(stringResource(R.string.password_hint))
                    },
                    onValueChange = {
                        password = it
                    }
                )
                Spacer(modifier = Modifier.height(15.dp))
                ButtonRound(
                    onClick = {
                        navController.navigate(LoginMainPage.ForgetPassword.name)
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(
                        stringResource(R.string.forget_password),
                        fontSize = 16.sp,
                    )
                }
            }
        }
        Column (
            verticalArrangement = Arrangement.Center,
            //modifier = Modifier.fillMaxSize()
        ) {
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ButtonRound(
                    onClick = {

                    }
                ) {
                    Text(stringResource(R.string.clear))
                }
                Spacer(modifier = Modifier.width(15.dp))
                ButtonRound(
                    onClick = {
                        loginVM.setLogin(MainScreenPage.Main)
                    }
                ) {
                    Text(stringResource(R.string.login))
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            ButtonRound (
                onClick = {

                    navController.navigate(LoginMainPage.Register.name)
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(stringResource(R.string.register_account),)
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        navController = rememberNavController(),
        loginVM = viewModel()
    )
}
