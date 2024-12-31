package com.aaron.skinsecret.viewmodel.user.maintain

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aaron.skinsecret.apiservice.user.maintain.MaintainAipInstance
import com.aaron.skinsecret.dataclass.user.maintain.Maintain
import com.aaron.skinsecret.repository.user.maintain.MaintainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class MaintainViewModel: ViewModel() {
    private val tag = "tag_MaintainVM"

    private val repository = MaintainRepository
    val maintainEdit = repository.maintainState

    fun updateMaintainState(data: Maintain){
        repository.setMaintain(data)
    }

    private val _maintainsState = MutableStateFlow(emptyList<Maintain>())
    val maintainsState: StateFlow<List<Maintain>> = _maintainsState.asStateFlow()

    init {
        /*_maintainsState.update { fetchMaintains() }*/
        getMaintains()
        /*viewModelScope.launch {
            getItemById(1)
        }*/
    }

    // 查詢 by ID
    private suspend fun getItemById(id: Int) : Maintain? {
        try {
            val response = MaintainAipInstance.api.getMaintain(id)
            return response
        } catch (e: Exception) {
            Log.e(tag, "error: ${e.message}")
            return null
        }
    }

    fun getMaintains() {
        viewModelScope.launch {
            _maintainsState.update {
                getAllItems()
            }
        }
    }
    // 查詢全部
    private suspend fun getAllItems(): List<Maintain> {
        try {
            val response = MaintainAipInstance.api.getAllMaintain()
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
        interval: Long,
        title: String,
        reminder: LocalDateTime
    ): Int {
        try {
            val response = MaintainAipInstance.api.createMaintain(
                Maintain(
                    id = 0,
                    userId = userId,
                    interval = interval,
                    title = title,
                    reminder = reminder
                )
            )
            Log.d(tag, "response: $response")
            return response
        } catch (e: Exception) {
            Log.e(tag, "error: ${e.message}")
            return -1
        }
    }

    /*fun updateItem(item: Maintain) {
        _maintainsState.update {
            val maintains = it.toMutableList()
            maintains.add(item)
            maintains
        }
    }*/

    suspend fun updateItem(item: Maintain) : Maintain? {
        try {
            val response = MaintainAipInstance.api.updateMaintain(item)
            Log.d(tag, "response: $response")
            return response
        } catch (e: Exception) {
            Log.e(tag, "error: ${e.message}")
            return null
        }
    }

    /*fun removeItem(item: Maintain) {
        _maintainsState.deleteMaintain {
            val maintains = it.toMutableList()
            maintains.remove(item)
            maintains
        }
    }*/

    suspend fun deleteItem(id: Int): Boolean {
        var deleted: Boolean
        try {
            val response = MaintainAipInstance.api.deleteMaintain(id)
            Log.e(tag, "response: ${response.code()}")
            deleted = response.isSuccessful
        } catch (e: Exception) {
            Log.e(tag, "error: ${e.message}")
            deleted = false
        }
        return deleted
    }

    @SuppressLint("NewApi")
    private fun fetchMaintains(): List<Maintain> {
        return listOf(
            Maintain(
                id = 1,
                userId = "U00000001",
                reminder = LocalDateTime.now(),
                interval = 24,
                title = "一日保養"
            ),
            Maintain(
                id = 2,
                userId = "U00000001",
                reminder = LocalDateTime.now(),
                interval = 24*7,
                title = "一周保養"
            ),
            Maintain(
                id = 3,
                userId = "U00000001",
                reminder = LocalDateTime.now(),
                interval = 24*30,
                title = "一月保養"
            ),
            Maintain(
                id = 1,
                userId = "U00000001",
                reminder = LocalDateTime.now(),
                interval = 24*2,
                title = "二日保養"
            ),
            Maintain(
                id = 2,
                userId = "U00000001",
                reminder = LocalDateTime.now(),
                interval = 24*7*2,
                title = "二周保養"
            ),
            Maintain(
                id = 1,
                userId = "U00000001",
                reminder = LocalDateTime.now(),
                interval = 24*3,
                title = "三日保養"
            ),
            Maintain(
                id = 2,
                userId = "U00000001",
                reminder = LocalDateTime.now(),
                interval = 24*7*3,
                title = "三周保養"
            ),
            Maintain(
                id = 1,
                userId = "U00000001",
                reminder = LocalDateTime.now(),
                interval = 24*4,
                title = "四日保養"
            ),
            Maintain(
                id = 2,
                userId = "U00000001",
                reminder = LocalDateTime.now(),
                interval = 24*7*4,
                title = "四周保養"
            ),
            Maintain(
                id = 1,
                userId = "U00000001",
                reminder = LocalDateTime.now(),
                interval = 24*5,
                title = "五日保養"
            ),
            Maintain(
                id = 2,
                userId = "U00000001",
                reminder = LocalDateTime.now(),
                interval = 24*6,
                title = "六日保養"
            ),
            Maintain(
                id = 3,
                userId = "U00000001",
                reminder = LocalDateTime.now(),
                interval = 24*7,
                title = "七日保養"
            ),
            Maintain(
                id = 3,
                userId = "U00000001",
                reminder = LocalDateTime.now(),
                interval = 24*30,
                title = "三十日保養"
            ),
        )
    }
}