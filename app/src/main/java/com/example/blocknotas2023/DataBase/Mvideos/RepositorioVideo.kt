package com.example.blocknotas2023.DataBase.Mvideos

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositorioVideo @Inject constructor(private val notasDB: DaoVideo){
    val all: Flow<List<Video>> = notasDB.getAll()
    suspend fun addNota(video: Video)= notasDB.insertV(video)
    suspend fun updateNota(video: Video)= notasDB.updateV(video)
    suspend fun deleteNota(video : Video)= notasDB.deleteV(video)
}