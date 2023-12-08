package com.example.blocknotas2023.DataBase.Mnotas

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
}