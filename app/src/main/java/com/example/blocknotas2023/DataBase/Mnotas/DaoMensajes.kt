package com.example.blocknotas2023.DataBase.Mnotas

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoMensajes {
    @Query("SELECT * FROM mensajes")
    fun getAll(): Flow<List<Mensajes>>

    @Query("SELECT * FROM mensajes WHERE :searchTerm = '' OR title LIKE '%' || :searchTerm || '%' OR contenido LIKE '%' || :searchTerm || '%'")
    fun buscarMensajes(searchTerm: String): Flow<List<Mensajes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mensaje: Mensajes): Long

    @Update
    suspend fun update(mensaje: Mensajes)

    @Delete
    suspend fun delete(mensaje: Mensajes)

    @Update
    suspend fun editarMensaje(mensaje: Mensajes)
}