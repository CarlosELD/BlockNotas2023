package com.example.blocknotas2023.DataBase.Mcamara

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoFotos {
        @Query("SELECT * FROM fotos")
        fun getAllFotos(): Flow<List<Foto>>

        @Insert
        suspend fun addFoto(foto: Foto)
        @Delete
        suspend fun DelFoto(foto: Foto)
        @Update
        suspend fun UpFoto(foto: Foto)
}