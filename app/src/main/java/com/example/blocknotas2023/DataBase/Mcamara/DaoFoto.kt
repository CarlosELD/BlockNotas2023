package com.example.blocknotas2023.DataBase.Mcamara

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MediaDao {
        @Insert
        suspend fun insertMediaItem(mediaItem: MediaItem)

        @Delete
        suspend fun deleteMediaItem(mediaItem: MediaItem)

        @Query("SELECT * FROM MediaItem WHERE uri LIKE '%' || :searchTerm || '%'")
        fun searchMediaItems(searchTerm: String): Flow<List<MediaItem>>
}