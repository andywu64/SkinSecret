package com.aaron.skinsecret.ui.feature.home

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aaron.skinsecret.R
import com.aaron.skinsecret.ui.TabVM
import com.aaron.skinsecret.ui.widget.TextFieldInput
import com.aaron.skinsecret.util.ImageState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController(),
    tabVM: TabVM
){
    var input by remember { mutableStateOf("") }

    Scaffold (
        topBar = {
            TextFieldInput(
                input = input,
                label = {
                    Text(stringResource(R.string.enter_keyword))
                },
                imageState = ImageState(
                    title = stringResource(R.string.enter_keyword),
                    painter = rememberVectorPainter(Icons.Filled.Search)
                ),
                onValueChange = {

                }
            )
        }
    ) {
        LazyColumn {

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(tabVM = viewModel())
}