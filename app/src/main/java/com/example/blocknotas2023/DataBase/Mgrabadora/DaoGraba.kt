package com.example.blocknotas2023.DataBase.Mgrabadora

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoGraba {
    @Query("SELECT * FROM audios")
    fun getAllAudios(): Flow<List<graba>>

    @Insert
    suspend fun addAudio(audio: graba)

    @Delete
    suspend fun DelAudio(audio: graba)

    @Update
    suspend fun UpAudio(audio: graba)
}