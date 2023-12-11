package com.example.blocknotas2023.viewModel

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blocknotas2023.DataBase.Mnotas.Mensajes
import com.example.blocknotas2023.DataBase.Mnotas.RepositorioMsg
import com.example.blocknotas2023.MainActivity
import com.example.blocknotas2023.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MensajesViewModel(private val repository: RepositorioMsg) : ViewModel() {
    private val _mensajes = MutableStateFlow<List<Mensajes>>(emptyList())
    val mensajes: StateFlow<List<Mensajes>> get() = _mensajes
    private var currentSearchTerm = ""

    fun insertar(mensaje: Mensajes) {
        viewModelScope.launch {
            repository.addNota(mensaje)
        }
    }

    fun editarMensaje(mensaje: Mensajes) {
        viewModelScope.launch {
            repository.editarMensaje(mensaje)
        }
    }

    fun eliminarMensaje(mensaje: Mensajes) {
        viewModelScope.launch {
            repository.deleteNota(mensaje)
        }
    }

    fun searchMensajes(searchTerm: String) {
        viewModelScope.launch {
            repository.BuscarMensajes(searchTerm).collect {
                _mensajes.value = it
            }
        }
    }

    fun refreshList() {
        searchMensajes(currentSearchTerm)
    }

    fun insertarConAlarma(mensaje: Mensajes, alarmTime: Long, context: Context) {
        viewModelScope.launch {
            val mensajeId = repository.insertarConAlarma(mensaje, alarmTime,context)
        }
    }
}

fun establecerAlarmaYNotificacion(
    mensajeId: Long,
    messageTitle: String,
    context: Context
) {
    val intent = Intent(context, MainActivity::class.java)
    intent.putExtra("mensajeId", mensajeId)

    val pendingIntent = PendingIntent.getActivity(
        context,
        mensajeId.toInt(),
        intent,
        PendingIntent.FLAG_UPDATE_CURRENT
    )
    val notificationManager = ContextCompat.getSystemService(context, NotificationManager::class.java)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            "channel_id",
            "Nombre del Canal",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationManager?.createNotificationChannel(channel)
    }

    val notification = NotificationCompat.Builder(context, "channel_id")
        .setContentTitle("Nueva Notificación")
        .setContentText("Mensaje: $messageTitle")
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .build()

    notificationManager?.notify(mensajeId.toInt(), notification)
}
