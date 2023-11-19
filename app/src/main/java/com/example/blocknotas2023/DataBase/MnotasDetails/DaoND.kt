package com.example.blocknotas2023.DataBase.MnotasDetails

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
@Dao
interface DaoND {
    @Query("SELECT * FROM notas_descriptivas")
    fun getAllNotasD(): List<NotasD>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(notaDescriptiva: NotasD)
    @Delete
    suspend fun DNota(nota: NotasD)
    @Update
    suspend fun UNota(notas: NotasD)
}