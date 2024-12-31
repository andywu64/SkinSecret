package com.aaron.skinsecret.repository.user.maintain

import android.annotation.SuppressLint
import com.aaron.skinsecret.dataclass.user.maintain.Maintain
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDateTime

object MaintainRepository {
    @SuppressLint("NewApi")
    private val _maintainState = MutableStateFlow(Maintain(
        id = -1,
        userId = "",
        title = "",
        reminder = LocalDateTime.now(),
        interval = 0
    ))
    val maintainState: StateFlow<Maintain> = _maintainState.asStateFlow()

    fun setMaintain(value: Maintain) {
        _maintainState.value = value
    }
}