package com.aaron.skinsecret.ui.feature.user.feedback

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aaron.skinsecret.ui.TabVM
import com.aaron.skinsecret.ui.feature.user.feedback.add.getFeedbackAddNavigationRoute
import com.aaron.skinsecret.ui.widget.ItemFeedback
import com.aaron.skinsecret.dataclass.user.Feedback
import com.aaron.skinsecret.viewmodel.user.feedback.FeedbackViewModel
import kotlinx.coroutines.launch

@Composable
fun FeedbackScreen(
    navController: NavHostController,
    feedbackVM: FeedbackViewModel = viewModel(),
    tabVM: TabVM
) {
    tabVM.updateTabState(false)
    val feedbacks = feedbackVM.feedbacksState.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        feedbackVM.getFeedbacks()
    }

    Box {
        FeedbackLists(
            feedbacks.value,
            onItemClick = {
                feedbackVM.updateFeedbackState(it)
                navController.navigate(getFeedbackAddNavigationRoute())
            },
            onDeleteClick = {
                coroutineScope.launch {
                    if (feedbackVM.deleteItem(it.id)) {
                        feedbackVM.getFeedbacks()
                    }
                }
            }
        )
        FloatingActionButton(
            onClick = {
                feedbackVM.addFeedback()
                navController.navigate(getFeedbackAddNavigationRoute())
            },
            modifier = Modifier
                .padding(15.dp)
                .align(Alignment.BottomEnd)
        ) {
            Image(
                imageVector = Icons.Default.Add,
                contentDescription = "Add"
            )
        }
    }
}

@Composable
fun FeedbackLists(
    feedbacks: List<Feedback>,
    onItemClick: (Feedback) -> Unit,
    onDeleteClick: (Feedback) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        items(feedbacks) { feedback ->
            ItemFeedback(
                feedback = feedback,
            )
            //Spacer(Modifier.height(10.dp))
        }
    }
}

@Preview (
    showBackground = true,
    backgroundColor = Color.WHITE.toLong()
)
@Composable
fun FeedbackScreenPreview() {
    FeedbackScreen(
        navController = rememberNavController(),
        tabVM = viewModel()
    )
}
