package com.aaron.skinsecret.ui.feature.user.maintain.add

import android.graphics.Color
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aaron.skinsecret.R
import com.aaron.skinsecret.ui.feature.TabVM
import com.aaron.skinsecret.ui.theme.WhiteSmoke
import com.aaron.skinsecret.ui.widget.ButtonRound
import com.aaron.skinsecret.ui.widget.DropDownMenuWidget
import com.aaron.skinsecret.ui.widget.SuggestionChipWidget
import com.aaron.skinsecret.ui.widget.TextFieldInput
import com.aaron.skinsecret.ui.widget.datetime.DateTimePickerWidget
import com.aaron.skinsecret.viewmodel.user.maintain.MaintainViewModel
import kotlinx.coroutines.launch

enum class RepeatType {
    Day,
    Week,
    Month
}

@Composable
fun MaintainAddScreen(
    navController: NavHostController,
    maintainVM: MaintainViewModel,
    tabVM: TabVM,
    modifier: Modifier = Modifier
) {
    tabVM.updateTabState(false)
    val maintain = maintainVM.maintainEdit.collectAsState()
    var title by remember { mutableStateOf(maintain.value.title) }
    var reminder by remember { mutableStateOf(maintain.value.reminder) }
    var interval by remember { mutableLongStateOf(maintain.value.interval) }
    var showIntervalSelector by remember { mutableStateOf(false) }
    var repeatType by remember { mutableStateOf(RepeatType.Day) }
    val coroutineScope = rememberCoroutineScope()

    Column (
        modifier = modifier
            .padding(15.dp)
            .fillMaxSize()
    ) {
        Column (
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(color = WhiteSmoke)
                .padding(15.dp)
        ) {
            Column {
                TextFieldInput(
                    title = stringResource(R.string.maintain_notify_name),
                    input = title,
                    onValueChange = {
                        title = it
                    },
                    modifier = Modifier
                )
            }
            HorizontalDivider(color = White, thickness = 3.dp)
            Column {
                Text(stringResource(R.string.maintain_notify_set_datetime))
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "calendar"
                    )
                    DateTimePickerWidget(
                        datetime = reminder
                    ) {
                        reminder = it
                    }
                }
            }
            HorizontalDivider(color = White, thickness = 3.dp)
            Column {
                Text(stringResource(R.string.repeat))
                Row (
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        interval.toString(),
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .weight(3f)
                            .clickable {
                                showIntervalSelector = true
                            }
                    )
                    DropDownMenuWidget(
                        expanded = showIntervalSelector,
                        items = getDropDownItems(repeatType),
                        onDismissRequest = {
                            showIntervalSelector = false
                        }
                    ) {
                        interval = it.toLong()
                        showIntervalSelector = false
                    }
                    RepeatChoose(
                        repeatType = repeatType,
                        modifier = Modifier.weight(4f)
                    ) {
                        repeatType = it
                    }
                }
            }
        }
        Column (
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .padding(bottom = 20.dp)
                .weight(1f)
        ) {
            Row (
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ButtonRound(
                    onClick = {
                        navController.popBackStack()
                    },
                    shape = RoundedCornerShape(15),
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(stringResource(R.string.cancel))
                }
                ButtonRound(
                    onClick = {
                        if (title.isNotEmpty() &&
                            interval > 0 &&
                            maintain.value.userId.isNotEmpty()
                            ) {
                            coroutineScope.launch {
                                val response = maintainVM.createItem(
                                    userId = maintain.value.userId,
                                    reminder = reminder,
                                    interval = interval,
                                    title = title,
                                )
                                if (response > 0) {
                                    maintainVM.getMaintains()
                                    navController.popBackStack()
                                }
                            }
                        }
                    },
                    shape = RoundedCornerShape(15),
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(stringResource(R.string.add))
                }
            }
        }
    }
}

fun getDropDownItems(
    repeatType: RepeatType
) : Map<String, Int> {
    return when (repeatType) {
        // 之後有時闁再調整依選定的日期來判斷要顯示一個月的天數
        RepeatType.Day -> (1..31).withIndex().associate {
            (it.index + 1).toString() to it.value
        }
        // 之後有時間再調整依選定的日期來判斷要顯示一個月的週數
        RepeatType.Week -> (1..4).withIndex().associate {
            (it.index + 1).toString() to it.value
        }
        RepeatType.Month -> (1..12).withIndex().associate {
            (it.index + 1).toString() to it.value
        }
    }
}

@Composable
fun RepeatChoose(
    repeatType: RepeatType,
    modifier: Modifier = Modifier,
    callback: (RepeatType) -> Unit
) {
    Log.d("tag_maintain_add_screen", "show RepeatChoose")
    Row (
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        SuggestionChipWidget(
            enabled = repeatType != RepeatType.Day,
            onClick = {
                callback(RepeatType.Day)
            },
            label = {
                Text(stringResource(R.string.day))
            }
        )
        SuggestionChipWidget(
            enabled = repeatType != RepeatType.Week,
            onClick = {
                callback(RepeatType.Week)
            },
            label =  {
                Text(stringResource(R.string.week))
            }
        )
        SuggestionChipWidget(
            enabled = repeatType != RepeatType.Month,
            onClick = {
                callback(RepeatType.Month)
            },
            label = {
                Text(stringResource(R.string.month))
            }
        )
    }
}

@Preview (
    showBackground = true,
    backgroundColor = Color.WHITE.toLong()
)
@Composable
fun MaintainAddScreenPreview() {
    MaintainAddScreen(
        navController = rememberNavController(),
        maintainVM = viewModel(),
        tabVM = viewModel()
    )
}

@Preview (
    showBackground = true,
    backgroundColor = Color.WHITE.toLong()
)
@Composable
fun RepeatChoosePreview() {
    var repeatType by remember { mutableStateOf(RepeatType.Day) }
    RepeatChoose(
        repeatType = repeatType,
    ) {
        repeatType = it
    }
}
