package com.example.blocknotas2023.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blocknotas2023.DataBase.Mnotas.Mensajes
import com.example.blocknotas2023.DataBase.Mnotas.RepositorioMsg
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MensajesViewModel (private val repository: RepositorioMsg) : ViewModel() {
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
}