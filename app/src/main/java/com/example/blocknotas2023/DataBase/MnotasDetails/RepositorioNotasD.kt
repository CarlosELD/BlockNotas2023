package com.example.blocknotas2023.DataBase.MnotasDetails

import com.example.blocknotas2023.DataBase.Mnotas.DaoMensajes
import com.example.blocknotas2023.DataBase.Mnotas.Mensajes
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositorioNotasD @Inject constructor(private val notasDB: DaoMensajes){
    val allNotas: Flow<List<Mensajes>> = notasDB.getAll()
    fun addNota(nota: Mensajes)= notasDB.insert(nota)
    fun updateNota(nota: Mensajes)= notasDB.update(nota)
    fun deleteNota(nota : Mensajes)= notasDB.delete(nota)
}