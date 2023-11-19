package com.example.blocknotas2023.DataBase.Mvideos

import com.example.blocknotas2023.DataBase.Mnotas.DaoNotas
import com.example.blocknotas2023.DataBase.Mnotas.Notas
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositorioVideo @Inject constructor(private val notasDB: DaoNotas){
    val all: Flow<List<Notas>> = notasDB.getAll()
    suspend fun addNota(nota: Notas)= notasDB.insert(nota)
    suspend fun updateNota(nota: Notas)= notasDB.update(nota)
    suspend fun deleteNota(nota : Notas)= notasDB.delete(nota)
}