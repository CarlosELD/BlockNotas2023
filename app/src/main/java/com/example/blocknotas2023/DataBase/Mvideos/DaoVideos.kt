package com.example.blocknotas2023.DataBase.Mvideos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoVideo {
    @Query("SELECT * FROM videos")
    fun getAll(): Flow<List<Video>>

    @Insert
    suspend fun insertV(video: Video)

    @Update
    suspend fun updateV(video: Video)

    @Delete
    suspend fun deleteV(video: Video)
}