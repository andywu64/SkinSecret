package com.aaron.skinsecret.ui.feature.user.feedback.add

import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aaron.skinsecret.R
import com.aaron.skinsecret.dataclass.user.Feedback
import com.aaron.skinsecret.ui.TabVM
import com.aaron.skinsecret.ui.widget.ButtonRound
import com.aaron.skinsecret.ui.widget.TextFieldInput
import com.aaron.skinsecret.viewmodel.user.feedback.FeedbackViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FeedbackAddScreen(
    navController: NavHostController,
    feedbackVM: FeedbackViewModel = viewModel(),
    tabVM: TabVM,
    modifier: Modifier = Modifier
) {
    tabVM.updateTabState(false)
    val feedback = feedbackVM.feedbackEdit.collectAsState()
    val editMode = feedback.value.id > 0
    //var feedbackTitle by remember { mutableStateOf(feedback.value.title) }
    var feedbackContent by remember { mutableStateOf(feedback.value.content) }
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
                .background(color = LightGray)
                .padding(15.dp)
        ) {
            /*TextFieldInput(
                title = stringResource(R.string.feedback_title),
                input = feedbackTitle,
                label = {
                    Text(stringResource(R.string.title_input_pls))
                },
                onValueChange = {
                    feedbackTitle = it
                },
                modifier = Modifier
            )*/
            TextFieldInput(
                title = stringResource(R.string.feedback_content),
                input = feedbackContent,
                label = {
                    Text(stringResource(R.string.feedback_content_input_pls))
                },
                onValueChange = {
                    feedbackContent = it
                },
                modifier = Modifier,
                fieldModifier = Modifier
                    .height(200.dp)
            )
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

                    },
                    shape = RoundedCornerShape(15),
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(stringResource(R.string.cancel))
                }
                ButtonRound(
                    onClick = {
                        if (feedbackContent.isNotEmpty() &&
                            feedback.value.userId.isNotEmpty()
                        ) {
                            coroutineScope.launch {
                                if (editMode) {
                                    val response = feedbackVM.updateItem(
                                        Feedback(
                                            id = feedback.value.id,
                                            userId = feedback.value.userId,
                                            procId = feedback.value.procId,
                                            content = feedbackContent,
                                            createDate = LocalDateTime.now(),
                                            reply = feedback.value.reply,
                                            replyDate = feedback.value.replyDate,
                                        )
                                    )
                                    if (response > 0) {
                                        feedbackVM.getFeedbacks()
                                        navController.popBackStack()
                                    }
                                } else {
                                    val response = feedbackVM.createItem(
                                        userId = feedback.value.userId,
                                        procId = feedback.value.procId,
                                        content = feedbackContent,
                                        date = LocalDateTime.now(),
                                    )
                                    if (response > 0) {
                                        feedbackVM.getFeedbacks()
                                        navController.popBackStack()
                                    }
                                }
                            }
                        }
                    },
                    shape = RoundedCornerShape(15),
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        if (editMode) stringResource(R.string.edit)
                        else stringResource(R.string.add)
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview (
    showBackground = true,
    backgroundColor = Color.WHITE.toLong()
)
@Composable
fun FeedbackAddScreenPreview() {
    FeedbackAddScreen(
        navController = rememberNavController(),
        tabVM = viewModel()
    )
}
