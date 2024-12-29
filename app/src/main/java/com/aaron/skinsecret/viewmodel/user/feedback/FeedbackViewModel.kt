package com.aaron.skinsecret.viewmodel.user.feedback

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.aaron.skinsecret.dataclass.user.feedback.Feedback
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDateTime

class FeedbackViewModel: ViewModel() {
    @SuppressLint("NewApi")
    private val _feedbackEdit = MutableStateFlow(
        Feedback(
            date = LocalDateTime.now(),
            replyDate = LocalDateTime.now(),
        )
    )
    val feedbackEdit = _feedbackEdit.asStateFlow()

    fun updateFeedbackState(data: Feedback){
        _feedbackEdit.value = data
    }

    private val _feedbacksState = MutableStateFlow(emptyList<Feedback>())
    val feedbacksState: StateFlow<List<Feedback>> = _feedbacksState.asStateFlow()

    init {
        _feedbacksState.update { fetchFeedbacks() }
    }

    fun addItem(item: Feedback) {
        _feedbacksState.update {
            val feedbacks = it.toMutableList()
            feedbacks.add(item)
            feedbacks
        }
    }

    fun removeItem(item: Feedback) {
        _feedbacksState.update {
            val feedbacks = it.toMutableList()
            feedbacks.remove(item)
            feedbacks
        }
    }

    @SuppressLint("NewApi")
    private fun fetchFeedbacks(): List<Feedback> {
        return listOf(
            Feedback(
                id = 1,
                title = "意見標題1",
                content = "意見1",
                reply = "回覆1",
                date = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 2,
                title = "意見標題2",
                content = "意見2",
                reply = "回覆2",
                date = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 3,
                title = "意見標題3",
                content = "意見3",
                reply = "回覆3",
                date = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 1,
                title = "意見標題4",
                content = "意見4",
                reply = "回覆4",
                date = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 2,
                title = "意見標題5",
                content = "意見5",
                reply = "回覆5",
                date = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 1,
                title = "意見標題6",
                content = "意見6",
                reply = "回覆6",
                date = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 2,
                title = "意見標題7",
                content = "意見7",
                reply = "回覆7",
                date = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 1,
                title = "意見標題8",
                content = "意見8",
                reply = "回覆8",
                date = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 2,
                title = "意見標題9",
                content = "意見9",
                reply = "回覆9",
                date = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 1,
                title = "意見標題10",
                content = "意見10",
                reply = "回覆10",
                date = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 2,
                title = "意見標題11",
                content = "意見11",
                reply = "回覆11",
                date = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 3,
                title = "意見標題12",
                content = "意見12",
                reply = "回覆12",
                date = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 3,
                title = "意見標題13",
                content = "意見13",
                reply = "回覆13",
                date = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
        )
    }
}