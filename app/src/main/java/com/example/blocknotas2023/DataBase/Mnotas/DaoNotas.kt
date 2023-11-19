package com.example.blocknotas2023.DataBase.Mnotas

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoNotas {
    @Query("SELECT * FROM notas")
    fun getAll(): Flow<List<Notas>>

    @Query("SELECT * FROM Notas WHERE id = :noteId")
    suspend fun getNoteById(noteId: Int): Notas?
    @Insert
    fun insert(notas: Notas)

    @Delete
    fun delete(notas: Notas)

    @Query("DELETE FROM Notas")
    suspend fun deleteAll()

    @Update
    fun update(notas: Notas)

    @Query("SELECT * FROM Notas WHERE title LIKE :query")
    fun BuscarPorTitulo(query: String): Flow<List<Notas>>
}