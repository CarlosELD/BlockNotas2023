package com.example.blocknotas2023.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.blocknotas2023.DataBase.Mnotas.Mensajes

class MensajesViewModel : ViewModel() {
    private val _mensajes = mutableStateListOf(
        Mensajes(id = 0, title = "", contenido = "")
    )
    val mensajes: SnapshotStateList<Mensajes> = _mensajes

    fun insertar(mensaje: Mensajes) {
        _mensajes.add(mensaje)
    }
    fun editarMensaje(mensajeEditado: Mensajes) {
        val index = _mensajes.indexOfFirst { it.id == mensajeEditado.id }
        if (index != -1) {
            _mensajes[index] = mensajeEditado
        }
    }

    fun actualizarMensaje(mensaje: Mensajes) {
        val index = _mensajes.indexOfFirst { it.id == mensaje.id }
        if (index != -1) {
            _mensajes[index] = mensaje
        }
    }
    fun eliminarMensaje(mensaje: Mensajes) {
        _mensajes.remove(mensaje)
    }
}