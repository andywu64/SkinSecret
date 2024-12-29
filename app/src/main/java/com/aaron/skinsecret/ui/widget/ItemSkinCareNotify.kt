package com.aaron.skinsecret.ui.widget

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aaron.skinsecret.dataclass.user.maintain.Maintain
import java.time.LocalDateTime

@SuppressLint("NewApi")
@Composable
fun ItemSkinCareNotify(
    maintain: Maintain,
    modifier: Modifier = Modifier,
    onItemClick: (() -> Unit)? = null,
    onDeleteClick: (() -> Unit)? = null
) {
    Row (
        modifier = modifier
            .clickable { onItemClick?.let { it() } }
            .padding(10.dp)
            .height(100.dp)
            .fillMaxWidth()
    ){
        Column (
            modifier = Modifier
                .weight(1f)
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications",
                )
                Text(
                    maintain.title,
                    modifier = Modifier.weight(1f)
                )
            }
            Row (
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    maintain.localDateTimeToTimeString(),
                    fontSize = 36.sp,
                    modifier = Modifier
                        .align(Alignment.Bottom)
                )
                Text(
                    maintain.localDateTimeToAmPmString(),
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
                    maintain.localDateTimeToRepeatString(),
                )
            }
            IconButton (
                onClick = onDeleteClick ?: {},
                modifier = Modifier.fillMaxHeight()
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "trash",
                )
            }
        }
    }
}

@SuppressLint("NewApi")
@Preview (
    showBackground = true,
    backgroundColor = Color.LTGRAY.toLong(),
)
@Composable
fun ItemSkinCareNotifyPreview() {
    ItemSkinCareNotify(
        maintain = Maintain(
            id = 1,
            userId = "U000001",
            reminder = LocalDateTime.now(),
            interval = 24*30,
            title = "晨間保養"
        )
    )
}