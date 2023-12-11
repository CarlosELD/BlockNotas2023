@file:Suppress("DEPRECATION")

package com.example.blocknotas2023.components

import java.util.Calendar
import java.util.Locale

object TimeConverter {
    fun fromTimeToCalendar(time: Calendar): Calendar {
        return time
    }

    fun fromCalendarToTime(calendar: Calendar): Calendar {
        return calendar
    }

    fun formatTime(timeInMillis: Long): String {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeInMillis
        val hour = calendar[Calendar.HOUR_OF_DAY]
        val minute = calendar[Calendar.MINUTE]
        return String.format(Locale.getDefault(), "%02d:%02d", hour, minute)
    }
}