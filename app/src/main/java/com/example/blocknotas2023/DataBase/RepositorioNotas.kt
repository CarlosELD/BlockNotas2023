package com.example.blocknotas2023.DataBase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import java.util.concurrent.Flow
import javax.inject.Inject

class RepositorioNotas @Inject constructor(private val notasDB: DaoNotas){
    suspend fun addNota(nota : Notas)= notasDB.insert(nota)
    suspend fun updateNota(nota :Notas)= notasDB.update(nota)
    suspend fun deleteNota(nota :Notas)= notasDB.delete(nota)
    fun getAllNotas(): kotlinx.coroutines.flow.Flow<List<Notas>> = notasDB.getAll().flowOn(Dispatchers.IO).conflate()
    fun getNotasByID(id:Long): kotlinx.coroutines.flow.Flow<Notas> = notasDB.getOne(id).flowOn(Dispatchers.IO).conflate()
}