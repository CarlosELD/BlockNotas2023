package com.example.blocknotas2023.DataBase.Mnotas

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import com.example.blocknotas2023.components.AlarmReceiver
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositorioMsg @Inject constructor(private val notasDB: DaoMensajes) {
    val allNotas: Flow<List<Mensajes>> = notasDB.getAll()

    fun BuscarMensajes(searchTerm: String): Flow<List<Mensajes>> {
        return notasDB.buscarMensajes(searchTerm)
    }

    suspend fun addNota(nota: Mensajes) {
        notasDB.insert(nota)
    }

    suspend fun deleteNota(nota: Mensajes) {
        notasDB.delete(nota)
    }

    suspend fun editarMensaje(mensaje: Mensajes) {
        notasDB.editarMensaje(mensaje)
    }

    suspend fun insertarConAlarma(mensaje: Mensajes, alarmTime: Long, context: Context) {
        val mensajeId = notasDB.insert(mensaje)
        programarAlarma(mensajeId, alarmTime, context)
    }

    @SuppressLint("ScheduleExactAlarm")
    private fun programarAlarma(mensajeId: Long, alarmTime: Long, context: Context) {
        val intent = Intent(context, AlarmReceiver::class.java)
        intent.putExtra("mensajeId", mensajeId)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            mensajeId.toInt(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                alarmTime,
                pendingIntent
            )
        } else {
            alarmManager.setExact(
                AlarmManager.RTC_WAKEUP,
                alarmTime,
                pendingIntent
            )
        }
    }
}
