package com.example.blocknotas2023.DataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DBNotas {
    @Query("SELECT * FROM Notas")
    fun getAllNotes(): List<Notas>

    @Insert
    fun insert(note: Notas)

    @Update
    fun update(note: Notas)

    @Delete
    fun delete(note: Notas)
}
