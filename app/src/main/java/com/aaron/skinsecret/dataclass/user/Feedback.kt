package com.aaron.skinsecret.dataclass.user

import java.time.LocalDateTime

data class Feedback (
    var id: Int,
    var userId: String,
    var procId: Int,
    var content: String,
    var reply: String,
    var createDate: LocalDateTime,
    var replyDate: LocalDateTime,
) {
    override fun equals(other: Any?): Boolean {
        return this.id == (other as Feedback).id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

}