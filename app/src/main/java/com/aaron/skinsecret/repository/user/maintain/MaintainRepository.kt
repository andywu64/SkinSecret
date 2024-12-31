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
}