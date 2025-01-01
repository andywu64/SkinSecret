package com.aaron.skinsecret.ui.widget.datetime

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
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
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

@SuppressLint("RememberReturnType", "NewApi")
@Composable
fun DatePickerWidget(
    isClickable: Boolean = true,
    date: LocalDate,
    modifier: Modifier = Modifier,
    //.fillMaxSize()
    //.padding(top = 64.dp),
    onSelectedDate: (LocalDate) -> Unit
) {
    var showDatePickerDialog by remember { mutableStateOf(false) }
    var dateMillis by remember { mutableStateOf(date) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        // 點擊按鈕會跳出DatePickerDialog
        Button(
            onClick = { showDatePickerDialog = true },
            colors = ButtonColors(
                containerColor = Transparent,
                disabledContainerColor = Transparent,
                contentColor = Transparent,
                disabledContentColor = Transparent
            )
        ) {
            Text(
                //dateMillis.format(ofLocalizedDate(FormatStyle.MEDIUM)),
                convertMillisToDate(dateMillis),
                color = Gray
            )
        }
        if (showDatePickerDialog) {
            PickerDialog(
                onDismissRequest = {
                    showDatePickerDialog = false
                },
                // 確定時會接收到選取日期
                onConfirm = {
                    it?.let {
                        val datetime = Instant.ofEpochMilli(it).atZone(ZoneId.of("UTC"))
                            .toLocalDate()
                        dateMillis = datetime
                        onSelectedDate(datetime)
                    }
                    showDatePickerDialog = false
                },
                // 設定取消時欲執行內容
                onDismiss = {
                    showDatePickerDialog = false
                }
            )
        }
    }
}

// 使用的DatePicker屬於androidx.compose.material3測試功能，需要加上"@OptIn"註記
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PickerDialog(
    onDismissRequest: () -> Unit,
    onConfirm: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState(
        // SelectableDates介面用來限制可選擇的日期與年
        selectableDates = object : SelectableDates {
            // 將顯示的日期逐一傳給utcTimeMillis參數，回傳true代表該日可選；false代表該日不可選
            @SuppressLint("NewApi")
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                /* 將utcTimeMillis轉成LocalDate物件後取出星期幾的資訊，API 26開始支援Instant */
                val dayOfWeek = Instant.ofEpochMilli(utcTimeMillis).atZone(ZoneId.of("UTC"))
                    .toLocalDate().dayOfWeek
                // 設定週六日不可選擇
                return dayOfWeek != DayOfWeek.SUNDAY && dayOfWeek != DayOfWeek.SATURDAY
            }

            // 將顯示的年逐一傳給year參數，回傳true代表該年可選；false代表該年不可選
            override fun isSelectableYear(year: Int): Boolean {
                return year >= 2024
            }
        }
    )

    DatePickerDialog(
        // 點擊對話視窗外部或back按鈕時呼叫，並非點擊dismissButton時呼叫
        onDismissRequest = onDismissRequest,
        confirmButton = {
            Button(
                // 點擊確定按鈕時呼叫onConfirm(Long?)並將選取日期傳入以回饋給原畫面
                onClick = {
                    onConfirm(datePickerState.selectedDateMillis)
                }
            ) {
                Text("OK")
            }
        },
        // 設定取消按鈕
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}

@SuppressLint("NewApi")
fun localDateToMillis(localDate: LocalDate): Long {
    val localDateTime = localDate.atStartOfDay()
    return localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli()
}

@SuppressLint("NewApi")
private fun localDateTimeToMillis(localDateTime: LocalDateTime): Long {
    return localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli()
}

@SuppressLint("NewApi")
fun convertMillisToDate(date: LocalDate): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")
    //val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    //return formatter.format(date)
    return date.format(formatter)
}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}

@SuppressLint("NewApi")
fun localDateTimeToDateString(datetime: LocalDateTime): String {
    return datetime.toLocalTime()?.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
        ?: "----/--/--"
}


@SuppressLint("NewApi")
fun localDateTimeToTimeString(datetime: LocalDateTime): String {
    return datetime.toLocalTime()?.format(DateTimeFormatter.ofPattern("HH:mm"))
        ?: "--:--"
}

@SuppressLint("NewApi")
@Preview(
    showBackground = true,
    backgroundColor = Color.LTGRAY.toLong(),
    //heightDp = 400,
    //widthDp = 200
)
@Composable
fun DatePickerWidgetPreview() {
    DatePickerWidget (
        date = LocalDate.now()
    ) {
        Log.d("tag_DatePickerWidgetPreview", "picker date = $it")
    }
}
