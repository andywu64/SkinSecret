package com.aaron.skinsecret.ui.feature.user.myfavorites.community

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.aaron.skinsecret.R


@Composable
fun MyFavoritesCommunityScreen() {
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(stringResource(R.string.community))
    }
}
