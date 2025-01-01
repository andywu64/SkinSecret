package com.aaron.skinsecret.ui.widget.datetime

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import java.time.LocalTime
import java.time.format.DateTimeFormatter.ofLocalizedTime
import java.time.format.FormatStyle

@SuppressLint("NewApi")
@Composable
fun TimePickerWidget(
    isClickable: Boolean = true,
    time: LocalTime,
    modifier: Modifier = Modifier,
        //.fillMaxSize()
        //.padding(top = 64.dp),
    onSelectedTime: (LocalTime) -> Unit
) {
    var showTimePickerDialog by remember { mutableStateOf(false) }
    var timeNow by remember { mutableStateOf(time) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        // 點擊按鈕會跳出time picker dialog
        Button(
            enabled = isClickable,
            onClick = { showTimePickerDialog = true },
            colors = ButtonColors(
                containerColor = Transparent,
                disabledContainerColor = Transparent,
                contentColor = Transparent,
                disabledContentColor = Transparent
            )
        ) {
            Text(
                timeNow.format(ofLocalizedTime(FormatStyle.SHORT)),
                color = Gray
            )
        }
        if (showTimePickerDialog) {
            PickerDialog(
                initTime = timeNow,
                // 確定時會接收到選取時間
                onConfirm = {
                    timeNow = it
                    showTimePickerDialog = false
                    onSelectedTime(it)
                },
                // 設定取消時欲執行內容
                onDismiss = {
                    showTimePickerDialog = false
                }
            )
        }
    }
}

@SuppressLint("NewApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PickerDialog(
    initTime: LocalTime,
    onConfirm: (LocalTime) -> Unit,
    onDismiss: () -> Unit
) {
    // 呼叫rememberTimePickerState()建立TimePickerState物件並會記住TimePicker狀態
    val timePickerState = rememberTimePickerState(
        initialHour = initTime.hour,
        initialMinute = initTime.minute
    )
    // 函式庫沒有TimePickerDialog，可使用自訂Dialog達到同樣目的
    Dialog(onDismissRequest = { onDismiss() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            // 形狀設定為圓角矩形
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                // 建立TimePicker讓使用者可選擇時間
                TimePicker(state = timePickerState)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    // 設定取消按鈕
                    TextButton(
                        onClick = { onDismiss() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Cancel")
                    }
                    // 設定確定按鈕
                    TextButton(
                        // 點擊確定按鈕時呼叫onConfirm(LocalTime)並將選取時間傳入以回饋給原畫面
                        onClick = {
                            val selectedTime =
                                LocalTime.of(timePickerState.hour, timePickerState.minute)
                            // 呼叫onConfirm
                            onConfirm(selectedTime)
                        },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("OK")
                    }
                }
            }
        }
    }
}

@SuppressLint("NewApi")
@Preview(
    showBackground = true,
    backgroundColor = Color.LTGRAY.toLong(),
)
@Composable
fun TimePickerWidgetPreview() {
    TimePickerWidget(
        time = LocalTime.now()
    ) {
        Log.d("tag_TimePickerWidgetPreview", "time = $it")
    }
}