package com.aaron.skinsecret.ui.widget.datetime

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import java.time.LocalDateTime

@SuppressLint("NewApi")
@Composable
fun DateTimePickerWidget(
    datetime: LocalDateTime,
    selectedDatetime: (LocalDateTime) -> Unit
) {
    val date by remember { mutableStateOf(datetime.toLocalDate()) }
    val time by remember { mutableStateOf(datetime.toLocalTime()) }
    Row {
        DatePickerWidget (
            date = date
        ) {
            selectedDatetime(date.atTime(time))
        }
        TimePickerWidget (
            time = time
        ) {
            selectedDatetime(date.atTime(time))
        }
    }
}

@SuppressLint("NewApi")
@Preview(
    showBackground = true,
    backgroundColor = Color.LTGRAY.toLong(),
    //heightDp = 400,
    //widthDp = 200
)
@Composable
fun DateTimePickerWidgetPreview() {
    DateTimePickerWidget (
        datetime = LocalDateTime.now()
    ) {
        Log.d("tag_DatePickerWidgetPreview", "picker date = $it")
    }
}