package com.example.blocknotas2023

import android.app.AlarmManager
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.SystemClock
import com.example.blocknotas2023.components.AlarmReceiver

class AlarmApp : Application() {

    companion object {
        const val ALARM_ACTION = "com.example.blocknotas2023.ALARM_TRIGGERED"
        const val ALARM_REQUEST_CODE = 123
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()

        // Configura la alarma
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val alarmIntent = Intent(applicationContext, AlarmReceiver::class.java)
            .setAction(ALARM_ACTION)
        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            ALARM_REQUEST_CODE,
            alarmIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val triggerTime = SystemClock.elapsedRealtime() + 10 * 1000
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime, pendingIntent)
    }

    private fun createNotificationChannel() {
        val channelId = "alarm_id"
        val channelName = "alarm_name"
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_HIGH
            )
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(channel)
        }
    }
}