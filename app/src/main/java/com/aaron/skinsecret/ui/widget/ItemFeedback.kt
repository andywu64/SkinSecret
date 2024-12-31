package com.aaron.skinsecret.ui.widget

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aaron.skinsecret.dataclass.user.feedback.Feedback
import java.time.LocalDateTime

@Composable
fun ItemFeedback(
    feedback: Feedback,
    modifier: Modifier = Modifier,
) {
    Column (
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(LightGray)
            .fillMaxWidth()
            .padding(15.dp),
    ) {
        Row (
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Column (
                verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier.weight(1f)
            ) {
                /*Text(
                    feedback.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )*/
                Text(
                    feedback.content,
                    modifier = Modifier
                        .height(80.dp)
                        //.weight(1f)
                )
            }
            Text("回覆時間")
        }
        HorizontalDivider(
            thickness = 2.dp,
            //color = MaterialTheme.colorScheme.secondary
            color = White
        )
        Row (
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            Column (
                verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    "官方回覆",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    feedback.reply,
                    modifier = Modifier
                        .height(80.dp)
                        //.weight(1f)
                )
            }
            Text("回覆時間")
        }
    }
}

@SuppressLint("NewApi")
@Preview(
    showBackground = true,
    backgroundColor = Color.WHITE.toLong(),
    //heightDp = 150
)
@Composable
fun ItemFeedbackPreview() {
    ItemFeedback(
        feedback = Feedback(
            id = 1,
            content = "意見1",
            reply = "回覆1",
            date = LocalDateTime.now(),
            replyDate = LocalDateTime.now().withHour(1)
        )
    )
}