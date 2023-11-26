package com.example.blocknotas2023.DataBase.Mnotas

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositorioMsg @Inject constructor(private val msgDB: DaoMensajes){
    val allNota: Flow<List<Mensajes>> = msgDB.getAll()
    fun addNota(nota: Mensajes)= msgDB.insert(nota)
    fun updateNota(nota: Mensajes)= msgDB.update(nota)
    fun deleteNota(nota : Mensajes)= msgDB.delete(nota)
    suspend fun deleteNotaById(id: Int) {
        msgDB.deleteNotaById(id)
    }
}