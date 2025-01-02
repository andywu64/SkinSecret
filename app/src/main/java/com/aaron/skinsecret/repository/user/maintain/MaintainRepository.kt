package com.aaron.skinsecret.repository.user.maintain

import android.annotation.SuppressLint
import com.aaron.skinsecret.dataclass.user.maintain.Maintain
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDateTime

object MaintainRepository {
    @SuppressLint("NewApi")
    private val newMaintainTemplate = Maintain(
        id = -1,
        userId = "U00000006",
        title = "",
        reminder = LocalDateTime.now(),
        interval = 0
    )

    @SuppressLint("NewApi")
    private val _maintainState = MutableStateFlow(newMaintainTemplate)
    val maintainState: StateFlow<Maintain> = _maintainState.asStateFlow()

    @SuppressLint("NewApi")
    fun addNewMaintain() {
        _maintainState.value = newMaintainTemplate
    }

    fun setMaintain(value: Maintain) {
        _maintainState.value = value
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