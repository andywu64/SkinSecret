package com.aaron.skinsecret.viewmodel.user.feedback

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aaron.skinsecret.apiservice.user.FeedbackAipInstance
import com.aaron.skinsecret.apiservice.user.maintain.MaintainAipInstance
import com.aaron.skinsecret.dataclass.user.Feedback
import com.aaron.skinsecret.dataclass.user.maintain.Maintain
import com.aaron.skinsecret.repository.user.feedback.FeedbackRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class FeedbackViewModel: ViewModel() {
    private val tag = "tag_FeedbackVM"

    private val repository = FeedbackRepository
    val feedbackEdit = repository.feedbackState

    fun addFeedback() {
        repository.addFeedback()
    }

    fun updateFeedbackState(data: Feedback){
        repository.setFeedback(data)
    }

    private val _feedbacksState = MutableStateFlow(emptyList<Feedback>())
    val feedbacksState: StateFlow<List<Feedback>> = _feedbacksState.asStateFlow()

//    init {
//        _feedbacksState.update { fetchFeedbacks() }
//    }

    // 查詢 by ID
    private suspend fun getItemById(id: Int) : Feedback? {
        try {
            val response = FeedbackAipInstance.api.getItem(id)
            return response
        } catch (e: Exception) {
            Log.e(tag, "error: ${e.message}")
            return null
        }
    }

    fun getFeedbacks() {
        viewModelScope.launch {
            _feedbacksState.update {
                getAllItems()
            }
        }
    }
    // 查詢全部
    private suspend fun getAllItems(): List<Feedback> {
        try {
            val response = FeedbackAipInstance.api.getAllItems()
            Log.d(tag, "data: $response")
            return response
        } catch (e: Exception) {
            Log.e(tag, "error: ${e.message}")
            return emptyList()
        }
    }

    // 新增
    suspend fun createItem(
        userId: String,
        procId: Int,
        content: String,
        date: LocalDateTime
    ): Int {
        try {
            val response = FeedbackAipInstance.api.createItem(
                Feedback(
                    id = 0,
                    userId = userId,
                    procId = procId,
                    content = content,
                    createDate = date,
                    reply = "",
                    replyDate = date
                )
            )
            Log.d(tag, "response: $response")
            return response
        } catch (e: Exception) {
            Log.e(tag, "error: ${e.message}")
            return -1
        }
    }

    suspend fun updateItem(item: Feedback) : Int {
        try {
            val response = FeedbackAipInstance.api.updateItem(item)
            Log.d(tag, "response: $response")
            return response
        } catch (e: Exception) {
            Log.e(tag, "error: ${e.message}")
            return -1
        }
    }

    suspend fun deleteItem(id: Int): Boolean {
        var deleted: Boolean
        try {
            val response = FeedbackAipInstance.api.deleteItem(id)
            Log.e(tag, "response: ${response.code()}")
            deleted = response.isSuccessful
        } catch (e: Exception) {
            Log.e(tag, "error: ${e.message}")
            deleted = false
        }
        return deleted
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun previewFeedback() : Feedback {
        return repository.previewFeedback()
    }
}