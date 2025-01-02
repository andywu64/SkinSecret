package com.aaron.skinsecret.repository.user.feedback

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.aaron.skinsecret.dataclass.user.Feedback
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDateTime

object FeedbackRepository {
    @SuppressLint("NewApi")
    private val templateEdit = Feedback(
        id = -1,
        userId = "U00000006",
        procId = 1,
        content = "",
        reply = "",
        createDate = LocalDateTime.now(),
        replyDate = LocalDateTime.now(),
    )

    @SuppressLint("NewApi")
    private val _feedbackState = MutableStateFlow(templateEdit)
    val feedbackState: StateFlow<Feedback> = _feedbackState.asStateFlow()

    @SuppressLint("NewApi")
    fun addFeedback() {
        _feedbackState.value = templateEdit
    }

    fun setFeedback(value: Feedback) {
        _feedbackState.value = value
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun previewFeedback() : Feedback {
        return Feedback(
            id = 1,
            userId = "U00000006",
            procId = 1,
            content = "意見1",
            reply = "回覆1",
            createDate = LocalDateTime.now(),
            replyDate = LocalDateTime.now().withHour(1)
        )
    }

    @SuppressLint("NewApi")
    fun fetchFeedbacks(): List<Feedback> {
        return listOf(
            Feedback(
                id = 1,
                userId = "U00000006",
                procId = 1,
                content = "意見1",
                reply = "回覆1",
                createDate = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 2,
                userId = "U00000006",
                procId = 1,
                content = "意見2",
                reply = "回覆2",
                createDate = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 3,
                userId = "U00000006",
                procId = 1,
                content = "意見3",
                reply = "回覆3",
                createDate = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 1,
                userId = "U00000006",
                procId = 1,
                content = "意見4",
                reply = "回覆4",
                createDate = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 2,
                userId = "U00000006",
                procId = 1,
                content = "意見5",
                reply = "回覆5",
                createDate = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 1,
                userId = "U00000006",
                procId = 1,
                content = "意見6",
                reply = "回覆6",
                createDate = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 2,
                userId = "U00000006",
                procId = 1,
                content = "意見7",
                reply = "回覆7",
                createDate = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 1,
                userId = "U00000006",
                procId = 1,
                content = "意見8",
                reply = "回覆8",
                createDate = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 2,
                userId = "U00000006",
                procId = 1,
                content = "意見9",
                reply = "回覆9",
                createDate = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 1,
                userId = "U00000006",
                procId = 1,
                content = "意見10",
                reply = "回覆10",
                createDate = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 2,
                userId = "U00000006",
                procId = 1,
                content = "意見11",
                reply = "回覆11",
                createDate = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 3,
                userId = "U00000006",
                procId = 1,
                content = "意見12",
                reply = "回覆12",
                createDate = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
            Feedback(
                id = 3,
                userId = "U00000006",
                procId = 1,
                content = "意見13",
                reply = "回覆13",
                createDate = LocalDateTime.now(),
                replyDate = LocalDateTime.now().withHour(1)
            ),
        )
    }
}