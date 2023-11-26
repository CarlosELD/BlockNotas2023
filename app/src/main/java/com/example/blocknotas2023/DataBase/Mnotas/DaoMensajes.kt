package com.example.blocknotas2023.DataBase.Mnotas

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoMensajes {
    @Query("SELECT * FROM mensajes")
    fun getAll(): Flow<List<Mensajes>>

    @Query("SELECT * FROM mensajes WHERE id = :Id")
    suspend fun getNoteById(Id: Int): Mensajes?
    @Insert
    fun insert(msg: Mensajes)

    @Delete
    fun delete(msg: Mensajes)

    @Query("DELETE FROM mensajes WHERE id = :Id")
    suspend fun deleteNotaById(Id: Int)

    @Update
    fun update(msg: Mensajes)

    @Query("SELECT * FROM mensajes WHERE title LIKE :query")
    fun BuscarPorTitulo(query: String): Flow<List<Mensajes>>
}