package com.aaron.skinsecret.ui.widget

import android.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemSkinCareNotify(
    modifier: Modifier = Modifier
) {
    Row (
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
    ){
        Column (
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifications",
                modifier = Modifier.weight(1f)
            )
            Row (
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    "09:00",
                    fontSize = 36.sp
                )
                Text(
                    "am",
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.Bottom)
                )
            }
        }
        Row (
            horizontalArrangement = Arrangement.spacedBy(10.dp)
            //modifier = Modifier.padding(end = 10.dp)
        ) {
            Column (
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    "每周一",
                )
            }
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifications",
                modifier = Modifier.fillMaxHeight()
            )
        }
    }
}

@Preview (
    showBackground = true,
    backgroundColor = Color.LTGRAY.toLong(),
    heightDp = 100
)
@Composable
fun ItemSkinCareNotifyPreview() {
    ItemSkinCareNotify()
}