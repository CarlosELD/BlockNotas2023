package com.example.blocknotas2023.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blocknotas2023.DataBase.Mnotas.Mensajes
import com.example.blocknotas2023.DataBase.Mnotas.RepositorioMsg
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MensajesViewModel (private val repository: RepositorioMsg) : ViewModel() {
    val mensajes: Flow<List<Mensajes>> = repository.allNotas

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
}