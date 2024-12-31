package com.aaron.skinsecret.dataclass.user.feedback

import java.time.LocalDateTime

data class Feedback (
    var id: Int = 0,
    var userId: String = "",
    var productId: Int = 0,
    var content: String = "",
    var reply: String = "",
    var date: LocalDateTime,
    var replyDate: LocalDateTime,
) {
    override fun equals(other: Any?): Boolean {
        return this.id == (other as Feedback).id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

}