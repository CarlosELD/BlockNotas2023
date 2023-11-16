package com.example.blocknotas2023.DataBase

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

    @Query("SELECT * FROM notas where id=:id")
    fun getOne(id:Long): Flow<Notas>
    @Insert
    fun insert(notas: Notas)

    @Delete
    fun delete(notas: Notas)

    @Update
    fun update(notas: Notas)
}