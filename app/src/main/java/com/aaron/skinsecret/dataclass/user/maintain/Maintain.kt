package com.aaron.skinsecret.dataclass.user.maintain

import android.annotation.SuppressLint
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Maintain(
    val id: Int,
    val userId: String,
    val reminder: LocalDateTime,    // 通知時間
    val interval: Long,         // 間隔(小時)
    val title: String,       // 標題
) {
    override fun equals(other: Any?): Boolean {
        return (
                this.id == (other as Maintain).id &&
                this.userId == other.userId &&
                this.reminder == other.reminder &&
                this.interval == other.interval &&
                this.title == other.title
                )
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    @SuppressLint("NewApi")
    fun localDateTimeToTimeString(): String {
        return reminder.toLocalTime()?.format(DateTimeFormatter.ofPattern("HH:mm"))
            ?: "--:--"
    }

    @SuppressLint("NewApi")
    fun localDateTimeToAmPmString(): String {
        return reminder.toLocalTime()?.format(DateTimeFormatter.ofPattern("a"))
            ?: "--"
    }

    @SuppressLint("NewApi")
    fun localDateTimeToRepeatString() : String {
        return if (interval % (24*30).toLong() == 0.toLong()) {
            val day = reminder.dayOfMonth
            "每月${day}日"
        } else if (interval % (24*7).toLong() == 0.toLong()) {
            val weeks = interval / (24*7)
            val weekDay = reminder.dayOfWeek
            val weekDayName = when (weekDay) {
                DayOfWeek.MONDAY -> "周一"
                DayOfWeek.TUESDAY -> "周二"
                DayOfWeek.WEDNESDAY -> "周三"
                DayOfWeek.THURSDAY -> "周四"
                DayOfWeek.FRIDAY -> "周五"
                DayOfWeek.SATURDAY -> "周六"
                DayOfWeek.SUNDAY -> "周日"
                else -> ""
            }
            if (weekDayName.isEmpty()) return ""
            when (weeks.toInt()) {
                1 -> "每$weekDayName"
                2 -> "每二$weekDayName"
                3 -> "每三$weekDayName"
                4 -> "每四$weekDayName"
                else -> ""
            }
        } else if (interval % 24.toLong() == 0.toLong()) {
            val days = interval / 24.toLong()
            "每${days}日"
        } else {
            ""
        }
    }
}
