package com.aaron.skinsecret.ui.widget

import android.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemFeedback() {
    Column (
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Row {
            Column (
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    "意見標題",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "意見內容"
                )
            }
            Text("回覆時間")
        }
        HorizontalDivider(
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.secondary
        )
        Row {
            Column (
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    "官方回覆",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "官方回覆內容"
                )
            }
            Text("回覆時間")
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = Color.LTGRAY.toLong(),
    heightDp = 150
)
@Composable
fun ItemFeedbackPreview() {
    ItemFeedback()
}